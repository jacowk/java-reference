package za.co.reference.ejb3.inteceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyInterceptor{
	
	@AroundInvoke
	public Object someMethod(InvocationContext invocationContext){
		//do stuff
		try{
			return invocationContext.proceed();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
