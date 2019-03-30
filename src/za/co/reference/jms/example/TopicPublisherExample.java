package za.co.reference.jms.example;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicPublisherExample{
	
	public static void main(String[] args){
		TopicConnectionFactory topicConnectionFactory = null;
		TopicConnection topicConnection = null;
		TopicSession topicSession = null;
		TopicPublisher topicPublisher = null;
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
			topicPublisher = topicSession.createPublisher(topic);
			TextMessage textMessage = topicSession.createTextMessage();
			textMessage.setText("Test JMS Message");
			topicPublisher.publish(textMessage);
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

}
