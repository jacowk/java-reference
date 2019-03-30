package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class ApplicationRunner{
	
	public static void main(String[] args){
		new Application(new OSXFactory());
	}

}
