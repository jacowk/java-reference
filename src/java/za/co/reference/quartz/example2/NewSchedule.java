package za.co.reference.quartz.example2;

import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/*
 * In this example, a JobDataMap is used
 * Two Types of triggers:
 * 1) SimpleTrigger is used if you need just single execution of a job at a given moment in time or if you 
 * need to start a job at a given time, and have it repeat N times, with a delay of T between executions.  
 * 2) CronTrigger is used when you want to triggering based on calendar-like schedules - such as "every 
 * Saturday, at noon" or "at 12:35 on the 15th day of every month."
 * 
 */
public class NewSchedule{
	
	NewSchedule()throws Exception{
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		JobDetail jd = new JobDetail("myjob","group",NewJob.class);
		jd.getJobDataMap().put("name", "Rose India");
		jd.getJobDataMap().put("floatValue",5.14f);
		SimpleTrigger simpleTrigger = new SimpleTrigger("mytrigger",sched.DEFAULT_GROUP,new Date(),null,
			SimpleTrigger.REPEAT_INDEFINITELY,30L*1000L);
		sched.scheduleJob(jd, simpleTrigger);
		sched.start();
	}
	
	public static void main(String args[]){
		try{
			new NewSchedule();
		}
		catch(Exception e){}
	}
	
}
