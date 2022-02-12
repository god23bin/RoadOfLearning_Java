package com.god23bin.commonbase.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封装文件夹实体类
 * @author god23bin
 */
@Data
@AllArgsConstructor
public class FolderVo {

    @ApiModelProperty(value = "文件夹ID")
    private String id;

    @ApiModelProperty(value = "文件夹所属用户ID")
    private String userId;

    @ApiModelProperty(value = "文件夹名字")
    private String name;

    @ApiModelProperty(value = "父文件夹ID")
    private long parentId;
}
