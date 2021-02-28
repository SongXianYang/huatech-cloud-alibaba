//package com.huatech.config;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @description: 构建CommonFilter实例
// * @author: SongXY
// * @create: 2021-02-28 14:54
// **/
//@Configuration
//public class FilterContextConfig {
//    @Bean
//    public FilterRegistrationBean sentinelFilterRegistration() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new CommonFilter());
//        registrationBean.addUrlPatterns("/*");
//        // 入口资源关闭聚合
//        registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
//        registrationBean.setName("sentinelFilter");
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }
//
//}
