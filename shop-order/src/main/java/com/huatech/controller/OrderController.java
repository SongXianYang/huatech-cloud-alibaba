package com.huatech.controller;

import com.huatech.entity.Order;
import com.huatech.entity.Product;
import com.huatech.entity.User;
import com.huatech.service.IOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 订单控制层
 * @author: SongXY
 * @create: 2021-02-27 19:36
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    IOrderService orderService;

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("buy/{pId}")
    public Order insert(@PathVariable("pId") int pId) {
        Product product = restTemplate.getForObject("http://127.0.0.1:9081/product/findById/" + pId, Product.class);
        Order order = new Order();
        order.setNumber(1);
        order.setPId(product.getId());
        order.setPName(product.getName());
        order.setPPrice(product.getPrice());
        order.setUId(1);
        order.setUsername("宋先阳");
        orderService.insert(order);
        return order;
    }
}
