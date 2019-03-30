package za.co.reference.quartz.example3;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.JobDetail;

public class CronSchedule{

	public CronSchedule ()throws Exception{
		SchedulerFactory sf=new StdSchedulerFactory();
		Scheduler sched=sf.getScheduler();
		JobDetail jd=new JobDetail("job1","group1",CronJob.class);
		CronTrigger ct=new CronTrigger("cronTrigger","group2","0 0/1 * * * ?");
		
		sched.scheduleJob(jd,ct);
		sched.start();
		
	}
	
	public static void main(String args[]){
		try{		
			new CronSchedule();
		}
		catch(Exception e){}
	}
	
}
