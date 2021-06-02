package com.varun.CL9.PubSub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("hello");
		MessageProducer producer = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		message.setText("This is a Message for Topic hello");
		producer.send(message);
		System.out.println("Sent message: " + message.getText());
		connection.close();
	}
}
