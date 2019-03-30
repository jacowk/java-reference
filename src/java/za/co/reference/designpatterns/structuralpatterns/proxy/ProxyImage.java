package za.co.reference.designpatterns.structuralpatterns.proxy;

public class ProxyImage implements Image{

	public ProxyImage(String filename){
		this.filename = filename;
	}
	
	@Override
	public void displayImage(){
		if (image == null){
			image = new RealImage(filename);
		}
		image.displayImage();
	}
	
	private String filename;
	private Image image;

}
