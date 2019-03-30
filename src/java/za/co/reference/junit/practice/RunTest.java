package za.co.reference.junit.practice;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunTest {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CalculateTest.class);
		for (Failure failure: result.getFailures()){
			System.out.println(failure.toString());
		}
	}

}
