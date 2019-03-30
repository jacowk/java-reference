package za.co.reference.reflection;

public class ReflectionPractice{

	public static void main(String[] args){
		ReflectionPractice reflectionPractice = new ReflectionPractice();
		reflectionPractice.process();
	}
	
	private void process(){
		MyConcreteClass myConcreteClass1 = new MyConcreteClass();
		/* Get Class */
		Class clazz1 = MyConcreteClass.class;
//		Class clazz2 = myConcreteClass1.getClass();
//		Class clazz3 = null;
//		try{
//			clazz3 = Class.forName("za.co.reference.reflectionMyConcreteClass");
//		}
//		catch (ClassNotFoundException cnfe){
//			cnfe.printStackTrace();
//		}
//		
//		/* Instantiate class */
//		MyConcreteClass myConcreteClass = null;
//		try{
//			myConcreteClass = (MyConcreteClass) clazz1.newInstance();
//		}
//		catch (IllegalAccessException iae){
//			iae.printStackTrace();
//		}
//		catch (InstantiationException ie){
//			ie.printStackTrace();
//		}
//		
//		/* Obtain superclass */
//		Class superClass = clazz1.getSuperclass();
//		System.out.println("Superclass: " + superClass.getName());
//		
//		/* Obtain all classes */
//		System.out.println("All classes:");
//		Class[] allClasses = clazz1.getClasses();
//		for (Class clazz: allClasses){
//			System.out.println("Class: " + clazz.getName());
//		}
		
		/* Obtain declared classes */
		System.out.println("Declared classes:");
		Class[] declaredClasses = clazz1.getDeclaredClasses();
		for (Class clazz: declaredClasses){
			System.out.println("Class: " + clazz.getName());
		}
		
		/* Obtain declaring class */
		System.out.println("Declaring class:");
		
		
		/* Obtain enclosing class */
	}
	
}