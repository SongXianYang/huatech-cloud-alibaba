package com.huatech.mapper;

import com.huatech.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-07-25 13:56
 **/
@Mapper
public interface LoginUserMapper {
    /**
     * 查询用户
     * @param username
     * @return
     */
    LoginUser selectUserByUserName(@Param("username") String username);
}
