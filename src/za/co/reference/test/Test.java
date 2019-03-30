package za.co.reference.test;

import javax.swing.SwingUtilities;

public class Test{
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new SwingTest();
			}
			
		});
	}

}
