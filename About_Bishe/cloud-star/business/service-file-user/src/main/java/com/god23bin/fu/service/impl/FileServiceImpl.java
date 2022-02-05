package com.god23bin.fu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.god23bin.fu.entity.File;
import com.god23bin.fu.entity.TNode;
import com.god23bin.fu.mapper.FileMapper;
import com.god23bin.fu.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    private static int COLLECT_FLAG = 0;

    @Autowired
    FileMapper fileMapper;


    /**
     * 根据用户ID查找当前用户下的所有文件
     *
     * @param userId
     * @return
     */
    @Override
    public List<File> getUserAllFileInfo(String userId) {
        QueryWrapper<File> fileWrapper = new QueryWrapper<>();
        fileWrapper.eq("user_id", userId);
        return fileMapper.selectList(fileWrapper);
    }

    /**
     * 获取当前目录下所有文件
     *
     * @param dir
     * @param userId
     * @return
     */
    @Override
    public List<File> getCurFiles(String dir, String userId) {
        return null;
    }

    /**
     * 递归查找树结点
     *
     * @param treeNode
     * @param name
     * @param list
     */
    @Override
    public void findTreeNode(TNode treeNode, String name, List list) {

    }

    /**
     * 根据文件名模糊查询文件
     *
     * @param filename
     * @param userId
     * @return
     */
    @Override
    public List<File> searchFileWithLike(String filename, String userId) {
        return null;
    }

    /**
     * 文件重命名
     *
     * @param fileId
     * @param filename
     * @return
     */
    @Override
    public boolean renameFile(String fileId, String filename) {
        File file = fileMapper.selectById(fileId);
        file.setName(filename);
        int i = fileMapper.updateById(file);
        return i == 1;
    }

    /**
     * 根据文件ID进行文件收藏处理
     *
     * @param fileIds   多个文件ID
     * @param isCollect 是否收藏
     * @return
     */
    @Override
    public boolean toggleCollectFile(String[] fileIds, boolean isCollect) {
        boolean flag = false;
        if (isCollect) {
            COLLECT_FLAG = 1;
        } else {
            COLLECT_FLAG = 0;
        }
        for (String filedId : fileIds) {
            File file = new File();
            file.setId(filedId);
            file.setIsCollection(COLLECT_FLAG);
            int i = fileMapper.updateById(file);
            if (i == 1) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文件 通过用户ID、文件路径、文件夹名
     *
     * @param userId
     * @param fDir
     * @param result
     * @param folderName
     * @return
     */
    @Override
    public List<File> getListByUserIdAndFileDir(String userId, String fDir, int result, String folderName) {
        QueryWrapper<File> fileQueryWrapper = new QueryWrapper<>();
        fileQueryWrapper.eq("user_id", userId);
        fileQueryWrapper.like("f_dir", fDir);
        List<File> fileList = baseMapper.selectList(fileQueryWrapper);

        for (File file : fileList) {
            String fileDir = file.getFDir();
            String[] s = fileDir.split("/", -1);
            s[result] = folderName;
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j < s.length; j++) {
                sb.append("/").append(s[j]);
            }
            System.out.println(sb.toString());
            file.setFDir(sb.toString());
            //System.out.println(fileList);
        }

        System.out.println(fileList);
        //System.out.println(fileList);
        return fileList;
    }

    /**
     * 移动文件
     *
     * @param destination 移到到的目的路径
     * @param fileId      文件ID
     * @return
     */
    @Override
    public boolean moveFile(String destination, String fileId) {
        return false;
    }
}
