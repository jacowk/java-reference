package za.co.reference.jms.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicSubscriberExample implements MessageListener{
	
	public static void main(String[] args){
		TopicSubscriberExample topicSubscriberExample = new TopicSubscriberExample();
		topicSubscriberExample.subscriberExample();
	}

	public void subscriberExample(){
		TopicConnectionFactory topicConnectionFactory = null;
		TopicConnection topicConnection = null;
		TopicSession topicSession = null;
		TopicSubscriber topicSubscriber = null;
		Topic topic = null;
		Context context = null;
		try{
			context = new InitialContext();
			topicConnectionFactory = (TopicConnectionFactory)context.lookup("TopicConnectionFactory");
			topic = (Topic)context.lookup("TestTopic");
		}
		catch (NamingException ne){
			ne.printStackTrace();
		}
		try{
			topicConnection = topicConnectionFactory.createTopicConnection();
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			topicSubscriber = topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(this);
			topicConnection.start();
		}
		catch (JMSException je){
			je.printStackTrace();
		}
		finally{
			try{
				topicConnection.close();
			}
			catch (JMSException je){
				je.printStackTrace();
			}
		}
	}
	
	@Override
	public void onMessage(Message message){
		if (message instanceof TextMessage){
			TextMessage textMessage = (TextMessage)message;
			System.out.println("JMS Message received: " + textMessage);
		}
	}

}
