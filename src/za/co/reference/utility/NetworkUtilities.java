package za.co.reference.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.MulticastSocket;
import java.net.PasswordAuthentication;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class NetworkUtilities{
	
	/************* IP Addresses and Host names **************/
	public String getLocalhostIPAddress(){
		String ipAddress = null;
		try { InetAddress addr = InetAddress.getLocalHost(); 
			// Get IP Address 
			byte[] ipAddr = addr.getAddress(); 
			ipAddress = ipAddr.toString();
		}
		catch (UnknownHostException e){
			e.printStackTrace();
		}
		return ipAddress;
	}
	
	public String getLocalhostHostName(){
		String hostname = null;
		try{
			InetAddress addr = InetAddress.getLocalHost();
			
			// Get hostname
			hostname = addr.getHostName(); 
		}
		catch (UnknownHostException e){
			e.printStackTrace();
		}
		return hostname;
	}
	
	public void getHostnameForIPAddress(){
		try{
			// Get hostname by textual representation of IP address
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			
			// Get hostname by a byte array containing the IP address
			byte[] ipAddr = new byte[]{127, 0, 0, 1};
			addr = InetAddress.getByAddress(ipAddr);
			
			// Get the host name
			String hostname = addr.getHostName();
			
			// Get canonical host name
			String hostnameCanonical = addr.getCanonicalHostName();
		}
		catch (UnknownHostException e){

		}
	}
	
	public void getIPAddressForHostname(){
		try{
			InetAddress addr = InetAddress.getByName("javaalmanac.com");
			byte[] ipAddr = addr.getAddress();

			// Convert to dot representation
			String ipAddrStr = "";
			for (int i=0; i<ipAddr.length; i++){
				if (i > 0){
					ipAddrStr += ".";
				}
				ipAddrStr += ipAddr[i]&0xFF;
			}
		}
		catch (UnknownHostException e){

		}
	}
	
	/************* Encodings **************/
	public void ConvertBetweenByteArrayAndBase64(){
		try {
			// Convert a byte array to base64 string
			byte[] buf = new byte[]{0x12, 0x23};
			String s = new sun.misc.BASE64Encoder().encode(buf);
			
			// Convert base64 string to a byte array
			buf = new sun.misc.BASE64Decoder().decodeBuffer(s);
		}
		catch (IOException e){

		} 
	}
	
	public void convertXWwwFormUrlEncodedData(){ //name1=value1&name2=value2 
		try {
			// Construct a x-www-form-urlencoded string
			String line = URLEncoder.encode("name1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
			line += "&" + URLEncoder.encode("name2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");
			
			// Parse a x-www-form-urlencoded string
			String[] pairs = line.split("\\&");
			for (int i=0; i<pairs.length; i++){
				String[] fields = pairs[i].split("=");
				String name = URLDecoder.decode(fields[0], "UTF-8");
				String value = URLDecoder.decode(fields[1], "UTF-8");
			}
		}
		catch (UnsupportedEncodingException e){

		}
	}
	
	/************* Datagrams *************/
	public void receiveDatagram(){
		try{
			byte[] inbuf = new byte[256]; 
			
			// default size 
			DatagramSocket socket = new DatagramSocket();
			
			// Wait for packet
			DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);
			socket.receive(packet);
			
			// Data is now in inbuf 
			int numBytesReceived = packet.getLength(); 
		}
		catch (SocketException e){
	
		}
		catch (IOException e){
	
		}
	}
	
	public static void sendDatagram(InetAddress dst, int port, byte[] outbuf, int len){
		try{
			DatagramPacket request = new DatagramPacket(outbuf, len, dst, port);
			DatagramSocket socket = new DatagramSocket();
			socket.send(request);
		}
		catch (SocketException e){
			
		}
		catch (IOException e){
			
		}
	}
	
	/************* HTTP *************/
	public void getCookiesFromAnHTTPConnection(){
		//Set-Cookie: cookie-value; expires=date; path=path; domain=domain-name; secure
		//Example cookie: B=a43ka6gu6f4n4&b=2; expires=Thu, 15 Apr 2010 20:00:00 GMT; path=/; domain=.yahoo.com 
		try {
		    // Create a URLConnection object for a URL
		    URL url = new URL("http://hostname:80");
		    URLConnection conn = url.openConnection();

		    // Get all cookies from the server.
		    // Note: The first call to getHeaderFieldKey() will implicit send
		    // the HTTP request to the server.
		    for (int i=0; ; i++) {
		        String headerName = conn.getHeaderFieldKey(i);
		        String headerValue = conn.getHeaderField(i);

		        if (headerName == null && headerValue == null) {
		            // No more headers
		            break;
		        }
		        if ("Set-Cookie".equalsIgnoreCase(headerName)) {
		            // Parse cookie
		            String[] fields = headerValue.split(";\\s*");

		            String cookieValue = fields[0];
		            String expires = null;
		            String path = null;
		            String domain = null;
		            boolean secure = false;

		            // Parse each field
		            for (int j=1; j<fields.length; j++) {
		                if ("secure".equalsIgnoreCase(fields[j])) {
		                    secure = true;
		                } else if (fields[j].indexOf('=') > 0) {
		                    String[] f = fields[j].split("=");
		                    if ("expires".equalsIgnoreCase(f[0])) {
		                        expires = f[1];
		                    } else if ("domain".equalsIgnoreCase(f[0])) {
		                        domain = f[1];
		                    } else if ("path".equalsIgnoreCase(f[0])) {
		                        path = f[1];
		                    }
		                }
		            }

		            // Save the cookie...
		        }
		    }
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	public void getResponseHeadersFromAnHTTPConnection(){
		try {
		    // Create a URLConnection object for a URL
		    URL url = new URL("http://hostname:80");
		    URLConnection conn = url.openConnection();

		    // List all the response headers from the server.
		    // Note: The first call to getHeaderFieldKey() will implicit send
		    // the HTTP request to the server.
		    for (int i=0; ; i++) {
		        String headerName = conn.getHeaderFieldKey(i);
		        String headerValue = conn.getHeaderField(i);

		        if (headerName == null && headerValue == null) {
		            // No more headers
		            break;
		        }
		        if (headerName == null) {
		            // The header value contains the server's HTTP version
		        }
		    }
		} catch (Exception e) {
		}
		
		/*
		 * Example Header
		Key=Value

		null=HTTP/1.1 200 OK
		Server=Netscape-Enterprise/4.1
		Date=Mon, 11 Feb 2002 09:23:26 GMT
		Cache-control=public
		Content-type=text/html
		Etag="9fa67d2a-58-71-3bbdad3283"
		Last-modified=Fri, 05 Oct 2001 12:53:06 GMT
		Content-length=115
		Accept-ranges=bytes
		Connection=close

		 */
	}
	
	public void preventAutomaticRedirectInHTTPConnection(){
		// Disable automatic redirects for all HTTP requests
		HttpURLConnection.setFollowRedirects(false);

		// Disable automatic redirects for a particular connection
		try {
		    // Create a URLConnection object for a URL
		    URL url = new URL("http://hostname:80");
		    URLConnection conn = url.openConnection();

		    // Disable automatic redirects just for this connection
		    HttpURLConnection httpConn = (HttpURLConnection)conn;
		    httpConn.setInstanceFollowRedirects(false);

		    // Send the request to the server
		    conn.connect();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}

	}
	
	public void sendCookieToHTTPServer(){
		try {
		    // Create a URLConnection object for a URL
		    URL url = new URL("http://hostname:80");
		    URLConnection conn = url.openConnection();

		    // Set the cookie value to send
		    conn.setRequestProperty("Cookie", "name1=value1; name2=value2");

		    // Send the request to the server
		    conn.connect();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	/************* Multicast *************/
	public void joinAMulticastGroup(String groupName, int port) {
	    try {
	        MulticastSocket msocket = new MulticastSocket(port);
	        InetAddress group = InetAddress.getByName(groupName);
	        msocket.joinGroup(group);
	    } catch (IOException e) {
	    }
	}
	
	public void receivingFromAMulticastGroup(MulticastSocket msocket, byte[] inbuf) {
	    try {
	        DatagramPacket packet = new DatagramPacket(inbuf, inbuf.length);

	        // Wait for packet
	        msocket.receive(packet);

	        // Data is now in inbuf
	        int numBytesReceived = packet.getLength();
	    } catch (IOException e) {
	    }
	}
	
	public void sendingToAMulticastGroup(){
		byte[] outbuf = new byte[1024];
		int port = 1234;
		try {
		    DatagramSocket socket = new DatagramSocket();
		    InetAddress groupAddr = InetAddress.getByName("228.1.2.3");
		    DatagramPacket packet = new DatagramPacket(outbuf, outbuf.length, groupAddr, port);
		    socket.send(packet);
		}
		catch (SocketException e){
			
		}
		catch (IOException e){
			
		}
	}
	
	/************* Sockets *************/
	public void createClientSocket(){
		// Create a socket without a timeout
		try {
		    InetAddress addr = InetAddress.getByName("java.sun.com");
		    int port = 80;

		    // This constructor will block until the connection succeeds
		    Socket socket = new Socket(addr, port);
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}

		// Create a socket with a timeout
		try {
		    InetAddress addr = InetAddress.getByName("java.sun.com");
		    int port = 80;
		    SocketAddress sockaddr = new InetSocketAddress(addr, port);

		    // Create an unbound socket
		    Socket sock = new Socket();

		    // This method will block no more than timeoutMs.
		    // If the timeout occurs, SocketTimeoutException is thrown.
		    int timeoutMs = 2000;   // 2 seconds
		    sock.connect(sockaddr, timeoutMs);
		} catch (UnknownHostException e) {
		} catch (SocketTimeoutException e) {
		} catch (IOException e) {
		}
	}
	
	public void createServerSocket(){
		try {
		    int port = 2000;
		    ServerSocket srv = new ServerSocket(port);

		    // Wait for connection from client.
		    Socket socket = srv.accept();
		} catch (IOException e) {
		}
	}
	
	public void readTextFromSocket(){
		try {
		    int port = 2000;
		    ServerSocket srv = new ServerSocket(port);

		    // Wait for connection from client.
		    Socket socket = srv.accept();
		} catch (IOException e) {
		}
	}
	
	public void writeTextToSocket(){
//		try {
//		    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//		    wr.write("aString");
//		    wr.flush();
//		}
//		catch (IOException e){
//		}
	}
	
	public void sendPOSTRequestUsingSocket(){
		try {
		    // Construct data
		    String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
		    data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

		    // Create a socket to the host
		    String hostname = "hostname.com";
		    int port = 80;
		    InetAddress addr = InetAddress.getByName(hostname);
		    Socket socket = new Socket(addr, port);

		    // Send header
		    String path = "/servlet/SomeServlet";
		    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
		    wr.write("POST "+path+" HTTP/1.0\r\n");
		    wr.write("Content-Length: "+data.length()+"\r\n");
		    wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
		    wr.write("\r\n");

		    // Send data
		    wr.write(data);
		    wr.flush();

		    // Get response
		    BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    String line;
		    while ((line = rd.readLine()) != null) {
		        // Process line...
		    }
		    wr.close();
		    rd.close();
		}
		catch (Exception e){
		}
	}
	
	/************* URLs *************/
	public void accessPasswordProtectedURL(){
		// Install the custom authenticator
		//Authenticator.setDefault(myAuthenticator);

		// Access the page
		try {
		    // Create a URL for the desired page
		    URL url = new URL("http://hostname:80/index.html");

		    // Read all the text returned by the server
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String str;
		    while ((str = in.readLine()) != null) {
		        // str is one line of text; readLine() strips the newline character(s)
		    }
		    in.close();
		}
		catch (MalformedURLException e){
			
		}
		catch (IOException e){
			
		}

		class MyAuthenticator extends Authenticator {
		    // This method is called when a password-protected URL is accessed
		    protected PasswordAuthentication getPasswordAuthentication() {
		        // Get information about the request
		        String promptString = getRequestingPrompt();
		        String hostname = getRequestingHost();
		        InetAddress ipaddr = getRequestingSite();
		        int port = getRequestingPort();

		        // Get the username from the user...
		        String username = "myusername";

		        // Get the password from the user...
		        String password = "mypassword";

		        // Return the information
		        return new PasswordAuthentication(username, password.toCharArray());
		    }
		}
		
		MyAuthenticator myAuthenticator = new MyAuthenticator();
	}
	
	public void convertingBetweenURLAndURI(){
		URI uri = null;
		URL url = null;

		// Create a URI
		try {
		    uri = new URI("file://D:/almanac1.4/Ex1.java");
		} catch (URISyntaxException e) {
		}

		// Convert an absolute URI to a URL
		try {
		    url = uri.toURL();
		} catch (IllegalArgumentException e) {
		    // URI was not absolute
		} catch (MalformedURLException e) {
		}

		// Convert a URL to a URI
		try {
		    uri = new URI(url.toString());
		} catch (URISyntaxException e) {
		}
	}
	
	public void creatingAURL(){
		try {
		    // With components.
		    URL url = new URL("http", "hostname", 80, "index.html");

		    // With a single string.
		    url = new URL("http://hostname:80/index.html");
		} catch (MalformedURLException e) {
		}
	}
	
	public void getJarFileFromURL(){
		try {
		    // Create a URL that refers to a jar file on the net
		    URL url = new URL("jar:http://hostname/my.jar!/");

		    // Create a URL that refers to a jar file in the file system
		    url = new URL("jar:file:/c:/almanac/my.jar!/");

		    // Get the jar file
		    JarURLConnection conn = (JarURLConnection)url.openConnection();
		    JarFile jarfile = conn.getJarFile();

		    // When no entry is specified on the URL, the entry name is null
		    String entryName = conn.getEntryName();  // null


		    // Create a URL that refers to an entry in the jar file
		    url = new URL("jar:file:/c:/almanac/my.jar!/com/mycompany/MyClass.class");

		    // Get the jar file
		    conn = (JarURLConnection)url.openConnection();
		    jarfile = conn.getJarFile();

		    // Get the entry name; it should be the same as specified on URL
		    entryName = conn.getEntryName();

		    // Get the jar entry
		    JarEntry jarEntry = conn.getJarEntry();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	public void getImageFromURL(){
		try {
		    // Create a URL for the image's location
		    URL url = new URL("http://hostname:80/image.gif");

		    // Get the image
		    java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(url);
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	public void getTextFromURL(){
		try {
		    // Create a URL for the desired page
		    URL url = new URL("http://hostname:80/index.html");

		    // Read all the text returned by the server
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String str;
		    while ((str = in.readLine()) != null) {
		        // str is one line of text; readLine() strips the newline character(s)
		    }
		    in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	public void parseURL(){
		try {
		    URL url = new URL("http://hostname:80/index.html#_top_");

		    String protocol = url.getProtocol();    // http
		    String host = url.getHost();            // hostname
		    int port = url.getPort();               // 80
		    String file = url.getFile();            // index.html
		    String ref = url.getRef();              // _top_
		}
		catch (MalformedURLException e){
			
		}
	}
	
	public void sendPOSTRequestUsingURL(){
		try {
		    // Construct data
		    String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
		    data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

		    // Send data
		    URL url = new URL("http://hostname:80/cgi");
		    URLConnection conn = url.openConnection();
		    conn.setDoOutput(true);
		    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(data);
		    wr.flush();

		    // Get the response
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line;
		    while ((line = rd.readLine()) != null) {
		        // Process line...
		    }
		    wr.close();
		    rd.close();
		}
		catch (Exception e){
			
		}
	}
	
}
