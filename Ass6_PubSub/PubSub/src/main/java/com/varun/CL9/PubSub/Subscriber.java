package com.varun.CL9.PubSub;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("hello");
		MessageConsumer consumer = session.createConsumer(topic);
		MessageListener listener= new MessageListener() {
			public void onMessage(Message message) {
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						System.out.println("Received message: " + textMessage.getText());
					}
				} catch (JMSException e) {
					System.out.println("Caught:" + e);
					e.printStackTrace();
				}
			}
		};
		consumer.setMessageListener(listener);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection.close();
	}
}
