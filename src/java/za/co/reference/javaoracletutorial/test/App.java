package za.co.reference.javaoracletutorial.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class App
{
	
	public static void main(String[] args)
	{
		Method[] methods = TestClass.class.getMethods();
		for (Method method: methods)
		{
			System.out.println("Method Name: " + method.getName());
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation: annotations)
			{
				System.out.println("Annotation: " + annotation.toString());
				Test test = (Test) annotation;
				System.out.println("Value: " + test.value());
			}
		}
	}

}
