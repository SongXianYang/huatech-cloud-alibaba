package com.huatech.service;

import com.huatech.entity.User;

import java.util.List;

/**
 * @description: 服务层
 * @author: SongXY
 * @create: 2021-02-27 16:28
 **/
public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> finds();

}
