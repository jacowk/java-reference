package za.co.reference.swing.swingworkerexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

//TODO: Work through the SwingWorker documentation
public class SwingWorkerExample extends WindowDecorator implements ActionListener, 
	PropertyChangeListener{

	public SwingWorkerExample(Window decoratedWindow){
		super(decoratedWindow);
		JPanel panel = new JPanel();
		JPanel progressBarPanel = new JPanel();
		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBarPanel.add(progressBar);
		
		JPanel buttonPanel = new JPanel();
		JButton startButton = new JButton("Start");
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		
		panel.add(progressBarPanel);
		panel.add(buttonPanel);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent ae){
		JButton startButton = (JButton)ae.getSource();
		progressBar.setValue(0);
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt){
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			progressBar.setValue(progress);
		}
	}
	
	public class Task extends SwingWorker<Void, Void>{

		@Override
		protected Void doInBackground() throws Exception{
			setProgress(0);
			Random random = new Random();
			int progress = 0;
			while(progress < 100){
				try{
					Thread.sleep(1000);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
			return null;
		}
		
		@Override
		protected void done(){
			System.out.println("Done");
		}
		
	}
	
	private JProgressBar progressBar;
	private Task task;
	private int progress = 0;

}
