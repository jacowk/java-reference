package za.co.reference.swing.formattedtextfieldexample;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class MoneyFormattedTextFieldExample extends JFrame{
	
	public MoneyFormattedTextFieldExample(){
		setupFormats();
		initComponents();
	}
	
	private void setupFormats(){
		moneyDisplayFormatter = new NumberFormatter(new DecimalFormat("R #,###.00"));
		moneyDisplayFormatter.setValueClass(Double.class);
		moneyDefaultFormatter = new NumberFormatter(new DecimalFormat("R #,###.00"));
		moneyDefaultFormatter.setValueClass(Double.class);
		moneyEditFormatter = new NumberFormatter(new DecimalFormat("#,###.00"));
		moneyEditFormatter.setValueClass(Double.class);
	}
 
	private void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(200, 200));
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		
		DefaultFormatterFactory defaultFormatterFactory = new DefaultFormatterFactory(moneyDefaultFormatter, 
			moneyDisplayFormatter, moneyEditFormatter);
		
		moneyTextFieldA = new JFormattedTextField();
		moneyTextFieldA.setFormatterFactory(defaultFormatterFactory);
		moneyTextFieldA.setColumns(10);
   
		moneyTextFieldB = new JFormattedTextField();
		moneyTextFieldB.setFormatterFactory(defaultFormatterFactory);
		moneyTextFieldB.setColumns(10);
		
		getContentPane().add(moneyTextFieldA);
		getContentPane().add(moneyTextFieldB);
	}
 
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MoneyFormattedTextFieldExample().setVisible(true);
			}
		});
	}
    
	private NumberFormatter moneyDisplayFormatter;
	private NumberFormatter moneyDefaultFormatter;
	private NumberFormatter moneyEditFormatter;
	private JFormattedTextField moneyTextFieldA;
	private JFormattedTextField moneyTextFieldB;

}