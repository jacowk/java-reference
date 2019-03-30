package za.co.reference.solid.openclose;

/**
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
	
	public double getValue()
	{
		return this.radius;
	}
	
	public double area()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	public String toString()
	{
		return "Circle with radius: " + this.radius;
	}
	
}
