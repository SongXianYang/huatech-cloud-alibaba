package com.huatech.interfaces;

/**
 * @description: 首先定义一个基础的接口类，自定义的错误描述枚举类需实现该接口。
 * @author: SongXY
 * @create: 2021-04-30 22:15
 **/
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
