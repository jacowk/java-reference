package za.co.reference.threads.schedulethread;

import java.applet.*;
import java.awt.*;

public class ScheduleThreads extends Applet
{
	Counter low,high;

	public void init()
	{
		low=new Counter(200);
		high=new Counter(0);
		low.setPriority(Thread.MIN_PRIORITY);
		high.setPriority(Thread.MAX_PRIORITY);
		System.out.println("high priority is "+high.getPriority());
		System.out.println("low  priority is "+low.getPriority());
	}

	public void start()
	{
		low.start();
		high.start();
		while(high.getCount()<low.getCount())
		{
			repaint();
		}
		repaint();
		low.stop();
		high.stop();
	}

	public void paint(Graphics g)
	{
		g.drawString("low = "+low.getCount()+ " high= "+high.getCount(),10,10);
                System.out.println("low = "+low.getCount()+ " high= "+high.getCount());
	}
	
	public void stop()
	{
		low.stop();
		high.stop();
	}
}


