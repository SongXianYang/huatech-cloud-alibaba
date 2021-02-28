package com.huatech.service;

import com.huatech.entity.Order;

/**
 * @description: 服务层
 * @author: SongXY
 * @create: 2021-02-27 16:28
 **/
public interface IOrderService {
    /**
     * 下单
     * @param order
     */
    void insert(Order order);
}
