package za.co.reference.designpatterns.test;

public abstract class Application implements ApplicationInterface{

	@Override
	public void implementationOne(InterfaceOne interfaceOne){
		interfaceOne.methodOne();
	}

	@Override
	public void implementationTwo(InterfaceTwo interfaceTwo, InterfaceThree interfaceThree){
		interfaceTwo.methodTwo();
		interfaceThree.methodThree();
	}
	
	public abstract void implementationThree();
	
}
