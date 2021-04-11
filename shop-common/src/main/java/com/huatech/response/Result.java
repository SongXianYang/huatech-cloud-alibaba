package com.huatech.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 固定返回格式
 * @author: SongXY
 * @create: 2021-03-07 20:50
 **/
@Data
@ApiModel(value = "统一返回数据格式")
public class Result<T> {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){}

    public  Result ok(T data){
        Result r = new Result();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setCode(ResultCodeEnum.UNKNOW_REASON.getCode());
        r.setSuccess(ResultCodeEnum.UNKNOW_REASON.getStatus());
        r.setMessage(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public static Result error(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }
    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

}