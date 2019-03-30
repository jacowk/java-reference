package za.co.reference.solid.singleresponsibility;

import java.util.List;

/**
 * Single Responsibility Principle: A class should only have one reason to change, meaning the class should 
 * only have one job.
 * https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
 * 
 * This class has a wrong implementation and does not represent single responsibility, because is does a 
 * sum AND it output's the data. The class should only do a sum.
 * To fix, create a SumCalculatorOutputter
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
	
	public void sum()
	{
		// logic to sum the areas
		System.out.println("Summing the data");
	}
	
//	public void output()
//	{
//		// a method to output a shape
//		for (Shape shape: this.shapes)
//		{
//			System.out.println(shape.toString());
//		}
//	}
	
}
