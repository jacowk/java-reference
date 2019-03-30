package za.co.reference.solid.interfaceseg;

/**
 * Interface Segregation Principle: A client should never be forced to implement an interface that it 
 * doesn't use or clients shouldn't be forced to depend on methods they do not use. 
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class Cuboid implements Shape, SolidShape
{

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
