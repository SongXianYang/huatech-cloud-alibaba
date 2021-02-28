package com.huatech.sentinelResource;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import lombok.extern.log4j.Log4j2;

/**
 * @description: 限流降级异常
 * @author: SongXY
 * @create: 2021-02-28 22:24
 **/

@Log4j2
public class OrderControllerBlockHandler {
    public static  String blockHandler(String name, Integer age, BlockExceptionHandler e) {
        log.error(e);
        return "接口被限流或者降级了"+e;
    }
}