package com.mj.mall.demo.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Subscriber {
    private static String BROKERURL = "tcp://127.0.0.1:61616";
    private static String TOPIC = "my-topic";

    public static void main(String[] args) throws JMSException {
        start();
    }

    static public void start() throws JMSException {
        System.out.println("消费点启动...");
        // 创建ActiveMQConnectionFactory 会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKERURL);
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动JMS 连接
        connection.start();
        // 不开消息启事物，消息主要发送消费者,则表示消息已经签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个队列
        Topic topic = session.createTopic(TOPIC);
        MessageConsumer consumer = session.createConsumer(topic);
        // consumer.setMessageListener(new MsgListener());
        while (true) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            if (textMessage != null) {
                System.out.println("接受到消息:" + textMessage.getText());
                // textMessage.acknowledge();// 手动签收
                // session.commit();
            } else {
                break;
            }
        }
        connection.close();
    }

}
