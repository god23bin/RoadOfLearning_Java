package com.god23bin.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果对象
 */
@Data
public class Result {
    public static Integer SUCCESS_CODE = 2021;
    public static Integer ERROR_CODE = 2022;

    @ApiModelProperty(value = "是否成功")
    private Boolean isSuccess;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 构造方法私有化，不让外部直接使用，我们只提供静态方法给外部就OK
    private Result () {

    }

    //成功静态方法
    public static Result ok() {
        Result r = new Result();
        r.setIsSuccess(true);
        r.setCode(SUCCESS_CODE);
        r.setMsg("成功");
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setIsSuccess(false);
        r.setCode(ERROR_CODE);
        r.setMsg("失败");
        return r;
    }

    // 返回 this 方便我们链式调用
    public Result success(Boolean isSuccess) {
        this.setIsSuccess(isSuccess);
        return this;
    }

    public Result msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
