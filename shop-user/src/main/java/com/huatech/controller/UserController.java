package com.huatech.controller;

import com.huatech.annotation.Log;
import com.huatech.entity.User;
import com.huatech.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 控制层
 * @author: SongXY
 * @create: 2021-02-27 16:43
 **/
@Log4j2
@RestController
@RefreshScope//只需要在需要动态读取配置的类上添加此注解就可以
@RequestMapping("user")
@Api(tags = "用户模块的相关接口")
public class UserController {
    @Resource
    IUserService userService;

    @Value("${config.name}")
    private String name;

    @Value("${config.env}")
    private String env;

    @RequestMapping(value = "finds", method = RequestMethod.GET)
    @ApiOperation("查询用户集合")
    public List<User> finds() {
        return userService.finds();
    }

    @GetMapping("name")
    @ApiOperation("获取配置文件的内容")
    public String getName() {
        return name;
    }

    @GetMapping("evn")
    @ApiOperation("获取配置文件的内容")
    public String getEvn() {
        return env;
    }

    @GetMapping("selectUserIdAndUserName")
    @ApiOperation("根据两个参数来确定一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")

    })
    public User selectUserIdAndUserName(@RequestParam("id") int id, @RequestParam("name") String name) {
        return userService.selectUserIdAndUserName(id, name);
    }

    @GetMapping("updateUser")
    @ApiOperation("修改指定用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    })
    public String updateUser(@RequestParam("name") String name, @RequestParam("id") int id) {
        int i = userService.updateUser(name, id);
        if (i < 0) {
            return "更新失败！";
        }
        return "更新成功";
    }

    @GetMapping("UserIds")
    @ApiOperation("查询用户集合")
    public List<User> UserIds() {
        return userService.UserIds();
    }

    @PostMapping("insert")
    @ApiOperation("插入用户")
    public String insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @PostMapping("update")
    @ApiOperation("更新用户")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("delete")
    @ApiOperation("删除用户")
    public String deleteIds(@RequestParam(value = "ids", required = false) List<Integer> ids) {
        return userService.deleteIds(ids);
    }

    @GetMapping("log")
    @ApiOperation("测试自定义注解")
    @Log(name = "user", id = "#id", operation = "保存")
    public String log(int id, int name) {
        String s = "ceshi";
        return s;
    }

    @GetMapping("save")
    @ApiOperation("测试更新时间")
    public String save(int id) {
        try {
           int i= userService.saveTime(id);
            if (i > 0) {
                return "更新成功";
            }
            return "失败";
        } catch (Exception e) {
            log.info("save: ");
            log.error("save: ", e);
            throw e;
        }
    }
}
