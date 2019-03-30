package za.co.reference.practice;

import java.util.Date;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/*
 * ****Remember to test the Listeners
 * 
 * 1. Get a SchedulerFactory instance (StdSchedulerFactory/????)
 * 2. Get a Scheduler object from the SchedulerFactory
 * 3. Start the Scheduler
 * 4. Get a JobDetail instance (Name, Group, Job class)
 * 5. Get a Trigger instance (SimpleTrigger or CronTrigger)
 * 		SimpleTrigger: name, group, start time, end time, repeat count, repeat interval
 * 
 * To Practice, include the following:
 * 1. Create a SimpleTrigger
 * 2. Create a CronTrigger
 * 3. Use a JobDataMap
 * 4. Add multiple Jobs to a Scheduler
 * 5. Shutdown the Scheduler
 * 
 */
public class PracticeQuartzScheduler{
	
	public PracticeQuartzScheduler() throws Exception{
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobDetail jobDetailOne = new JobDetail("testJob", scheduler.DEFAULT_GROUP, PracticeQuartzJob.class);
		
		/* Include JobDataMap */
		jobDetailOne.getJobDataMap().put("name", "Rose India");
		jobDetailOne.getJobDataMap().put("floatValue",5.14f);
		
		SimpleTrigger simpleTrigger = new SimpleTrigger(
			"testTrigger",
			scheduler.DEFAULT_GROUP,
			new Date(), 
			null,
			SimpleTrigger.REPEAT_INDEFINITELY,
			60L * 1000L);
		scheduler.scheduleJob(jobDetailOne, simpleTrigger);
		
		/* Adding a cron trigger */
		JobDetail jobDetailTwo = new JobDetail("testJob", "group2", PracticeQuartzJob.class);
		CronTrigger cronTrigger = new CronTrigger("cronTrigger","group2","0 0/1 * * * ?");
		scheduler.scheduleJob(jobDetailTwo, cronTrigger);
		
		scheduler.start();
		
		//Shutdown scheduler
		if (!scheduler.isShutdown()){
			scheduler.shutdown();
		}
	}
	
	public static void main(String[] args){
		try{
			new PracticeQuartzScheduler();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
