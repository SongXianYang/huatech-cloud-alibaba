package com.huatech.service.impl;


import com.huatech.annotation.Log;
import com.huatech.entity.User;
import com.huatech.mapper.IUserMapper;
import com.huatech.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 实现类
 * @author: SongXY
 * @create: 2021-02-27 16:30
 **/
@Service
@Log4j2
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserMapper userMapper;


    @Override
    public List<User> finds() {
        return userMapper.selectList(null);
    }

    @Override
    public User selectUserIdAndUserName(int id, String name) {
        User user = userMapper.selectUserIdAndUserName(id, name);
        return user;
    }

    @Override
    public int updateUser(String name, int id) {
        int i = userMapper.updateUser(name, id);
        return i;
    }

    @Override
    public List<User> UserIds() {
        List<User> finds = finds();
        List<Integer> collect = finds.stream().map(User::getId).collect(Collectors.toList());
        log.info(collect);
        List<User> users = userMapper.UserIds(collect);
        return users;
    }

    @Override
    public String insert(User user) {
        int result = userMapper.insert(user);
        if (result < 0) {
            return "插入失败！";
        }
        return "插入成功";
    }

    @Override
    public String update(User user) {
        int result = userMapper.updateById(user);
        if (result < 0) {
            return "更新失败！";
        }
        return "更新成功";
    }

    @Override
    public String deleteIds(List<Integer> ids) {
        if (ids == null) {
            return "请输入需要删除的数据";
        }
        int result = userMapper.deleteBatchIds(ids);
        if (result <= 0) {
            return "删除失败！";
        }
        return "删除成功";
    }

    @Override
    public int saveTime(int id) {
        return userMapper.saveTime(id);
    }
}
