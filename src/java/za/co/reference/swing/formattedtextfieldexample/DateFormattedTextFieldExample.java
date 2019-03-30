package za.co.reference.swing.formattedtextfieldexample;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
 
public class DateFormattedTextFieldExample extends JFrame {
	
    public DateFormattedTextFieldExample() {
        initComponents();
    }
 
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(200, 200));
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
 
        MaskFormatter mask = null;
        try {
            //
            // Create a MaskFormatter for accepting phone number, the # symbol accept
            // only a number. We can also set the empty value with a place holder
            // character.
            //
            mask = new MaskFormatter("(###) ###-####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
 
        //
        // Create a formatted text field that accept a valid phone number.
        //
        JFormattedTextField phoneField = new JFormattedTextField(mask);
        phoneField.setPreferredSize(new Dimension(100, 20));
        
        
        MaskFormatter dateMask = null;
        try{
//        	dateMask = new MaskFormatter("AAAA/AA/AA");
        	dateMask = new MaskFormatter("####/##/##");
//        	dateMask.setPlaceholderCharacter('_');
        	dateMask.setPlaceholder("YYYY/MM/DD");
//        	dateMask.setPlaceholder("1900/01/01");
        	dateMask.setValidCharacters("0123456789");
        	
        }
        catch (ParseException pe){
        	pe.printStackTrace();
        }
        JFormattedTextField dateField = new JFormattedTextField(dateMask);
        dateField.setPreferredSize(new Dimension(100, 20));
        dateField.setInputVerifier(new DateInputVerifier());
 
        //
        // Here we create a formatted text field that accept a date value. We
        // create an instance of SimpleDateFormat and use it to create a
        // DateFormatter instance which will be passed to the JFormattedTextField.
        //
//        DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
//        DateFormatter df = new DateFormatter(format);
//        JFormattedTextField dateField = new JFormattedTextField(df);
//        dateField.setPreferredSize(new Dimension(100, 20));
//        dateField.setValue(new Date());
 
        getContentPane().add(phoneField);
        getContentPane().add(dateField);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DateFormattedTextFieldExample().setVisible(true);
            }
        });
    }
    
}