package com.god23bin.oss.service;

import com.god23bin.commonbase.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * Oss 服务
 * @author god23bin
 */
public interface OssService {

    /**
     * 上传头像到OSS
     * @param multipartFile 头像文件
     * @return
     */
    String uploadAvatar(MultipartFile multipartFile);

    /**
     * 上传文件到OSS
     * @param multipartFile 要传入的文件
     * @param catalog 要传入的文件所属文件夹
     * @return
     */
    File uploadFile(MultipartFile multipartFile, String catalog);

    /**
     * 根据文件ID删除文件
     * @param fileId
     * @return
     */
    boolean deleteFile(String fileId);

}