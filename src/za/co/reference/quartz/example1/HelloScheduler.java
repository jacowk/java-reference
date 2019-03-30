package za.co.reference.quartz.example1;

import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/*
 * 
 * http://www.roseindia.net/quartz/quartz-scheduler-tutorial.shtml
 * 
execute(): Any software
components you want to schedule then you must implement the Job interface and override it execute() method.
JobExecutionContext: The JobExecutionContext object that is passed to execute() method provides the job instance with information about its "run-time" environment - a handle to the Scheduler that executed it, a handle to the Trigger that triggered the execution, the job's JobDetail object, and a few other items.
SchedulerFactory: SchedulerFactory is a interface provides a mechanism for obtaining client-usable handles to Scheduler instances.
StdSchedulerFactory(): A Class StdSchedulerFactory is a class and it is implementation of SchedulerFactory interface. Here it just using for create an instance of SchedulerFactory instance.
Scheduler: Scheduler interface is the main interface (API) to this functionality. It provides some simple operations like scheduling jobs, unscheduling jobs, starting/stopping/pausing the scheduler.
getScheduler(): SchedulerFactoy interface having the getScheduler() method that returns an instance of Scheduler.
start(): This method is used to starts the Scheduler's threads that fire Triggers. At the first time when we create the Scheduler it is in "stand-by" mode, and will not fire triggers. The scheduler can also be send back into stand-by mode by invoking the standby() method.
JobDetail(String name, String group, Class jobclass): The JobDetail object is created at the time the Job is added to scheduler. It contains various property settings like job name, group name and job class name. It can be used to store state information for a given instance of job class.
SimpleTrigger(String name, String group, Date startTime, Date endTime, int repeatCount, long repeatInterval): Trigger objects are used to firing the execution of jobs. When you want to schedule the job, instantiate the trigger and set the properties to provide the scheduling.
DEFAULT_GROUP: It is a constant, specified that Job and Trigger instances are belongs to which group..
REPEAT_INDEFINITELY: It is a constant used to indicate the 'repeat count' of the trigger is indefinite.
scheduleJob(JobDetail jd, SimpleTrigger st): This method is used to add the JobDetail to the Scheduler, and associate the Trigger with it.
 * 
 */

public class HelloScheduler{
	
	public HelloScheduler() throws Exception{
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		JobDetail jobDetail = new JobDetail("myjob", scheduler.DEFAULT_GROUP, HelloJob.class);
		SimpleTrigger simpleTrigger = new SimpleTrigger(
			"mytrigger", 
			scheduler.DEFAULT_GROUP, 
			new Date(),
			null, 
			SimpleTrigger.REPEAT_INDEFINITELY, 
			60L * 1000L);
		scheduler.scheduleJob(jobDetail, simpleTrigger);
	}
	
	public static void main(String[] args){
		try{
			new HelloScheduler();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}

	