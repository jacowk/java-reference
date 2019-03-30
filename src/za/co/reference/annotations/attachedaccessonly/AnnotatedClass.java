package za.co.reference.annotations.attachedaccessonly;

import java.lang.reflect.Method;

public class AnnotatedClass{
	
	@AttachedAccessOnly
	public void annotatedMethod(){
		
	}
	
	public void nonAnnotatedMethod(){
		
	}
	
	public void validateProperties(){
		for (Method method : getClass().getMethods()){
			if (method.getAnnotation(AttachedAccessOnly.class) != null){
				System.out.println(method.getName() + " is annotated with AttachedAccessOnly");
			}
			else{
				System.out.println(method.getName() + " is NOT annotated with AttachedAccessOnly");
			}
		}
	}

}
