package za.co.reference.testprojects.one;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import za.co.reference.utility.IOUtilities;

public class Test{
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run(){
				new TestApplication();
			}
			
		});
	}

}
