package com.huatech.testMq;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @description: 消息的接受
 * @author: SongXY
 * @create: 2021-03-03 13:56
 **/
@Log4j2
public class MqReceiveTest {
    public static void main(String[] args) throws MQClientException {
//        1. 创建消息消费者, 指定消费者所属的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myconsumer-group");
//        2. 指定Nameserver地址
        consumer.setNamesrvAddr("127.0.0.1:9876");
//        3. 指定消费者订阅的主题和标签
        consumer.subscribe("myTopic1","Mytag");
//        4. 设置回调函数，编写处理消息的方法
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(messageExt -> System.out.println(messageExt));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
//        5. 启动消息消费者
        log.info("消息消费成功");
        consumer.start();
    }
}
