package com.huatech.response;

import lombok.Getter;

/**
 * @description: code枚举
 * @author: SongXY
 * @create: 2021-04-11 17:09
 **/
@Getter
public enum  ResultCodeEnum {
    SUCCESS(true,20000,"成功"),
    UNKNOW_REASON(false,20001,"未知错误"),
    BAD_SQL_GRAMMER(false,21001,"sql语法错误"),
    JSON_PARSE_ERROR(false,21002,"json解析异常"),
    PARAM_ERROR(false,21003,"参数不正确"),
    FILE_UPLOAD_ERROR(false,21004,"文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false,21005,"Excel数据导入错误"),
    ERROR_AUTH_CODE(false,21006,"验证码错误!"),
    ERROR_NOT_EXISTS_USER(false,21007,"用户不存在!"),
    ERROR_PASSWORD(false,21008,"密码错误,请重新输入!"),
    SUCCESS_LOGIN(true,20000,"登陆成功!"),
    SUCCESS_REGISTER(true,20000,"注册成功!");
    //响应是否成功
    private Boolean status;
    //返回码
    private Integer code;
    //返回消息
    private String message;

    ResultCodeEnum(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
