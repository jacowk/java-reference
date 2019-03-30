package za.co.reference.threads.schedulethread;

public class Counter extends Thread
{
	int Count;

	public Counter()
	{
		Count=0;
	}

	public Counter(int x)
	{
		Count=x;
	}


	public void run()
	{
		while(true)
		{
			Count++;
			try {
				sleep(10);
			} catch(InterruptedException e){}
		}
	}

	public int getCount()
	{
		return Count;
	}
}

