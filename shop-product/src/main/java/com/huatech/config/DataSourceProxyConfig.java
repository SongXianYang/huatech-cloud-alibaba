package com.huatech.config;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @description: Seata 是通过代理数据源实现事务分支
 * @author: SongXY
 * @create: 2021-03-04 17:05
 **/
@Configuration
public class DataSourceProxyConfig {
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//    @Primary
//    @Bean
//    public DataSourceProxy dataSource(DruidDataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
}
