package za.co.reference.test.classloading;

public class LoadTwo{
	
	public void output(){
		System.out.println("This is LoadTwo calling LoadThree:");
		LoadThree loadThree = new LoadThree();
		loadThree.output();
	}

}