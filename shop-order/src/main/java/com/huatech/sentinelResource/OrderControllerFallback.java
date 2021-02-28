package com.huatech.sentinelResource;

import com.netflix.ribbon.hystrix.FallbackHandler;
import lombok.extern.log4j.Log4j2;

/**
 * @description: 抛异常
 * @author: SongXY
 * @create: 2021-02-28 22:25
 **/
@Log4j2
public class OrderControllerFallback {
    public static  String fallback(String name, Integer age, Throwable e) {
        log.error(e);
        return "接口发生异常了+"+e;
    }
}
