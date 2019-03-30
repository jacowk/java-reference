package za.co.reference.designpatterns.generics;

public class RunApplication{
	
	public static void main(String[] args){
		Application<Man> manApp = new Application<Man>();
		manApp.run(new Man());
		
		Application<Woman> womanApp = new Application<Woman>();
		womanApp.run(new Woman());
	}

}
