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
     * @param file 头像文件
     * @return
     */
    String uploadAvatar(MultipartFile file);

    /**
     * 上传文件到OSS
     * @param file 要传入的文件
     * @param catalog 要传入的文件所属文件夹
     * @return
     */
    File uploadFile(MultipartFile file, String catalog);

    /**
     * 删除文件
     * @param id
     * @return
     */
    boolean deleteFile(String id);

}