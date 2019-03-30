package za.co.reference.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class IntrospectAnnotation{
	
	public static void main(String[] args){
		Method[] methods = AnnotationExample.class.getMethods();
		for (int i = 0; i < methods.length; i++){
			Method method = methods[i];
			System.out.println(method.getName());
			Annotation[] annotations = method.getAnnotations();
			System.out.println("Annotations: " + annotations.length);
			for (Annotation annotation: annotations){
				System.out.println(annotation.toString());
				if (annotation instanceof MyAnnotation){
					MyAnnotation myAnnotation = (MyAnnotation)annotation;
					System.out.println(method.getName() + " has MyAnnotation: " +
						myAnnotation.outputStuff());
				}
			}
		}
	}

}
