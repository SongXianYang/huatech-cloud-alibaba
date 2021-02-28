package com.huatech.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.huatech.entity.Order;
import com.huatech.entity.Product;
import com.huatech.feign.ProductFeign;
import com.huatech.sentinelResource.OrderControllerBlockHandler;
import com.huatech.sentinelResource.OrderControllerFallback;
import com.huatech.service.IOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: 订单控制层
 * @author: SongXY
 * @create: 2021-02-27 19:36
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @Resource
    private ProductFeign productFeign;

    @RequestMapping("buy/{pId}")
    public Order insert(@PathVariable("pId") int pId) {
        Product product = productFeign.findById(pId);
        Order order = new Order();
        order.setNumber(1);
        order.setPId(product.getId());
        order.setPName(product.getName());
        order.setPPrice(product.getPrice());
        order.setUId(1);
        order.setUsername("宋先阳");
//        orderService.insert(order);
        return order;
    }
    @RequestMapping("test")
    public String test() {
        return "测试高并发！";
    }

    @RequestMapping("test1")
    @SentinelResource(value = "message-test",
            blockHandlerClass = OrderControllerBlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderControllerFallback.class,
            fallback = "fallback"
    )//注意这里必须使用这个注解标识,参数规则不生效
    public String message3(String name, Integer age) {
        return name + age;
    }

}
