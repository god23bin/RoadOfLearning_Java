package com.god23bin.commonbase.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户目录结构表
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserDirectory对象", description="用户目录结构表")
public class UserDirectory implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    @ApiModelProperty(value = "JSON格式的用户目录结构")
    private String userDirStruct;


}
