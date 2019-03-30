package za.co.reference.reflection;

@MyAnnotation(name = "John", middleNames = {
	@AnotherAnnotation(middleName = "Jim"),
	@AnotherAnnotation(middleName = "James")
})
public class MyConcreteClass extends MyAbstractClass implements MyInterface{
	
	public MyConcreteClass(){
		
	}
	
	public MyConcreteClass(String someString){
		
	}
	
	public MyConcreteClass(String someString, int someInteger){
		
	}

	public String getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	@Override
	public String myMethodA(){
		return "This is myMethodA";
	}

	@Override
	public String myMethodB(String parameter){
		return "This is myMethodB with parameter " + parameter;
	}
	
	public AnotherClass getAnotherClass(){
		return anotherClass;
	}

	public void setAnotherClass(AnotherClass anotherClass){
		this.anotherClass = anotherClass;
	}
	
	public long getAccessibleField(){
		return accessibleField;
	}

	public void setAccessibleField(long accessibleField){
		this.accessibleField = accessibleField;
	}
	
	public String testMethod(int a, long b, String c){
		return new String("Hello World");
	}
	
	public String invokeMethod(String firstname, String surname){
		return firstname + " " + surname;
	}

	public class MyInnerClass{
		
		public String getaProperty(){
			return aProperty;
		}

		public void setaProperty(String aProperty){
			this.aProperty = aProperty;
		}

		private String aProperty;
		
	}

	private AnotherClass anotherClass;
	private String fieldOne;
	private String fieldTwo;
	protected long accessibleField;
	private int[] integerArray = { 12, 13, 14, 15, 16 };
	protected MyEnum myEnum = MyEnum.ONE;

}