package za.co.reference.solid.openclose;

/**
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class Square implements Shape
{

	private double length;
	
	public Square(double length)
	{
		this.length = length;
	}
	
	public double getValue()
	{
		return this.length;
	}
	
	public double area()
	{
		return Math.pow(this.length, 2);
	}
	
	public String toString()
	{
		return "Square with length: " + this.length;
	}
	
}
