package za.co.reference.quartz.example6;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class StatusJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		String name = context.getJobDetail().getName();
		String group = context.getJobDetail().getGroup();
		System.out.println("Job name: " + name + "\t" + "Group: " + group);
		System.out.println("Trigger name: " + context.getTrigger().getName());
		System.out.println("Friring Time: " + context.getFireTime());
	}
}
