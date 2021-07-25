package com.huatech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huatech.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 用户持久层mapper
 * @author: SongXY
 * @create: 2021-02-27 16:18
 **/
@Mapper
public interface IUserMapper extends BaseMapper<User> {
    User selectUserIdAndUserName(@Param("id") int id, @Param("name") String name);

    int  updateUser(@Param("name") String name ,@Param ("id") int id);

    List<User> UserIds(@Param("ids") List<Integer> ids);


    int  saveTime(@Param("id") int id);

    List<User> selectUserByInName(List<String> names);
}
