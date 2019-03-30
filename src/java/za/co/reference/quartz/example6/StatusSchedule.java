package za.co.reference.quartz.example6;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class StatusSchedule{
	public static void main(String args[])
	{
		try{
			new StatusSchedule();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public StatusSchedule()throws Exception{
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sche = sf.getScheduler();
		sche.start();
		JobDetail jDetail = new JobDetail("Show status",sche.DEFAULT_GROUP,StatusJob.class);
		CronTrigger cronTrigger = new CronTrigger("Cron Trigger",sche.DEFAULT_GROUP,"0 0/1 * * * ?");
		sche.scheduleJob(jDetail, cronTrigger);
		sche.shutdown();
		if(sche.isShutdown()){
			System.out.println("Scheduler is shutdown!");
			System.out.println("Job cann't be executed here.");
		}
		else{
			System.out.println("Scheduler isn't shutdown!");
			System.out.println("Job is executed here.");
		}
	}
}
