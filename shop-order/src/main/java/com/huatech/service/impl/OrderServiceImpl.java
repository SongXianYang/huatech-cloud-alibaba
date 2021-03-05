package com.huatech.service.impl;

import com.huatech.entity.Order;
import com.huatech.entity.Product;
import com.huatech.feign.ProductFeign;
import com.huatech.mapper.IOrderMapper;
import com.huatech.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private ProductFeign productFeign;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    @GlobalTransactional//全局事务控制
    public Order insert(int pId) {
        Product product = productFeign.findById(pId);
        Order order = new Order();
        order.setNumber(1);
        order.setPId(product.getId());
        order.setPName(product.getName());
        order.setPPrice(product.getPrice());
        order.setUId(1);
        order.setUsername("宋先阳");
        orderMapper.insert(order);
        //扣库存
        productFeign.DeductionStock(pId, order.getNumber());
        return order;
    }
}
