package za.co.reference.solid.openclose;

import java.util.List;

/**
 * Open-Close Principle: A class should be easily extendable without modifying the class itself.
 * 
 * 
 * This class can be extended by simply adding another class that implements the Shape interface.
 * This class support's any object that implements Shape. This class does not have to be changed
 * to support more classes, since it already does via the Shape interface.
 * If this class used instanceof, then it would break the open close principle, since it would have
 * to be changed for new shape objects that are added. Code to interfaces.
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class AreaCalculator
{

	private List<Shape> shapes;
	
	public AreaCalculator(List<Shape> shapes)
	{
		this.shapes = shapes;
	}
	
	public double sum()
	{
		// logic to sum the areas
		System.out.println("Summing the data");
		double sum = 0;
		for (Shape shape: shapes)
		{
			sum += shape.area();
		}
		return sum;
	}
	
}
