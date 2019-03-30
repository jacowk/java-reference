package za.co.reference.quartz.example4;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/*
 * Implementing multiple triggers
 */
public class MoreTriggerSchedule {
	public static void main(String args[]){
		try{
			new MoreTriggerSchedule();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public MoreTriggerSchedule()throws Exception{
		JobDetail jDetail;
		CronTrigger cronTrigger;
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sche = sf.getScheduler();
		sche.start();
		jDetail = new JobDetail("Job1","group1",MoreTriggerJob.class);
		cronTrigger = new CronTrigger("cronTrigger1","group1","0/5 * * * * ?");
		sche.scheduleJob(jDetail, cronTrigger);
		jDetail = new JobDetail("Job2","group2",MoreTriggerJob.class);
		cronTrigger = new CronTrigger("cronTrigger2","group2","0/8 * * * * ?");
		sche.scheduleJob(jDetail, cronTrigger);
		
	}
}
