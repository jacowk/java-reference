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
 
public class FormattedTextFieldExample extends JFrame {
    public FormattedTextFieldExample() {
        initComponents();
    }
 
    private void initComponents() {
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
 
        //
        // Here we create a formatted text field that accept a date value. We
        // create an instance of SimpleDateFormat and use it to create a
        // DateFormatter instance which will be passed to the JFormattedTextField.
        //
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateFormatter df = new DateFormatter(format);
        JFormattedTextField dateField = new JFormattedTextField(df);
        dateField.setPreferredSize(new Dimension(100, 20));
        dateField.setValue(new Date());
 
        getContentPane().add(phoneField);
        getContentPane().add(dateField);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormattedTextFieldExample().setVisible(true);
            }
        });
    }
}