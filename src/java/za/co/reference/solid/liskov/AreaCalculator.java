package za.co.reference.solid.liskov;

import java.util.List;

/**
 * Liskov's substitution principle. Every subclass/derived class should be substitutable 
 * for their base/parent class.
 * 
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
