package com.huatech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huatech.*")
public class MyActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyActivitiApplication.class, args);
    }

}
