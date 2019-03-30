package za.co.reference.quartz.example4;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MoreTriggerJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Job name: " + context.getJobDetail().getName());
		System.out.println("Trigger name: " + context.getTrigger().getName());
		System.out.println("Firing Time: " + context.getFireTime());
	}

}
