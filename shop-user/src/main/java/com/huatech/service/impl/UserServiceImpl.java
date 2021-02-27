package com.huatech.service.impl;


import com.huatech.entity.User;
import com.huatech.mapper.IUserMapper;
import com.huatech.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 实现类
 * @author: SongXY
 * @create: 2021-02-27 16:30
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserMapper userMapper;

    @Override
    public List<User> finds() {
        return userMapper.selectList(null);
    }
}
