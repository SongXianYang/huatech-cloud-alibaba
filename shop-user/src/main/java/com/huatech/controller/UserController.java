package com.huatech.controller;

import com.huatech.entity.User;
import com.huatech.service.IUserService;
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
@RequestMapping("user")
public class UserController {
    @Resource
    IUserService userService;

    @RequestMapping(value = "finds",method = RequestMethod.GET)
    public List<User> finds() {
        return userService.finds();
    }
}
