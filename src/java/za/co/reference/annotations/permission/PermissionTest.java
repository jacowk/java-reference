package za.co.reference.annotations.permission;

/*
 * This is an interceptor example
 */
public class PermissionTest{
	
	public static void main(String[] args){
		PermissionTest permissionTest = new PermissionTest();
		permissionTest.someMethod();
	}
	
	@Permission(PermissionConstants.SOME_PERMISSION_ONE)
	public void someMethod(){
		
	}

}
