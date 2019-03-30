package za.co.reference.reflection;

public class ReflectionCompactExample{

	public static void main(String[] args){
		ReflectionCompactExample reflectionCompactExample = new ReflectionCompactExample();
		MyConcreteClass myConcreteClass = new MyConcreteClass();
		
		/* Get class method 1 */
		Class clazz = myConcreteClass.getClass();
		
		/* Get class method 2 */
		Class clazz2 = null;
		try{
			clazz2 = Class.forName("za.co.reference.reflection.MyConcreteClass");
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		
		/* Get class method 3 */
		Class clazz3 = MyConcreteClass.class;
		
		
	}
	
}