package com.huatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: swagger配置文件
 * @author: SongXY
 * @create: 2021-03-05 21:03
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                //这个方法的作用（生成接口的时候页面显示的信息）
                .apiInfo(apiInfo())
                //表示的是选择那些路径和API生成文档
                .select()
                //告诉他要扫描的接口存在的这个包
                .apis(RequestHandlerSelectors.basePackage("com.huatech.controller"))
                //对所有的API进行监控
                .paths(PathSelectors.any())
                .build();  //构建
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //文档的标题
                .title("用户管理")
                //文档的描述
                .description("用户微服务接口文档")
                //版本
                .version("1.0")
                .build();
    }
}
