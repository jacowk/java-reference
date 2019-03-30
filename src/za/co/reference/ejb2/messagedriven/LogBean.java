package za.co.reference.ejb2.messagedriven;

import javax.ejb.*;
import javax.jms.*;

public class LogBean implements MessageDrivenBean, MessageListener {

 protected MessageDrivenContext ctx;

 public void setMessageDrivenContext(MessageDrivenContext ctx) {
  this.ctx = ctx;
 }

 public void ejbCreate() {
  System.err.println("ejbCreate()");
 }

 public void onMessage(Message msg) {

  TextMessage tm = (TextMessage) msg;

  try {
   String text = tm.getText();
   System.err.println("Received new message : " + text);
  }
  catch(JMSException e) {
   e.printStackTrace();
  }
 }

 public void ejbRemove() {
  System.err.println("ejbRemove()");
 }
}