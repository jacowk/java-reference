package za.co.reference.designpatterns.behavioralpatterns.command.example2;

public class Receiver{

	 public Receiver(){
	  value = 0;
	 }
	 
	 public void increment(){  
	  ++value;
	  
	 }
	 
	 public void decrement(){
	  --value;
	 }
	 
	 public int getValue(){
	  return value;
	 }
	 
	 private int  value;

}