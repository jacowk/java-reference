package za.co.reference.rmi.myexample;

import java.rmi.Naming;

public class TestClient{
	
	public static void main(String[] args) throws Exception{
		TestRemoteInterface testRemoteInterface = (TestRemoteInterface)
			Naming.lookup("rmi://localhost/testImplBinding");
		testRemoteInterface.message("Hello world!");
		testRemoteInterface.message("How are you?");
	}

}
