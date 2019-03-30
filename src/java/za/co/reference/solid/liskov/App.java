package za.co.reference.solid.liskov;

import java.util.ArrayList;
import java.util.List;

/**
 * Open-Close Principle: A class should be easily extendable without modifying the class itself.
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class App
{

	public static void main(String[] args)
	{
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(2));
		shapes.add(new Square(5));
		shapes.add(new Square(6));
		
		VolumeCalculator volumeCalculator = new VolumeCalculator(shapes);
		volumeCalculator.sum();
		
		SumCalculatorOutputter sumCalculatorOutputter = new SumCalculatorOutputter(shapes);
		sumCalculatorOutputter.output();
	}
	
}
