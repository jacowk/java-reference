package za.co.reference.swing.test;

import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;

public class FormattedTextField extends JFormattedTextField{

    public FormattedTextField(){
System.out.println("FormattedTextField.FormattedTextField() 1");
        installExtensions();
    }

    public FormattedTextField(Object value){
        super(value);
System.out.println("FormattedTextField.FormattedTextField() 2");
        installExtensions();
    }

    public FormattedTextField(java.text.Format format){
        super(format);
System.out.println("FormattedTextField.FormattedTextField() 3");
        installExtensions();
    }

    public FormattedTextField(AbstractFormatter formatter){
        super(formatter);
System.out.println("FormattedTextField.FormattedTextField() 4");
        installExtensions();
    }

    public FormattedTextField(AbstractFormatterFactory factory){
        super(factory);
System.out.println("FormattedTextField.FormattedTextField() 5");
        installExtensions();
    }

    public FormattedTextField(AbstractFormatterFactory factory, Object currentValue){
        super(factory, currentValue);
System.out.println("FormattedTextField.FormattedTextField() 6");
        installExtensions();
    }

    @Override
    public void setText(String text){
    	super.setText(text);
System.out.println("FormattedTextField.setText()");
//    	if (isEditable()){
//    		if (hasFocus()){
//    			selectAll();
//    		}
//    	}
//    	else{
//    		if (text != null){
//                setToolTipText(text);
//    		}
//    		else{
//    			setToolTipText(null);
//    		}
//        }
    }

    @Override
    protected void processFocusEvent(FocusEvent e){
    	super.processFocusEvent(e);
System.out.println("FormattedTextField.processFocusEvent()");
//    	if (e.getID() == FocusEvent.FOCUS_GAINED){
//    		if (isEditable()){
//    			selectAll();
//    		}
//    	}
    }

    private void installExtensions(){
System.out.println("FormattedTextField.installExtensions()");
//        textComponentEditor.addTextComponent(this);
    }

    private TextComponentEditor textComponentEditor = new TextComponentEditor();

}