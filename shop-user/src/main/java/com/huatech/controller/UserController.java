package com.huatech.controller;

import com.huatech.entity.User;
import com.huatech.service.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 控制层
 * @author: SongXY
 * @create: 2021-02-27 16:43
 **/
@RestController
@RefreshScope//只需要在需要动态读取配置的类上添加此注解就可以
@RequestMapping("user")
public class UserController {
    @Resource
    IUserService userService;

    @Value("${config.name}")
    private String name;

    @Value("${config.env}")
    private String env;

    @RequestMapping(value = "finds", method = RequestMethod.GET)
    public List<User> finds() {
        return userService.finds();
    }
    @GetMapping("name")
    public String getName() {
        return name;
    }
    @GetMapping("evn")
    public String getEvn() {
        return env;
    }
}
