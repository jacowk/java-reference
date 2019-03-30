package za.co.reference.networking;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TestClient{
	
	public static void main(String[] args){
		try{
			MulticastSocket socket = new MulticastSocket(4445);
			InetAddress address = InetAddress.getByName("224.0.0.3");
			socket.joinGroup(address);
			
			byte[] buf = new byte[256];
			DatagramPacket packet = null;
			boolean receiving = true;
			while (receiving){
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String received = new String(packet.getData(), 0, packet.getLength());
				System.out.println("Received from server: " + received);
			}
			socket.leaveGroup(address);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
