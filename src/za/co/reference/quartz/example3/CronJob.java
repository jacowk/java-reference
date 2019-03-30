package za.co.reference.quartz.example3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.*;


public class CronJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to RoseIndia.net    :"+new Date());
	}

}
