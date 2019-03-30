package za.co.reference.swing.jtableexample;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JTableExample extends WindowDecorator implements ListSelectionListener, TableModelListener{

	/*
	 * Two constructors:
	 * JTable(Object[][] rowData, Object[] columnNames)
     * JTable(Vector rowData, Vector columnNames)
	 * 
	 */
	public JTableExample(Window decoratedWindow){
		super(decoratedWindow);
		JTable table = new JTable(new MyTableModel(createData()));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        
        //Setting Column Width
        TableColumn tableColumn = table.getColumnModel().getColumn(2);
        tableColumn.setPreferredWidth(10);
        
        //Setting selection allowed
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setCellSelectionEnabled(false);
        
        //Setting selection modes
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Adding ListSelectionListener: Detects user selections
        ListSelectionModel listSelectionModel = table.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
        
        //Adding TableModelListener: Detects data changes made if the table is editable
        TableModel tableModel = table.getModel();
        tableModel.addTableModelListener(this);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(scrollPane);
		addPanel(panel);
	}
	
	public ArrayList<TableData> createData(){
		ArrayList<TableData> tableDataList = new ArrayList<TableData>();
		tableDataList.add(new TableData("John", "Doe", "20"));
		tableDataList.add(new TableData("Jim", "Doughnut", "20"));
		tableDataList.add(new TableData("Jake", "Donkey", "20"));
		tableDataList.add(new TableData("Jill", "Dough", "20"));
		return tableDataList;
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
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
		
		public void setValueAt(Object value, int row, int column){
			switch (column){
			case 0: 
				columnData.get(row).setFirstname(value.toString());
			case 1:
				columnData.get(row).setSurname(value.toString());
			case 2:
				columnData.get(row).setAge(value.toString());
			}
			fireTableCellUpdated(row, column);
			/*
			 * 	fireTableCellUpdated 	Update of specified cell.
				fireTableRowsUpdated 	Update of specified rows
				fireTableDataChanged 	Update of entire table (data only).
				fireTableRowsInserted 	New rows inserted.
				fireTableRowsDeleted 	Existing rows Deleted
				fireTableStructureChanged   	Invalidate entire table, both data and structure.
			 */
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

	//Override for ListSelectionListener
	@Override
	public void valueChanged(ListSelectionEvent e){
		ListSelectionModel listSelectionModel = (ListSelectionModel)e.getSource();
		System.out.println("Selected row " + e.getFirstIndex() + " to " + e.getLastIndex());
	}

	//Override for TableModelListener
	@Override
	public void tableChanged(TableModelEvent e){
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel tableModel = (TableModel)e.getSource();
		String columnName = tableModel.getColumnName(column);
		Object data = tableModel.getValueAt(row, column);
		//do something with the data
	}

}
