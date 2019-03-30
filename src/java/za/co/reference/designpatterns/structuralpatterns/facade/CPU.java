package za.co.reference.designpatterns.structuralpatterns.facade;

public class CPU{
	
	public void freeze(){
		System.out.println("CPU freeze");
	}
	
	public void jump(long position, byte[] data){
		System.out.println("CPU jump: " + (new Long(position)).toString());
	}
	
	public void execute(){
		System.out.println("CPU execute");
	}

}
