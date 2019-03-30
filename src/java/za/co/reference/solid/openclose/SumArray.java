package za.co.reference.solid.openclose;

/**
 * This class is to sum the values of an array
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-06
 *
 */
public class SumArray
{

	private double[] values;
	
	public SumArray(double[] values)
	{
		this.values = values;
	}
	
	public double sum()
	{
		double sum = 0;
		for (int i = 0; i < values.length; i++)
		{
			sum += values[i];
		}
		return sum;
	}
	
}
