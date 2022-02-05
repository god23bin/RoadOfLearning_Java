package com.god23bin.fu.service;

import com.god23bin.fu.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import com.god23bin.fu.entity.TNode;

import java.util.List;

/**
 * <p>
 * 文件表 服务类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
public interface FileService extends IService<File> {

//    /**
//     * 添加文件信息到数据库
//     * @param file
//     * @return
//     */
//    boolean addFileInfo(File file);

    /**
     * 根据用户ID查找当前用户下的所有文件
     * @param userId
     * @return
     */
    List<File> getUserAllFileInfo(String userId);

//    /**
//     * 根据文件ID查找文件具体信息
//     * @param fileId
//     * @return
//     */
//    File getFileInfo(String fileId);

    /**
     * 获取当前目录下所有文件
     * @param dir
     * @param userId
     * @return
     */
    List<File> getCurFiles(String dir, String userId);

    /**
     * 递归查找树结点
     * @param treeNode
     * @param name
     * @param list
     */
    void findTreeNode(TNode treeNode, String name, List list);

    /**
     * 根据文件名模糊查询文件
     * @param filename
     * @param userId
     * @return
     */
    List<File> searchFileWithLike(String filename, String userId);

    /**
     * 文件重命名
     * @param fileId
     * @param filename
     * @return
     */
    boolean renameFile(String fileId, String filename);

//    /**
//     * 根据文件ID收藏文件
//     * @param fileId
//     * @return
//     */
//    boolean collectFile(String[] fileId);
//
//    /**
//     * 根据文件ID取消文件收藏
//     * @param fileIds
//     * @return
//     */
//    boolean cancelFileCollection(String[] fileIds);

    /**
     * 根据文件ID收藏文件
     * @param fileIds
     * @param isCollect
     * @return
     */
    boolean toggleCollectFile(String[] fileIds, boolean isCollect);

    /**
     * 获取文件 通过用户ID、文件路径、文件名
     * @param userId
     * @param fDir
     * @param result
     * @param folderName
     * @return
     */
    List<File> getListByUserIdAndFileDir(String userId, String fDir, int result, String folderName);

    /**
     * 移动文件
     * @param destination 移到到的目的路径
     * @param fileIds 文件ID
     * @return
     */
    boolean moveFile(String destination, String fileIds);
}
