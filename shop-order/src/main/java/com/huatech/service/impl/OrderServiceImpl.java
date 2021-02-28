package com.huatech.service.impl;

import com.huatech.entity.Order;
import com.huatech.mapper.IOrderMapper;
import com.huatech.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 实现类
 * @author: SongXY
 * @create: 2021-02-27 16:33
 **/
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderMapper orderMapper;
    @Override
    public void insert(Order order) {
        orderMapper.insert(order);
    }
}
