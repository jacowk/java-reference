package za.co.reference.designpatterns.structuralpatterns.facade;

public class Memory{
	
	public void load(long position, byte[] data){
		System.out.println("Memory load: " + (new Long(position)).toString());
	}

}
