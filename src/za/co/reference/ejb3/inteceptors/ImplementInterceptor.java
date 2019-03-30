package za.co.reference.ejb3.inteceptors;

import javax.interceptor.Interceptors;

public class ImplementInterceptor{

	@Interceptors(MyInterceptor.class)
	public void someMethod(){
		
	}
	
}
