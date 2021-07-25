package com.huatech.service;

import com.huatech.entity.User;
import com.huatech.response.Result;
import org.springframework.transaction.annotation.Transactional;

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
    Result<List<User>> finds();

    User selectUserIdAndUserName(int id,String name);
    int updateUser(String name , int id);

    List<User> UserIds();
    @Transactional
    String insert(User user);
    @Transactional
    String update(User user);
    @Transactional
    String deleteIds(List<Integer> ids);

    int saveTime(int id);

    List<User> selectUserByInName(List<String> names);
}
