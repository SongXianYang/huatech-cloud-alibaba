package com.huatech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huatech.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 订单持久层mapper
 * @author: SongXY
 * @create: 2021-02-27 16:26
 **/
@Mapper
public interface IOrderMapper extends BaseMapper<Order> {
}
