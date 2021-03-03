package com.huatech.testMq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @description: 消息发送
 * @author: SongXY
 * @create: 2021-03-03 09:55
 **/

public class MqSendTest {
    public static void main(String[] args) throws Exception {
//        1. 创建消息生产者, 指定生产者所属的组名
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
//        2. 指定Nameserver地址
        producer.setNamesrvAddr("127.0.0.1:9876");
//        3. 启动生产者
        producer.start();
//        4. 创建消息对象，指定主题、标签和消息体
        Message message = new Message("myTopic1", "Mytag", "第一次创建消息".getBytes());
//        5. 发送消息
        SendResult result = producer.send(message, 10000);
        System.out.println(result);
//        6. 关闭生产者
        producer.shutdown();

    }
}
