package za.co.reference.jms.example;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueSenderExample{
	
	public static void main(String[] args){
		QueueConnectionFactory queueConnectionFactory = null;
		QueueConnection queueConnection = null;
		QueueSession queueSession = null;
		QueueSender queueSender = null;
		Queue queue = null;
		TextMessage textMessage = null;
		Context context = null;
		try{
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory)context.lookup("QueueConnectionFactory");
			queue = (Queue)context.lookup("queueName");
		}
		catch (NamingException ne){
			ne.printStackTrace();
		}
		
		try{
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(queue);
			textMessage = queueSession.createTextMessage();
			textMessage.setText("Hello JMS world");
			queueSender.send(textMessage);
		}
		catch (JMSException jmsException){
			jmsException.printStackTrace();
		}
		finally{
			try{
				queueConnection.close();
			}
			catch (JMSException jmsException){
				jmsException.printStackTrace();
			}
		}
	}

}
