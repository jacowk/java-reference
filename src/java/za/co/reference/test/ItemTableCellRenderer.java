package za.co.reference.test;

import javax.swing.table.DefaultTableCellRenderer;

public class ItemTableCellRenderer extends DefaultTableCellRenderer{
	
	public ItemTableCellRenderer(){
		super();
	}
	
	public void setValue(Object value){
		setText("* " + value);
	}

}
