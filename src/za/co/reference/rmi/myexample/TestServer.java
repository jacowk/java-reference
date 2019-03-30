package za.co.reference.rmi.myexample;

import java.rmi.Naming;

public class TestServer{
	
	public static void main(String[] args) throws Exception{
		TestRemoteInterface testImpl = new TestImpl();
		Naming.bind("rmi://localhost/testImplBinding", testImpl);
	}
	
}
