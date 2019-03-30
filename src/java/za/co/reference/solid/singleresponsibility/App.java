package za.co.reference.solid.singleresponsibility;

import java.util.ArrayList;
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
public class App
{

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(2));
		shapes.add(new Square(5));
		shapes.add(new Square(6));
		
		AreaCalculator areaCalculator = new AreaCalculator(shapes);
		areaCalculator.sum();
		
		SumCalculatorOutputter sumCalculatorOutputter = new SumCalculatorOutputter(shapes);
		sumCalculatorOutputter.output();
	}

}
