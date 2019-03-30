package za.co.reference.threads;

import java.applet.*;
import java.awt.*;

public class CounterThread2 extends Applet implements Runnable
{	
	Thread t;	
	int Count;
	boolean suspended;

	public void init()	
	{	
		Count=0;
		suspended=false;
		t=new Thread(this);
		t.start();
	}

	public boolean mouseDown(Event e,int x, int y)
	{	
		if(suspended)
			t.resume();
		else
			t.suspend();
		suspended = !suspended;
		return true;
	}

	public void run()
	{
		while(true)
		{
			Count++;
			repaint();
			try {
				t.sleep(10);
			} catch (InterruptedException e) {}
		}
	}

	public void paint(Graphics g)
	{
		g.drawString(Integer.toString(Count),10,10);
		System.out.println("Count= "+Count);
	}
	
	public void stop()
	{
		t.stop();
	}
}

