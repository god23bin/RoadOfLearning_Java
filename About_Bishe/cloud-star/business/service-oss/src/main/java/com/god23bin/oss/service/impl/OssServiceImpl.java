package com.god23bin.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.god23bin.commonbase.entity.File;
import com.god23bin.fu.mapper.FileMapper;
import com.god23bin.oss.service.OssService;
import com.god23bin.oss.utils.UtilOfOss;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Oss 服务实现类
 * @author god23bin
 */
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    UtilOfOss utilOfOss;

    @Autowired
    FileMapper fileMapper;

    /**
     * 上传头像到OSS
     *
     * @param multipartFile
     * @return
     */
    @Override
    public String uploadAvatar(MultipartFile multipartFile) {
        String endpoint = utilOfOss.getEndpoint();
        String accessKeyId = utilOfOss.getAccessKeyId();
        String accessKeySecret = utilOfOss.getAccessKeySecret();
        String fileHost = utilOfOss.getFileHost();
        String bucketName = utilOfOss.getBucketName();

        String uploadUrl = null;

        // 1. 创建OSS客户端实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 2. 获取上传文件的输入流
            InputStream inputStream = multipartFile.getInputStream();
            // 3. 获取全文件名（即包含后缀） xxx.jpg
            String originalFilename = multipartFile.getOriginalFilename();

            // 为了把文件按照日期进行分类，那么需要有日期
            // 所以构建日期路径
            String datePath = new DateTime().toString("yyyy/MM/dd");
            // 拼接
            // 2022/02/12/文件原始名称.jpg
            originalFilename = datePath + "/" + originalFilename;

            // 4. 上传到OSS
            ossClient.putObject(bucketName, originalFilename, inputStream);

            // 把上传之后文件路径返回
            // 需要把上传到阿里云oss路径手动拼接出来
            // https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg
            uploadUrl = "https://" + bucketName + "." + endpoint + "/" + originalFilename;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        // 返回上传后的文件路径
        return uploadUrl;
    }

    /**
     * 上传文件到OSS
     *
     * @param multipartFile
     * @param catalog
     * @return
     */
    @Override
    public File uploadFile(MultipartFile multipartFile, String catalog) {
        String endpoint = utilOfOss.getEndpoint();
        String accessKeyId = utilOfOss.getAccessKeyId();
        String accessKeySecret = utilOfOss.getAccessKeySecret();
        String fileHost = utilOfOss.getFileHost();
        String bucketName = utilOfOss.getBucketName();

        File file = new File();
        String uploadUrl = null;

        // 1. 创建OSS客户端实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 2. 获取上传文件的输入流
            InputStream inputStream = multipartFile.getInputStream();
            // 3. 获取全文件名（即包含后缀） 比如：勒布朗扣篮.jpg
            String originalFilename = multipartFile.getOriginalFilename();

            // 从 originalFilename 截取文件名、文件类型
            // 勒布朗扣篮
            String filename = originalFilename.substring(0, originalFilename.indexOf("."));
            // .jpg
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            // jpg
            String type = fileType.substring(1);
            // 如果 type 是图片类型的
            if("bmp".equals(type)|| "jpg".equals(type)|| "jpeg".equals(type)|| "png".equals(type)|| "tif".equals(type)|| "gif".equals(type)
                    || "pcx".equals(type)|| "tga".equals(type)|| "exif".equals(type)|| "fpx".equals(type)|| "svg".equals(type)|| "psd".equals(type)|| "cdr".equals(type)
                    || "pcd".equals(type)|| "dxf".equals(type)|| "ufo".equals(type)|| "eps".equals(type)|| "ai".equals(type)|| "raw".equals(type)
                    || "WMF".equals(type)|| "webp".equals(type)|| "avif".equals(type)) {
                // 文件类别设置为image
                file.setFileSort("image");
            }

            // 为了把文件按照日期进行分类，那么需要有日期
            // 所以构建日期路径 2022/02/12
            String datePath = new DateTime().toString("yyyy/MM/dd");
            // 拼接
            // 2022/02/12/文件原始名称.jpg
            originalFilename = datePath + "/" + originalFilename;

            // 4. 上传到OSS
            ossClient.putObject(bucketName, originalFilename, inputStream);

            // 需要把上传到阿里云oss路径手动拼接出来
            // https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg
            uploadUrl = "https://" + bucketName + "." + endpoint + "/" + originalFilename;

            file.setName(filename);
            file.setType(fileType);
            file.setUrl(uploadUrl);
            file.setFDir(catalog);
            file.setSize(multipartFile.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return file;
    }


    /**
     * 根据文件ID删除文件
     * 逻辑：删除数据库中的记录 + 删除阿里云OSS上的文件
     * @param fileId
     * @return
     */
    @Override
    public boolean deleteFile(String fileId) {
        String endpoint = utilOfOss.getEndpoint();
        String accessKeyId = utilOfOss.getAccessKeyId();
        String accessKeySecret = utilOfOss.getAccessKeySecret();
        String fileHost = utilOfOss.getFileHost();
        String bucketName = utilOfOss.getBucketName();
        // 直接删除数据库中的记录
        File file = fileMapper.selectById(fileId);
        String name = file.getName();
        int i = fileMapper.deleteById(fileId);
        if (i == 0) {
            return false;
        }

        SimpleDateFormat data = new SimpleDateFormat("yyyy/MM/dd");
        Date gmtCreate = file.getGmtCreate();
        data.format(gmtCreate);
        // 注意，这里虽然写成这种固定获取日期目录的形式，逻辑上确实存在问题，但是实际上，filePath的日期目录应该是从数据库查询的
        // String filePath = new DateTime().toString("yyyy/MM/dd");
        String filePath = data.toString();

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 根据BucketName, fileName删除文件
        // 删除目录中的文件，如果是最后一个文件fileoath目录会被删除。
        String fileKey = filePath + "/" + name;
        ossClient.deleteObject(bucketName, fileKey);
        ossClient.shutdown();

        return true;
    }
}
