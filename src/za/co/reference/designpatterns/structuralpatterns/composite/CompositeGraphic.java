package za.co.reference.designpatterns.structuralpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic{
	
	public void print(){
		for (Graphic graphic: mChildGraphics){
			graphic.print();
		}
	}
	
	public void add(Graphic graphic){
		mChildGraphics.add(graphic);
	}
	
	public void remove(Graphic graphic){
		mChildGraphics.remove(graphic);
	}
	
	private List<Graphic> mChildGraphics = new ArrayList<Graphic>();

}
