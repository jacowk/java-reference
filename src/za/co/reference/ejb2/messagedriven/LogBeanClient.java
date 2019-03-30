package za.co.reference.ejb2.messagedriven;

import javax.naming.*;

import javax.jms.*;
import java.util.*;

public class LogBeanClient {

 public static void main (String[] args) throws Exception {

  Properties env = new Properties();
  env.put("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
  env.put("java.naming.provider.url", "iiop://localhost:3700");
  InitialContext ctxt = new InitialContext(env);

  TopicConnectionFactory factory =  (TopicConnectionFactory) ctxt.lookup("jms/TopicConnectionFactory");

  TopicConnection connection = factory.createTopicConnection();
  
  TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE); 

  Topic topic = (Topic) ctxt.lookup("jms/Topic");

  TopicPublisher publisher = session.createPublisher(topic);

  TextMessage msg = session.createTextMessage();

  msg.setText("This is a test message."); 

  publisher.publish(msg);

  System.out.println ("Message published to jms/Topic. Please check application server's console to see the response from MDB.");
 }
}