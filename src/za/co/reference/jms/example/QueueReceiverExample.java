package za.co.reference.jms.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueReceiverExample{
	
	public static void main(String[] args){
		QueueConnectionFactory queueConnectionFactory = null;
		QueueConnection queueConnection = null;
		QueueSession queueSession = null;
		QueueReceiver queueReceiver = null;
		Queue queue = null;
		Context context = null;
		try{
			context = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory)context.lookup("QueueConnectionFactory");
			queue = (Queue)context.lookup("TestQueue");
		}
		catch (NamingException ne){
			ne.printStackTrace();
		}
		try{
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queueReceiver = queueSession.createReceiver(queue);
			while (true){
				Message message = queueReceiver.receive();
				if (message instanceof TextMessage){
					TextMessage textMessage = (TextMessage)message;
					System.out.println("JMS Message received: " + textMessage.getText());
				}
			}
		}
		catch (JMSException jmse){
			jmse.printStackTrace();
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
