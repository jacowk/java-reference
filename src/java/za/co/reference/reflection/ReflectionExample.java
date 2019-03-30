package za.co.reference.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

public class ReflectionExample{
	
	//C:\Users\jacok\Documents\Backup\Java Documentation\tutorial\reflect\TOC.html
	//http://java.sun.com/developer/technicalArticles/ALT/Reflection/
	//http://www.avajava.com/tutorials/lessons/how-do-i-get-and-set-a-field-using-reflection.html
	//http://us.tintin.com/meet-the-characters/
	//http://www.exampledepot.com/egs/javax.swing.table/ColResize.html
	//www.coderanch.com
	
	/*
	 * Practice list:
	 * --------------
	 * Get a class (3 ways)
	 * Instantiate class
	 * Instantiate class via constructor
	 * Obtain super class
	 * Obtain all classes
	 * Obtain all declared classes
	 * Obtain declaring class
	 * Obtain enclosing class
	 * For a class, obtain...
	 * ...Modifiers
	 * ...Type Parameters
	 * ...Interfaces
	 * ...Annotations
	 * ...Constructors (then instantiate a class via the constructor)
	 * ...Declared Constructors
	 * ...Declared Methods
	 * ...Declared Fields
	 * ...Method by name
	 * ...Field by name
	 * For a field,...
	 * ...obtain type
	 * ...obtain generic type
	 * ...obtain modifiers
	 * ...set field value
	 * Invoke a method
	 * For a method, obtain...
	 * ...return type
	 * ...generic return type
	 * ...parameter types
	 * ...generic parameter types
	 * ...exception types
	 * For arrays...
	 * ...identify a member in a class that is an array
	 * ...create an array
	 * ...get and set array components
	 * For enumerated types... (remember set accessible on a field)
	 * ...get enum constants
	 * ...identify a member that is an enum
	 * ...set an enum field
	 * 
	 */

	public static void main(String[] args){
		ReflectionExample reflectionExample = new ReflectionExample();
		Class clazz = reflectionExample.obtainClassWithGetClass(new MyConcreteClass());
//		Class clazz = reflectionExample.obtainClassWithClassDotForName("za.co.reference.reflection.MyConcreteClass");
		
//		/* All classes */
//		Class[] classes = reflectionExample.getAllClasses(clazz);
//		System.out.println("All classes:");
//		for (Class clazzz: classes){
//			System.out.println(clazzz.getName());
//		}
//		
//		/* Declaring class */
//		Class[] declaredClasses = reflectionExample.getAllDeclaredClasses(clazz);
//		System.out.println("\nDeclared classes:");
//		for (Class clazzz: declaredClasses){
//			System.out.println(clazzz.getCanonicalName());
//		}
//		
//		/* Enclosing class */
//		
//		/* Modifiers */
//		System.out.println("\nModifiers:");
//		System.out.println(reflectionExample.getModifiers(clazz));
//		
//		/* Type Parameters */
//		System.out.println("\nType Parameters:");
//		TypeVariable[] typeVariables = reflectionExample.getTypeParameters(clazz);
//		if (typeVariables.length > 0){
//			for (TypeVariable typeVariable: typeVariables){
//				System.out.println(typeVariable.getName());
//			}
//		}
//		else{
//			System.out.println("None");
//		}
//		
//		/* Implemented Interfaces */
//		System.out.println("\nImplemented Interfaces:");
//		Type[] interfaces = reflectionExample.getInterfaces(clazz);
//		if (interfaces.length > 0){
//			for (Type type: interfaces){
//				System.out.println(type.toString());
//			}
//		}
//		else{
//			System.out.println("None");
//		}
//		
//		/* Annotations */
//		System.out.println("\nAnnotations:");
//		Annotation[] annotations = reflectionExample.getAnnotations(clazz);
//		if (annotations.length > 0){
//			for (Annotation annotation: annotations){
//				MyAnnotation myAnnotation = (MyAnnotation)annotation;
//				System.out.println("Name: " + myAnnotation.name());
//				AnotherAnnotation[] anotherAnnotations = myAnnotation.middleNames();
//				for (AnotherAnnotation anotherAnnotation: anotherAnnotations){
//					System.out.println("Middle Name: " + anotherAnnotation.middleName());
//				}
//			}
//		}
//		else{
//			System.out.println("None");
//		}
//		
//		/* Inheritance Path */
//		Class superClass = reflectionExample.getSuperClass(clazz);
//		System.out.println("\nSuper class:");
//		System.out.println(superClass.getCanonicalName());
//		
//		/* Private Methods */
//		System.out.println("\nPrivate Methods:");
//		Method[] privateMethods = reflectionExample.getDeclaredMethods(clazz);
//		if (privateMethods.length > 0){
//			for (Member privateMember: privateMethods){
//				System.out.println(((Method) privateMember).getName());
//			}
//			
//			
//			for (Method privateMethod: privateMethods){
//				System.out.println(privateMethod.getName());
//			}
//		}
//		
//		/* Inherited Methods */
//		System.out.println("\nInherited Methods:");
//		Method[] inheritedMethods = reflectionExample.getMethods(clazz);
//		if (inheritedMethods.length > 0){
//			for (Method inheritedMethod: inheritedMethods){
//				System.out.println(inheritedMethod.getName());
//			}
//		}
//		
//		/* Obtain Field Types */
//		System.out.println("\nObtain Field Types");
//		Field[] fields = reflectionExample.getDeclaredFields(clazz);
//		for (Field field: fields){
//			reflectionExample.displayFieldType(field);
//		}
//		
//		/* Retrieving and Parsing Field Modifiers */
//		System.out.println("\nRetrieving and Parsing Field Modifiers");
//		fields = reflectionExample.getDeclaredFields(clazz);
//		for (Field field: fields){
//			reflectionExample.displayFieldModifiers(field);
//		}
//		
//		/* Getting and Setting Field Values */
//		System.out.println("Getting and Setting Field Values: ");
//		Field field = reflectionExample.getFieldByName(clazz, "accessibleField");
//		MyConcreteClass myConcreteClass = new MyConcreteClass();
//		System.out.println("AccessibleField value before set: " + myConcreteClass.getAccessibleField());
//		reflectionExample.setLongFieldValue(myConcreteClass, field, 1000);
//		System.out.println("AccessibleField value after set: " + myConcreteClass.getAccessibleField());
//		
//		/* Obtaining Method Type Information */
//		System.out.println("Obtaining Method Type Information: ");
//		Method method = reflectionExample.getMethodByName(clazz, "testMethod", int.class, long.class, 
//			String.class);
//		reflectionExample.displayMethodInfo(method);
//		
//		/* Invoke method */
//		System.out.println("Invoke a method");
//		Object instantiatedClass = reflectionExample.instantiateClass(clazz);
//		Method method = reflectionExample.getMethodByName(clazz, "invokeMethod", String.class, String.class);
//		Object returnedValue = reflectionExample.invokeMethod(method, instantiatedClass, "John", "Doe");
//		System.out.println("Returned value: " + returnedValue.toString());
//		
//		/*
//		 * Identify Array Type
//		 */
//		System.out.println("Identify Array Type:");
//		reflectionExample.identifyArrayType(clazz);
//		
//		/*
//		 * Create New Array
//		 */
//		System.out.println("Create a new array:");
//		String[] strings = { "Jack", "Jill", "John", "Jim", "James" };
//		Object[] objects = reflectionExample.createNewArray(MyArrayClass.class, strings);
//		System.out.println("Generated array: ");
//		for (Object object: objects){
//			MyArrayClass myArrayClass = (MyArrayClass) object;
//			System.out.println(myArrayClass.getValue());
//		}
//		
//		/* Getting and Setting Arrays and Their Components */
//		System.out.println("Getting and Setting Arrays and Their Components");
//		reflectionExample.gettingAndSettingArraysAndComponents();
//		
//		/* Examining Enums */
//		System.out.println("Examining Enums:");
//		reflectionExample.examiningEnumTypes(MyEnum.class);
		
		/* Getting and Setting Fields with Enum Types */
		System.out.println("Getting and Setting Fields with Enum Types:");
		MyConcreteClass myConcreteClass = new MyConcreteClass();
		reflectionExample.gettingAndSettingEnumTypeFields(myConcreteClass.getClass(), myConcreteClass);
	}
	
	/*
	 * Retrieving the class object
	 */
	public Class obtainClassWithDotClass(){
		return MyConcreteClass.class;
	}
	
	public Class obtainClassWithGetClass(MyConcreteClass myConcreteClass){
		return myConcreteClass.getClass();
	}
	
	public Class obtainClassWithClassDotForName(String name){
		try{
			return Class.forName(name);
		}
		catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		return null;
	}
	
	public Class obtainClassForPrimitiveWithType(){
		/* Only for primitive types and void */
//		return Byte.TYPE;
//		return Short.TYPE;
//		return Integer.TYPE;
//		return Long.TYPE;
//		return Float.TYPE;
//		return Double.TYPE;
		return Void.TYPE;
	}
	
	/*
	 * Instantiate class via class
	 */
	public Object instantiateClass(Class clazz){
		try{
			return clazz.newInstance();
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
		catch (InstantiationException ie){
			ie.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Instantiate class via constructor
	 */
	public Object instantiateClass(Constructor constructor){
		try{
			return constructor.newInstance();
		}
		catch (InvocationTargetException ite){
			ite.printStackTrace();
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
		catch (InstantiationException ie){
			ie.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Methods that return classes
	 */
	public Class getSuperClass(Class clazz){
		return clazz.getSuperclass();
	}
	
	public Class[] getAllClasses(Class clazz){
		/* Returns all the public classes, interfaces, and enums that are members of the class including inherited members */
		return clazz.getClasses();
	}
	
	public Class[] getAllDeclaredClasses(Class clazz){
		/* Returns all of the classes interfaces, and enums that are explicitly declared in this class (Inner classes) */
		return clazz.getDeclaredClasses();
	}
	
	public Class getDeclaringClass(Class clazz){
		/* Returns the Class in which these members were declared. */
		return clazz.getDeclaringClass();
	}
	
	public Class getEnclosingClass(Class clazz){
		/* Returns the Class in which these members were declared. */
		return clazz.getEnclosingClass();	
	}
	
	/*
	 * Examining Class Modifier and Types
	 */
	public String getModifiers(Class clazz){
		return Modifier.toString(clazz.getModifiers());
	}
	
	public TypeVariable[] getTypeParameters(Class clazz){
		return clazz.getTypeParameters();
	}
	
	public Type[] getInterfaces(Class clazz){
		return clazz.getGenericInterfaces();
	}
	
	public Annotation[] getAnnotations(Class clazz){
		return clazz.getAnnotations();
	}
	
	/*
	 * Discovering Class Members
	 */
	public Constructor[] getConstructors(Class clazz){ //Get inherited members
		return clazz.getConstructors();
	}
	
	public Method[] getMethods(Class clazz){ //Get inherited members
		return clazz.getMethods();
	}
	
	public Field[] getFields(Class clazz){ //Get inherited members
		return clazz.getFields();
	}
	
	public Constructor[] getDeclaredConstructors(Class clazz){ //Get private members
		return clazz.getDeclaredConstructors();
	}
	
	public Method[] getDeclaredMethods(Class clazz){ //Get private members
		return clazz.getDeclaredMethods();
	}
	
	public Field[] getDeclaredFields(Class clazz){ //Get private members
		return clazz.getDeclaredFields();
	}
	
	public Field getFieldByName(Class clazz, String name){
		try{
			return clazz.getDeclaredField(name);
		}
		catch (NoSuchFieldException nsfe){
			nsfe.printStackTrace();
		}
		return null;
	}
	
	public Method getMethodByName(Class clazz, String name, Class... parameterTypes){
		try{
			return clazz.getDeclaredMethod(name, parameterTypes);
		}
		catch (NoSuchMethodException nsfe){
			nsfe.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Obtaining field types
	 */
	public void displayFieldType(Field field){
		System.out.println("Name: " + field.getName() + ", Type: " + field.getType());
		System.out.println("Name: " + field.getName() + ", Generic Type: " + field.getGenericType());
	}
	
	/*
	 * Retrieving and Parsing Field Modifiers
	 */
	public void displayFieldModifiers(Field field){
		 /*PUBLIC = 1
		 PRIVATE = 2
		 PROTECTED = 4*/
		if (field.getModifiers() == 1){
			System.out.println("Name: " + field.getName() + ", Modifier: public");
		}
		else if (field.getModifiers() == 2){
			System.out.println("Name: " + field.getName() + ", Modifier: private");
		}
		else if (field.getModifiers() == 4){
			System.out.println("Name: " + field.getName() + ", Modifier: protected");
		}
	}
	
	/*
	 * Setting Field Values
	 */
	public MyConcreteClass setLongFieldValue(MyConcreteClass myConcreteClass, Field field, long value){
		try{
			field.setLong(myConcreteClass, value);
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
		return myConcreteClass;
	}
	
	/*
	 * Obtaining Method Type Information
	 */
	public void displayMethodInfo(Method method){
		System.out.println("ReturnType: " + method.getReturnType().getName());
		System.out.println("GenericReturnType: " + method.getGenericReturnType().toString());
		
		System.out.println("Parameter Types:");
		Class[] parameterTypes = method.getParameterTypes();
		for (Class clazz: parameterTypes){
			System.out.println("-" + clazz.getName());
		}
		
		System.out.println("Generic Parameter Types:");
		Class[] genericParameterTypes = method.getParameterTypes();
		for (Class clazz: genericParameterTypes){
			System.out.println("-" + clazz.getName());
		}
		
		System.out.println("Exception Types:");
		Class[] exceptionTypes = method.getExceptionTypes();
		for (Class clazz: exceptionTypes){
			System.out.println("-" + clazz.getName());
		}
	}
	
	/*
	 * Retrieving and Parsing Method Modifiers
	 * 
	 * Method m = ....
	 * m.isSynthetic(), m.isVarArgs(), m.isBridge()
	 * 
	 * synthetic (compiler-generated), of 
	 * variable arity, or 
	 * a bridge method (compiler-generated to support generic interfaces)
	 * 
	 */
	
	/*
	 * Invoke Method
	 */
	public Object invokeMethod(Method method, Object instantiatedClass, Object... arguments){
		try{
			return method.invoke(instantiatedClass, arguments);
		}
		catch (InvocationTargetException ite){
			ite.printStackTrace();
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Arrays: Identifying Array Types
	 */
	public void identifyArrayType(Class clazz){
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields){
			Class<?> type = field.getType();
			if (type.isArray()){
				System.out.println(field.getName() + " is an array of type " + type.getComponentType().getName());
			}
		}
	}
	
	/*
	 * Arrays: Create New Array
	 */
	public Object[] createNewArray(Class clazz, String[] values){
		try{
			Object arrayObject = Array.newInstance(clazz, values.length);
			for (int i = 0; i < values.length; i++){
				Constructor constructor = clazz.getConstructor(String.class);
				Object valueObject = constructor.newInstance(values[i]);
				Array.set(arrayObject, i, valueObject);
			}
			Object[] object = (Object[]) arrayObject;
			return object;
		}
		catch (NoSuchMethodException nsme){
			nsme.printStackTrace();
		}
		catch (InvocationTargetException ite){
			ite.printStackTrace();
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
		catch (InstantiationException ie){
			ie.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Getting and Setting Arrays and Their Components
	 * 
	 * To set entire array at once: java.lang.reflect.Field.set(Object obj, Object value)
	 * To retrieve the entire array: Field.get(Object)
	 * Individual components can be set or retrieved using methods in java.lang.reflect.Array
	 * 		Array.setInt(Object array, int index, int value) 
	 * 		Array.getInt(Object array, int index)
	 * The components of arrays of reference types (including arrays of arrays) are set and retrieved using 
	 * 		Array.set(Object array, int index, int value)and 
	 * 		Array.get(Object array, int index)
	 * 
	 * Other methods:
	 *	Arrays.copyOf
	 */
	public void gettingAndSettingArraysAndComponents(){
		Object myArray = Array.newInstance(String.class, 5);
//		Object myArray = Array.newInstance(String.class, 5, 5); //Multidimensional array
		Array.set(myArray, 0, "John");
		Array.set(myArray, 1, "Jim");
		Array.set(myArray, 2, "James");
		Array.set(myArray, 3, "Jack");
		Array.set(myArray, 4, "Jake");
		for (int i = 0; i < 5; i++){
			Object value = Array.get(myArray, i);
			System.out.println("Value: " + value);
		}
		System.out.println("\nUsing Arrays.asList:");
		for (Object object: Arrays.asList(myArray)){
			System.out.println("Value: " + object);
		}
	}
	
	/*
	 * Enumerated Types:
	 *  Applicable APIs: Class.isEnum(), Class.getEnumConstants(), and java.lang.reflect.Field.isEnumConstant()
	 */
	
	/*
	 * Examining Enum Types
	 */
	public void examiningEnumTypes(Class clazz){
		if (clazz.isEnum()){
			List<Object> constants = Arrays.asList(clazz.getEnumConstants());
			System.out.println("Enum constants:");
			for (Object object: constants){
				System.out.println("Constant: " + object);
			}
		}
	}
	
	/*
	 * Getting and Setting Fields with Enum Types
	 */
	public void gettingAndSettingEnumTypeFields(Class clazz, MyConcreteClass myConscreteClass){
		try{
			Field enumField = clazz.getDeclaredField("myEnum");
			enumField.setAccessible(true);
			System.out.println("Is enum constant: " + enumField.isEnumConstant());
			MyEnum myEnum = (MyEnum) enumField.get(myConscreteClass);
			System.out.println("Enum before value: " + myEnum.getValue());
			enumField.set(myConscreteClass, MyEnum.TWO);
			myEnum = (MyEnum) enumField.get(myConscreteClass);
			System.out.println("Enum after value: " + myEnum.getValue());
		}
		catch(NoSuchFieldException nsfe){
			nsfe.printStackTrace();
		}
		catch (IllegalAccessException iae){
			iae.printStackTrace();
		}
	}
	
}