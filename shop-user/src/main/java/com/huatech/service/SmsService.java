package com.huatech.service;

import com.alibaba.fastjson.JSON;
import com.huatech.entity.Order;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @description: 发送短信类
 * @author: SongXY
 * @create: 2021-03-03 15:50
 **/
@Log4j2
@Service
//第一个参数定义一个消费者组，第二个参数 所要监听的主题名称
@RocketMQMessageListener(consumerGroup = "shop-user",topic = "order-topic")
public class SmsService implements RocketMQListener<Order> {
    @Override
    //接受过来的消息
    public void onMessage(Order order) {
        log.info("接受到的订单信息{}，为发送短信做准备", JSON.toJSONString(order));
    }
}
