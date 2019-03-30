package za.co.reference.designpatterns.structuralpatterns.proxy;

public class RealImage implements Image{

	public RealImage(String filename){
		this.filename = filename;
		loadImageFromDisk();
	}
	
	private void loadImageFromDisk(){
		System.out.println("Loading " + filename);
	}
	
	@Override
	public void displayImage(){
		System.out.println("Displaying " + filename);
	}
	
	private String filename;

}
