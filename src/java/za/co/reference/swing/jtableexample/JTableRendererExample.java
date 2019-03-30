package za.co.reference.swing.jtableexample;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

/*
 * A Cell Renderer is used to render the cells in a table
 * A Cell Editor is used when the user edits the cells
 * 
 * To create a renderer, create a class that extends a Swing component, and that implements TableCellRenderer. 
 * See inner class MyRenderer.
 * To implement the renderer, override the "public TableCellRenderer getCellRenderer(int row, int column)" method
 * in the table model (Couldn't get it to work) try this:
 * 		TableColumn tableColumn = table.getColumnModel().getColumn(2);
   		tableColumn.setCellRenderer(myRenderer);
 * 
 *  To apply the renderer to the entire table, use "table.setDefaultRenderer(Color.class, myRenderer)".
 */
public class JTableRendererExample extends WindowDecorator{

	public JTableRendererExample(Window decoratedWindow){
		super(decoratedWindow);
		JTable table = new JTable(new MyTableModel(createData()));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        TableColumn tableColumn = table.getColumnModel().getColumn(2);
        tableColumn.setCellRenderer(myRenderer);
		
        //Setting selection allowed
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(scrollPane);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}
	
	public ArrayList<TableData> createData(){
		ArrayList<TableData> tableDataList = new ArrayList<TableData>();
		tableDataList.add(new TableData("John", "Doe", "20"));
		tableDataList.add(new TableData("Jim", "Doughnut", "20"));
		tableDataList.add(new TableData("Jake", "Donkey", "20"));
		tableDataList.add(new TableData("Jill", "Dough", "20"));
		return tableDataList;
	}
	
	public class MyRenderer extends JLabel implements TableCellRenderer{
		
		public MyRenderer() {
	        setOpaque(true); //MUST do this for background to show up.
	    }

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
			boolean hasFocus, int row, int column){
			Color selectedColor = Color.CYAN;
			Color notSelectedColor = Color.YELLOW;
			if (isSelected){
				setBackground(selectedColor);
				setText(value.toString());
			}
			else{
				setBackground(notSelectedColor);
				setText(value.toString());
			}
			return this;
		}
		
	}
	
	public class MyTableModel extends AbstractTableModel{
		
		public MyTableModel(ArrayList<TableData> tableDataList){
			setColumnData(tableDataList);
		}

		@Override
		public int getColumnCount(){
			return 3;
		}

		@Override
		public int getRowCount(){
			return columnData.size();
		}

		@Override
		public Object getValueAt(int row, int column){
			switch (column){
			case 0: 
				return columnData.get(row).getFirstname();
			case 1:
				return columnData.get(row).getSurname();
			case 2:
				return columnData.get(row).getAge();
			default:
				return null;
			}
		}
		
		public String getColumnName(int column) {
			switch (column){
			case 0: 
				return "Firstname";
			case 1:
				return "Surname";
			case 2:
				return "Age";
			default:
				return null;
			}
        }
		
		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
		
		public ArrayList<TableData> getColumnData(){
			return columnData;
		}

		public void setColumnData(ArrayList<TableData> columnData){
			this.columnData = columnData;
		}
		
		private ArrayList<TableData> columnData;
		
	}
	
	public class TableData{
		
		public TableData(){
			
		}
		
		public TableData(String firstname, String surname, String age){
			this.firstname = firstname;
			this.surname = surname;
			this.age = age;
		}
	
		public String getFirstname(){
			return firstname;
		}
		
		public void setFirstname(String firstname){
			this.firstname = firstname;
		}
		
		public String getSurname(){
			return surname;
		}
		
		public void setSurname(String surname){
			this.surname = surname;
		}
		
		public String getAge(){
			return age;
		}
		
		public void setAge(String age){
			this.age = age;
		}
		
		private String firstname;
		private String surname;
		private String age;
		
	}
	
	private MyRenderer myRenderer = new MyRenderer();

}
