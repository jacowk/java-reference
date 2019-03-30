package za.co.reference.solid.liskov;

import java.util.List;

/**
 * Single Responsibility Principle: A class should only have one reason to change, meaning the class should 
 * only have one job
 * https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class SumCalculatorOutputter
{

	private List<Shape> shapes;
	
	public SumCalculatorOutputter(List<Shape> shapes)
	{
		this.shapes = shapes;
	}
	
	public void output()
	{
		// a method to output a shape
		for (Shape shape: this.shapes)
		{
			System.out.println(shape.toString());
		}
	}
	
	public void json()
	{
		System.out.println("Outputting JSON");
	}
	
	public void html()
	{
		System.out.println("Outputting HTML");
	}
	
}
