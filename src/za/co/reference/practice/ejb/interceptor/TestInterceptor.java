package za.co.reference.practice.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class TestInterceptor{
	
	@AroundInvoke
	public Object testMethod(InvocationContext ic) throws Exception{
		CustomAnnotation ca = ic.getMethod().getAnnotation(CustomAnnotation.class);
		if (ca != null){
			
		}
		return ic.proceed();
	}

}
