package za.co.reference.swing.jtableexample;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

/*
 * A Cell Renderer is used to render the cells in a table
 * A Cell Editor is used when the user edits the cells
 */
public class JTableEditorExample extends WindowDecorator{

	public JTableEditorExample(Window decoratedWindow){
		super(decoratedWindow);
		JTable table = new JTable(new MyTableModel(createData()));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        
        MyEditor myEditor = new MyEditor(new JTextField());
        TableColumn tableColumn = table.getColumnModel().getColumn(2);
        tableColumn.setCellEditor(myEditor);
		
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
	
	public class MyEditor extends DefaultCellEditor{

		public MyEditor(JTextField textField){
			super(textField);
			textField.setText("Enter a value");
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
		
		/*
		 * Add to table
		 */
		public boolean isCellEditable(int row, int col){
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col != 2){
                return false;
            }
            else{
                return true;
            }
        }
		
		/*
		 * Add to table
		 */
        public void setValueAt(Object value, int row, int col){
            columnData.get(row).setAge(value.toString());
            fireTableCellUpdated(row, col);
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

}
