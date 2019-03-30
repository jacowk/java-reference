package za.co.reference.ejb3.globalinterceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/*
 * This interceptor will be called for every method call in the application, because it is declared in ejb-jar.xml
 * You can then define a custom annotation which can be exploited via reflection, to do things like
 * permission checks and audit logging
 */
public class GlobalInterceptor{
	
	@AroundInvoke
	public Object checkPermission(InvocationContext invocation) throws Exception{
		if (invocation.getMethod().getDeclaringClass().getAnnotation(CustomAnnotation.class) != null){
			//dostuff
		}
		return invocation.proceed();
	}

}
