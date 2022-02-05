package com.god23bin.fu.service;

import com.god23bin.fu.entity.TNode;
import com.god23bin.fu.entity.UserDirectory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.god23bin.fu.entity.vo.FolderVo;

/**
 * <p>
 * 用户目录结构表 服务类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
public interface UserDirectoryService extends IService<UserDirectory> {

    /**
     * 根据ID获取用户文件目录
     * @param id
     * @return
     */
    UserDirectory getUserDirectory(String id);

    /**
     * 设置用户目录
     * @param userDirectory
     * @return
     */
    int setUserDirectory(UserDirectory userDirectory);

    /**
     * 删除目录结构
     * @param userId
     * @param fileDir
     * @return
     */
    boolean deleteStruct(String userId, String fileDir);

    /**
     * 新建文件夹
     * @param userId 用户ID
     * @param folderName 新建文件夹的名字
     * @param parentId 父文件夹ID
     * @return
     */
    UserDirectory createFolder(String userId, String folderName, long parentId);

    /**
     * 新建文件夹
     * @param folder
     * @return
     */
    UserDirectory createFolder(FolderVo folder);

    /**
     * 文件夹重命名
     * @param userId
     * @param folderName
     * @param parentId
     * @return
     */
    TNode renameFolder(String userId, String folderName, long parentId, String url);

    /**
     * 文件夹重命名
     * @param folder
     * @return
     */
    boolean renameFolder(FolderVo folder, String url);

    /**
     * 删除文件夹
     * @param userId 用户ID
     * @param parentId 父文件夹ID
     * @param fileUrl 文件路径
     * @return
     */
    boolean deleteFolder(String userId, long parentId, String fileUrl);

    /**
     * 删除文件夹
     * @param folder
     * @return
     */
    boolean deleteFolder(FolderVo folder, String fileUrl);

}
