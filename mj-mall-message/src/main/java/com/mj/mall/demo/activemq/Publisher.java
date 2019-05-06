package com.mj.mall.demo.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {
    private static String BROKERURL = "tcp://127.0.0.1:61616";
    private static String TOPIC = "my-topic";

    public static void main(String[] args) throws JMSException {
        start();
    }

    static public void start() throws JMSException {
        System.out.println("生产者已经启动....");
        // 创建ActiveMQConnectionFactory 会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKERURL);
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动JMS 连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(null);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        send(producer, session);
        System.out.println("发送成功!");
        connection.close();
    }

    static public void send(MessageProducer producer, Session session) throws JMSException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("我是消息" + i);
            TextMessage textMessage = session.createTextMessage("我是消息" + i);
            Destination destination = session.createTopic(TOPIC);
            producer.send(destination, textMessage);
        }
    }

}
