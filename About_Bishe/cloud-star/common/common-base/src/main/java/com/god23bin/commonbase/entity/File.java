package com.god23bin.commonbase.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="File对象", description="文件表")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "阿里云存储地址")
    private String url;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "文件名字")
    private String name;

    @ApiModelProperty(value = "文件类型(jpg/pdf...)")
    private String type;

    @ApiModelProperty(value = "是否收藏")
    private Integer isCollection;

    @ApiModelProperty(value = "文件目录路径")
    private String fDir;

    @ApiModelProperty(value = "文件所属类型(图片/音频/视频)")
    private String fileSort;

    @ApiModelProperty(value = "视频ID")
    private String videoId;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
