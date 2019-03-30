package za.co.reference.solid.singleresponsibility;

/**
 * Single Responsibility Principle: A class should only have one reason to change, meaning the class should 
 * only have one job
 * https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class Circle implements Shape
{

	private double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	public String toString()
	{
		return "Circle with radius: " + this.radius;
	}
	
}
