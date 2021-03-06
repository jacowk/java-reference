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
public class VolumeCalculator extends AreaCalculator
{

	private List<Shape> shapes;
	
	public VolumeCalculator(List<Shape> shapes)
	{
		super(shapes);
		this.shapes = shapes;
	}
	
	public double sum()
	{
		//logic to calculate volumes then return an array of output
		System.out.println("Calculating volumes");
		double sum = 0;
		for (Shape shape: shapes)
		{
			sum += shape.volume();
		}
		return sum;
	}

}
