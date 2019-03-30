package za.co.reference.designpatterns.structuralpatterns.proxy;

public class ProxyExample{
	
	public static void main(String[] args){
		Image image1 = new ProxyImage("Photo1");
		Image image2 = new ProxyImage("Photo2");
		image1.displayImage();
		image2.displayImage();
		image1.displayImage();
	}

}
