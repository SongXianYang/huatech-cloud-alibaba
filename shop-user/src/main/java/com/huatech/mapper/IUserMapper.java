package com.huatech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huatech.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户持久层mapper
 * @author: SongXY
 * @create: 2021-02-27 16:18
 **/
@Mapper
public interface IUserMapper extends BaseMapper<User> {
}
