package za.co.reference.quartz.example1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{
	
	public void execute(JobExecutionContext jec) throws JobExecutionException{
		System.out.println("Hello world quartz job");
	}

}
