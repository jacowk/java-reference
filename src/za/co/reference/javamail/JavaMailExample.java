package za.co.reference.javamail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FromStringTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class JavaMailExample{
	
	public static void main(String[] args) throws Exception{
		JavaMailExample javaMailExample = new JavaMailExample();
		javaMailExample.sendMessage();
		javaMailExample.fetchMessage();
		javaMailExample.deleteMessage();
		javaMailExample.authenticateYourself();
		javaMailExample.replyToMessage();
		javaMailExample.forwardMessage();
		javaMailExample.sendAttachment();
		javaMailExample.retrieveAttachment();
		javaMailExample.sendHTMLMessage();
		javaMailExample.includeAnImage();
		javaMailExample.searchMail();
	}
	
	private void sendMessage() throws AddressException, MessagingException{
		String host = "";
		String from = "";
		String to = "";

		// Get system properties
		Properties props = System.getProperties();

		// Setup mail server
		props.put("mail.smtp.host", host);

		// Get session
		Session session = Session.getDefaultInstance(props, null);

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, 
		  new InternetAddress(to));
		message.setSubject("Hello JavaMail");
		message.setText("Welcome to JavaMail");

		// Send message
		Transport.send(message);
	}
	
	private void fetchMessage() throws NoSuchProviderException, MessagingException, IOException{
		String host = "";
		String from = "";
		String to = "";
		String username = "";
		String password = "";

		// Create empty properties
		Properties props = new Properties();

		// Get session
		Session session = Session.getDefaultInstance(props, null);

		// Get the store
		Store store = session.getStore("pop3");
		store.connect(host, username, password);

		// Get folder
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);

		// Get directory
		Message message[] = folder.getMessages();

		for (int i=0, n=message.length; i<n; i++) {
		   System.out.println(i + ": " + message[i].getFrom()[0] 
		     + "\t" + message[i].getSubject());
		}
		
		/* Optional Begin */
		//To display the whole message, you can prompt the user after seeing the from and subject fields, 
		//and then call the message's writeTo() method if they want to see it. 
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

		// Get directory
		Message displayMessage[] = folder.getMessages();
		for (int i=0, n=displayMessage.length; i<n; i++){
		  System.out.println(i + ": " + displayMessage[i].getFrom()[0] 
		    + "\t" + displayMessage[i].getSubject());

		  System.out.println("Do you want to read message? " +
		    "[YES to read/QUIT to end]");
		  String line = reader.readLine();
		  if ("YES".equals(line)){
			  displayMessage[i].writeTo(System.out);
		  } else if ("QUIT".equals(line)) {
		    break;
		  }
		}
		/* Optional End */

		// Close connection 
		folder.close(false);
		store.close();
	}
	
	private void deleteMessage() throws MessagingException{
		/*
		 * Flags:
		 * Flags.Flag.ANSWERED
		 * Flags.Flag.DELETED
		 * Flags.Flag.DRAFT
		 * Flags.Flag.FLAGGED
		 * Flags.Flag.RECENT
		 * Flags.Flag.SEEN
		 * Flags.Flag.USER
		 */
		Message message = null;
		message.setFlag(Flags.Flag.DELETED, true);
		/*
		 * Open up the folder in READ_WRITE mode first though:

			folder.open(Folder.READ_WRITE);
			Then, when you are done processing all messages, close the folder, passing in a true value to expunge the deleted messages.
			
			folder.close(true);
			There is an expunge() method of Folder that can be used to delete the messages. However, it doesn't work for Sun's POP3 provider. Other providers may or may not implement the capabilities. It will more than likely be implemented for IMAP providers. Because POP only supports single access to the mailbox, you have to close the folder to delete the messages with Sun's provider. 
			
			To unset a flag, just pass false to the setFlag() method. To see if a flag is set, check with isSet(). 

		 */
	}
	
	private void authenticateYourself() throws NoSuchProviderException, MessagingException{
		String host = "";
		
		// Setup properties
		Properties props = System.getProperties();
		props.put("mail.pop3.host", host);

		// Setup authentication, get session
		Authenticator auth = new PopupAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		// Get the store
		Store store = session.getStore("pop3");
		store.connect();
	}
	
	private void replyToMessage() throws AddressException, MessagingException{
		Message message = null; //Temporary step
		
		MimeMessage reply = (MimeMessage)message.reply(false);
		reply.setFrom(new InternetAddress("president@whitehouse.gov"));
		reply.setText("Thanks");
		Transport.send(reply);
		//To configure the reply-to address when sending a message, use the setReplyTo() method.
	}
	
	private void forwardMessage() throws AddressException, MessagingException{
		/*
		 * Forwarding messages is a little more involved. There is no single method to call, and you build up the message to forward by working with the parts that make up a message. 

			A mail message can be made up of multiple parts. Each part is a BodyPart, or more specifically, a MimeBodyPart when working with MIME messages. The different body parts get combined into a container called Multipart or, again, more specifically a MimeMultipart. To forward a message, you create one part for the text of your message and a second part with the message to forward, and combine the two into a multipart. Then you add the multipart to a properly addressed message and send it.

			That's essentially it. To copy the content from one message to another, just copy over its DataHandler, a class from the JavaBeans Activation Framework.

		 */
		
		Session session = null; //Temporary step
		Message message = null; //Temporary step
		String from = "";
		String to = "";
		
		// Create the message to forward
		Message forward = new MimeMessage(session);

		// Fill in header
		forward.setSubject("Fwd: " + message.getSubject());
		forward.setFrom(new InternetAddress(from));
		forward.addRecipient(Message.RecipientType.TO, 
		  new InternetAddress(to));

		// Create your new message part
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(
		  "Here you go with the original message:\n\n");

		// Create a multi-part to combine the parts
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Create and fill part for the forwarded content
		messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(message.getDataHandler());

		// Add part to multi part
		multipart.addBodyPart(messageBodyPart);

		// Associate multi-part with message
		forward.setContent(multipart);

		// Send message
		Transport.send(forward);

	}
	
	private void sendAttachment() throws AddressException, MessagingException{
		/*
		 * Sending attachments is quite like forwarding messages. You build up the parts to make the complete message. After the first part, your message text, you add other parts where the DataHandler for each is your attachment, instead of the shared handler in the case of a forwarded message. If you are reading the attachment from a file, your attachment data source is a FileataSource. Reading from a URL, it is a URLDataSource. Once you have your DataSource, just pass it on to the DataHandler constructor, before finally attaching it to the BodyPart with setDataHandler(). Assuming you want to retain the original filename for the attachment, the last thing to do is to set the filename associated with the attachment with the setFileName() method of BodyPart. All this is shown here: 
		 */
		
		Session session = null; //Temporary step
		String from = "";
		String to = "";
		String filename = "";
		
		// Define message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, 
		  new InternetAddress(to));
		message.setSubject("Hello JavaMail Attachment");

		// Create the message part 
		BodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		messageBodyPart.setText("Pardon Ideas");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

		// Put parts in message
		message.setContent(multipart);

		// Send the message
		Transport.send(message);

	}
	
	private void retrieveAttachment() throws MessagingException, IOException{
		Message message = null;
		Multipart multipart = null;
		
		Multipart mp = (Multipart)message.getContent();

		for (int i=0, n=multipart.getCount(); i<n; i++) {
		  Part part = multipart.getBodyPart(i);

		  String disposition = part.getDisposition();

		  if ((disposition != null) && 
		      ((disposition.equals(Part.ATTACHMENT) || 
		       (disposition.equals(Part.INLINE))))) {
			  
			  /* Optional begin */
			  if (disposition == null){
				  // Check if plain
				  MimeBodyPart mbp = (MimeBodyPart)part;
				  if (mbp.isMimeType("text/plain")) {
				    // Handle plain
				  } else {
				    // Special non-attachment cases here of 
				    // image/gif, text/html, ...
				  }
				}
			  /* Optional end */
			  
		    saveFile(part.getFileName(), part.getInputStream());
		  }
		}
	}
	
	private void saveFile(String filename, InputStream inputStream){
		File file = new File(filename);
		for (int i=0; file.exists(); i++) {
		  file = new File(filename+i);
		}

	}
	
	private void sendHTMLMessage() throws MessagingException, IOException{
		Message message = null;
		
		/* On the sending end */
		String htmlText = "<H1>Hello</H1>" + 
		  "<img src=\"http://www.jguru.com/images/logo.gif\">";
		message.setContent(htmlText, "text/html");

		/* On the receiving end */
		if (message.getContentType().equals("text/html")) {
		  String content = (String)message.getContent();
		  JFrame frame = new JFrame();
		  JEditorPane text = new JEditorPane("text/html", content);
		  text.setEditable(false);
		  JScrollPane pane = new JScrollPane(text);
		  frame.getContentPane().add(pane);
		  frame.setSize(300, 300);
		  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setVisible(true);
		}
	}
	
	private void includeAnImage() throws AddressException, MessagingException{
		Session session = null; //Temporary
		String from = "";
		String to = "";
		String file = "";

		// Create the message
		Message message = new MimeMessage(session);

		// Fill its headers
		message.setSubject("Embedded Image");
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, 
		  new InternetAddress(to));

		// Create your new message part
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = "<H1>Hello</H1>" + 
		  "<img src=\"cid:memememe\">";
		messageBodyPart.setContent(htmlText, "text/html");

		// Create a related multi-part to combine the parts
		MimeMultipart multipart = new MimeMultipart("related");
		multipart.addBodyPart(messageBodyPart);

		// Create part for the image
		messageBodyPart = new MimeBodyPart();

		// Fetch the image and associate to part
		DataSource fds = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID","<memememe>");

		// Add part to multi-part
		multipart.addBodyPart(messageBodyPart);

		// Associate multi-part with message
		message.setContent(multipart);
	}
	
	private void searchMail() throws MessagingException{
		Folder folder = null;
		
		/*
		 * Build up a SearchTerm using:
		 * AND terms (class AndTerm)
			OR terms (class OrTerm)
			NOT terms (class NotTerm)
			SENT DATE terms (class SentDateTerm)
			CONTENT terms (class BodyTerm)
			HEADER terms (FromTerm / FromStringTerm, RecipientTerm / RecipientStringTerm, SubjectTerm, etc.)
		 * */
		SearchTerm st = 
		  new OrTerm(
		    new SubjectTerm("ADV:"), 
		    new FromStringTerm("friend@public.com"));
		Message[] msgs = folder.search(st);

	}
	
	public class PopupAuthenticator extends Authenticator {

	  public PasswordAuthentication getPasswordAuthentication() {
	    String username, password;

	    String result = JOptionPane.showInputDialog(
	      "Enter 'username,password'");

	    StringTokenizer st = new StringTokenizer(result, ",");
	    username = st.nextToken();
	    password = st.nextToken();

	    return new PasswordAuthentication(username, password);
	  }

	}

}
