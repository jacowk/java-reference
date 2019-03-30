package za.co.reference.designpatterns.test;

public class RunApplication{
	
	public static void main(String[] args){
		RunApplication run = new RunApplication();
		run.init();
		run.runApplication();
	}
	
	public void init(){
//		interfaceOne = new InterfaceOneImplOne();
//		interfaceTwo = new InterfaceTwoImplOne();
//		interfaceThree = new InterfaceThreeImplOne();
		
		interfaceOne = new InterfaceOneImplTwo();
		interfaceTwo = new InterfaceTwoImplTwo();
		interfaceThree = new InterfaceThreeImplTwo();
//		
//		interfaceOne = new InterfaceOneImplThree();
//		interfaceTwo = new InterfaceTwoImplThree();
//		interfaceThree = new InterfaceThreeImplThree();
	}
	
	public void runApplication(){
		Application appOne = new ConcreteApplication();
		appOne.implementationOne(interfaceOne);
		appOne.implementationTwo(interfaceTwo, interfaceThree);
		appOne.implementationThree();
	}
	
	public InterfaceOne interfaceOne;
	public InterfaceTwo interfaceTwo;
	public InterfaceThree interfaceThree;

}
