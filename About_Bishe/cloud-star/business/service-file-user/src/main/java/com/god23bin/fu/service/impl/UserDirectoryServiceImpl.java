package com.god23bin.fu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.god23bin.fu.entity.File;
import com.god23bin.fu.entity.TNode;
import com.god23bin.fu.entity.UserDirectory;
import com.god23bin.fu.entity.vo.FolderVo;
import com.god23bin.fu.mapper.FileMapper;
import com.god23bin.fu.mapper.UserDirectoryMapper;
import com.god23bin.fu.service.FileService;
import com.god23bin.fu.service.UserDirectoryService;
import com.god23bin.fu.utils.UtilOfTNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户目录结构表 服务实现类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@Service
public class UserDirectoryServiceImpl extends ServiceImpl<UserDirectoryMapper, UserDirectory> implements UserDirectoryService {

    @Autowired
    FileMapper fileMapper;

    @Autowired
    UserDirectoryMapper userDirectoryMapper;

    @Autowired
    FileService fileService;

    public static int RESULT = 1;

    /**
     * 根据ID获取用户文件目录
     *
     * @param id
     * @return
     */
    @Override
    public UserDirectory getUserDirectory(String id) {
        return userDirectoryMapper.selectById(id);
    }

    /**
     * 设置用户目录
     *
     * @param userDirectory
     * @return
     */
    @Override
    public int setUserDirectory(UserDirectory userDirectory) {
        return userDirectoryMapper.updateById(userDirectory);
    }

    /**
     * 删除目录结构
     *
     * @param userId
     * @param fileDir
     * @return
     */
    @Override
    public boolean deleteStruct(String userId, String fileDir) {
        QueryWrapper<File> fileQueryWrapper = new QueryWrapper<>();
        fileQueryWrapper.like("f_dir", fileDir);
        fileQueryWrapper.eq("user_id", userId);
        int delete = fileMapper.delete(fileQueryWrapper);
        return delete == 1;
    }

    /**
     * 新建文件夹
     *
     * @param userId     用户ID
     * @param folderName 新建文件夹的名字
     * @param parentId   父文件夹ID
     * @return
     */
    @Override
    public UserDirectory createFolder(String userId, String folderName, long parentId) {
        // 根据ID获取用户文件目录对象
        UserDirectory userDirectory = getUserDirectory(userId);
        // 通过对象本身的getter方法获取 JSON 格式的文件目录
        String userDirStruct = userDirectory.getUserDirStruct();
        // 解析JSON, 并将其转换为对应的数据结构 TNode
        TNode rootNode = JSON.parseObject(userDirStruct, new TypeReference<TNode>() {
        });
        // 准备要插入的新结点
        TNode newNode = new TNode();
        newNode.setName(folderName);
        newNode.setParentId(parentId);
        newNode.setChildrenList(new ArrayList<>());
        // 插入新结点
        UtilOfTNode.insert(rootNode, parentId, newNode);
        System.out.println(rootNode);

        // 将 TNode 转成 JSON
        String newUserDirStruct = JSONObject.toJSONString(rootNode);
        System.out.println(newUserDirStruct);
        // 通过对象本身的setter方法设置新的 JSON 格式的文件目录
        userDirectory.setUserDirStruct(newUserDirStruct);
        // 更新到数据库
        int i = setUserDirectory(userDirectory);
        return userDirectory;
    }

    /**
     * 新建文件夹
     *
     * @param folder
     * @return
     */
    @Override
    public UserDirectory createFolder(FolderVo folder) {
        // 根据ID获取用户文件目录对象
        UserDirectory userDirectory = getUserDirectory(folder.getUserId());
        // 通过对象本身的getter方法获取 JSON 格式的文件目录
        String userDirStruct = userDirectory.getUserDirStruct();
        // 解析JSON, 并将其转换为对应的数据结构 TNode
        TNode rootNode = JSON.parseObject(userDirStruct, new TypeReference<TNode>() {
        });
        // 准备要插入的新结点
        TNode newNode = new TNode();
        newNode.setName(folder.getName());
        newNode.setParentId(folder.getParentId());
        newNode.setChildrenList(new ArrayList<>());
        // 插入新结点
        UtilOfTNode.insert(rootNode, folder.getParentId(), newNode);
        System.out.println(rootNode);

        // 将 TNode 转成 JSON
        String newUserDirStruct = JSONObject.toJSONString(rootNode);
        System.out.println(newUserDirStruct);
        // 通过对象本身的setter方法设置新的 JSON 格式的文件目录
        userDirectory.setUserDirStruct(newUserDirStruct);
        // 更新到数据库
        int i = setUserDirectory(userDirectory);
        return userDirectory;
    }

    /**
     * 文件夹重命名
     *
     * @param userId
     * @param folderName
     * @param parentId
     * @param url
     * @return
     */
    @Override
    public TNode renameFolder(String userId, String folderName, long parentId, String url) {
        // 根据ID获取用户文件目录对象
        UserDirectory userDirectory = getUserDirectory(userId);
        // 通过对象本身的getter方法获取 JSON 格式的文件目录
        String userDirStruct = userDirectory.getUserDirStruct();
        // 解析JSON, 并将其转换为对应的数据结构 TNode
        TNode rootNode = JSON.parseObject(userDirStruct, new TypeReference<TNode>() {
        });
        RESULT = UtilOfTNode.update(rootNode, parentId, folderName, 1);
        System.out.println(RESULT);
        String s = JSONObject.toJSONString(rootNode);
        userDirectory.setUserDirStruct(s);
        List<File> list = fileService.getListByUserIdAndFileDir(userId, url, RESULT, folderName);
        for (File value : list) {
            String id1 = value.getId();
            File file = new File();
            file.setId(id1);
            file.setSize(value.getSize());
            file.setFDir(value.getFDir());
            fileService.updateById(file);
        }
        int i = setUserDirectory(userDirectory);
        if (i > 0) {
            return rootNode;
        } else {
            return null;
        }
    }

    /**
     * 文件夹重命名
     *
     * @param folder
     * @param url
     * @return
     */
    @Override
    public boolean renameFolder(FolderVo folder, String url) {
        return false;
    }

    /**
     * 删除文件夹
     *
     * @param userId   用户ID
     * @param parentId 父文件夹ID
     * @param fileUrl  文件路径
     * @return
     */
    @Override
    public boolean deleteFolder(String userId, long parentId, String fileUrl) {
        // 根据ID获取用户文件目录对象
        UserDirectory userDirectory = getUserDirectory(userId);
        // 通过对象本身的getter方法获取 JSON 格式的文件目录
        String userDirStruct = userDirectory.getUserDirStruct();
        // 解析JSON, 并将其转换为对应的数据结构 TNode
        TNode rootNode = JSON.parseObject(userDirStruct, new TypeReference<TNode>() {
        });

        boolean flag = deleteStruct(userId, fileUrl);
        if (flag) {
            StringBuffer sb = new StringBuffer();
            // 删除结点
            UtilOfTNode.delete(rootNode, parentId, sb);
            System.out.println(sb);
            String newUserDirStruct = JSONObject.toJSONString(rootNode);
            // 通过对象本身的setter方法设置新的 JSON 格式的文件目录
            userDirectory.setUserDirStruct(newUserDirStruct);
            // 更新到数据库
            int i = setUserDirectory(userDirectory);
            return i == 1;
        } else {
            return false;
        }
    }

    /**
     * 删除文件夹
     *
     * @param folder
     * @return
     */
    @Override
    public boolean deleteFolder(FolderVo folder, String fileUrl) {
        // 根据ID获取用户文件目录对象
        UserDirectory userDirectory = getUserDirectory(folder.getUserId());
        // 通过对象本身的getter方法获取 JSON 格式的文件目录
        String userDirStruct = userDirectory.getUserDirStruct();
        // 解析JSON, 并将其转换为对应的数据结构 TNode
        TNode rootNode = JSON.parseObject(userDirStruct, new TypeReference<TNode>() {
        });

        boolean flag = deleteStruct(folder.getUserId(), fileUrl);
        if (flag) {
            StringBuffer sb = new StringBuffer();
            // 删除结点
            UtilOfTNode.delete(rootNode, folder.getParentId(), sb);
            System.out.println(sb);
            String newUserDirStruct = JSONObject.toJSONString(rootNode);
            // 通过对象本身的setter方法设置新的 JSON 格式的文件目录
            userDirectory.setUserDirStruct(newUserDirStruct);
            // 更新到数据库
            int i = setUserDirectory(userDirectory);
            return i == 1;
        } else {
            return false;
        }
    }
}
