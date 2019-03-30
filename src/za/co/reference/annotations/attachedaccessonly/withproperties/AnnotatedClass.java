package za.co.reference.annotations.attachedaccessonly.withproperties;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import za.co.reference.annotations.attachedaccessonly.AttachedAccessOnly;

public class AnnotatedClass{
	
	public String getPropertyOne(){
		return propertyOne;
	}
	
	public void setPropertyOne(String propertyOne){
		this.propertyOne = propertyOne;
	}
	
	public String getPropertyTwo(){
		return propertyTwo;
	}
	
	@AttachedAccessOnly
	public void setPropertyTwo(String propertyTwo){
		this.propertyTwo = propertyTwo;
	}
	
	public String getPropertyThree(){
		return propertyThree;
	}
	
	public void setPropertyThree(String propertyThree){
		this.propertyThree = propertyThree;
	}
	
	public boolean isPropertyFour(){
		return propertyFour;
	}

	public void validateProperties(){
		for (String property: listProperties()){
			validateProperty(property);
		}
	}
	
	private Collection<String> listProperties(){
		Set<String> properties = new LinkedHashSet<String>();
		Class returnType;
		String property;
		for (Method method: getClass().getMethods()){
			if (method.getName().startsWith("get")){
				property = method.getName().substring(3);
			}
			else if (method.getName().startsWith("is")){
				property = method.getName().substring(2);
			}
			else{
				continue;
			}
			if (isAttachedAccessPermitted(method)){
				continue;
			}
			returnType = method.getReturnType();
			/*Test if setter method exists*/
			try{
				getClass().getMethod("set" + property, returnType);
			}
			catch (NoSuchMethodException nsme){
				continue;
			}
			/*Adds property with first character lowercase*/
			properties.add(property.substring(0, 1).toLowerCase() + property.substring(1));
		}
		return properties;
	}
	
	private void validateProperty(String property){
		Method getterMethod = getGetterMethod(property);
		Method setterMethod = getSetterMethod(property);
		if (setterMethod == null){
			return;
		}
		try{
			Object returnObject = getterMethod.invoke(this);
			setterMethod.invoke(this, returnObject);
			System.out.println(getterMethod.getName() + " invoked");
			System.out.println(setterMethod.getName() + " invoked");
		}
		catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private boolean isAttachedAccessPermitted(Method method){
		//Validate method is not null
		return method.getAnnotation(AttachedAccessOnly.class) != null;
	}
	
	private Method getGetterMethod(String property){
		Method getterMethod = null;
		try{
			getterMethod = getClass().getMethod("get" + property.substring(0, 1).toUpperCase() + property.
				substring(1));
		}
		catch (NoSuchMethodException nsme){
			try{
				getterMethod = getClass().getMethod("is" + property.substring(0, 1).toUpperCase() + property.
					substring(1));
			}
			catch (NoSuchMethodException nsme1){
				throw new RuntimeException("No getter method for " + property + ": " + nsme1.getCause());
			}
		}
		return getterMethod;
	}
	
	private Method getSetterMethod(String property){
		Class returnType = getGetterMethod(property).getReturnType();
		try{
			Method setterMethod = getClass().getMethod("set" + property.substring(0, 1).toUpperCase() + 
				property.substring(1), returnType);
			if (isAttachedAccessPermitted(setterMethod)){
				return null;
			}
			return setterMethod;
		}
		catch(NoSuchMethodException e){
			throw new RuntimeException("Unable to retrieve setter method for property - " + property +
				". " + e.getCause(), e);
		}
	}
	
	private String propertyOne;
	private String propertyTwo;
	private String propertyThree;
	private boolean propertyFour;

}
