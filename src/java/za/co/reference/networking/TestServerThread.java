package za.co.reference.networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestServerThread extends Thread{
	
	public void run(){
		try{
			DatagramSocket socket = new DatagramSocket(4445);
			InetAddress address = InetAddress.getByName("224.0.0.3");
			byte[] buf = new byte[256];
			
			buf[0] = (byte)'H';
			buf[1] = (byte)'e';
			buf[2] = (byte)'l';
			buf[3] = (byte)'l';
			buf[4] = (byte)'o';
			
			boolean sending = true;
			DatagramPacket packet = null;
			while (sending){
				packet = new DatagramPacket(buf, buf.length, address, 4445);
				socket.send(packet);
				Thread.sleep(1000);
			}
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
