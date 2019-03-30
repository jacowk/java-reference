package za.co.reference.practice;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PracticeQuartzJob implements Job{

	@Override
	public void execute(JobExecutionContext jec) throws JobExecutionException{
		System.out.println("This is a test job");
		
		/* Retrieve JobDataMap info */
		String jname = jec.getJobDetail().getName();
		String jgroup = jec.getJobDetail().getGroup();
		
		JobDataMap jobDataMap = jec.getJobDetail().getJobDataMap();
		float floatValue = jobDataMap.getFloat("floatValue");
	}

}
