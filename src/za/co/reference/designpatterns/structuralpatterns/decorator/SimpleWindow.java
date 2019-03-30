package za.co.reference.designpatterns.structuralpatterns.decorator;

public class SimpleWindow implements Window{

	@Override
	public void draw(){
		System.out.println("Drawing Simple Window");
	}

	@Override
	public String getDescription(){
		return "simple window";
	}
	
}
