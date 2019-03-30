package za.co.reference.factories;

public class FactoryExample{
	
	public static synchronized FactoryExample getInstance(){
		if (factoryExample == null){
			factoryExample = new FactoryExample();
		}
		return factoryExample;
	}
	
	private static FactoryExample factoryExample;

}
