package za.co.reference.test;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ItemTableModel extends AbstractTableModel{

	public ItemTableModel(ArrayList<TableData> tableDataList){
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
	
	public ArrayList<TableData> getColumnData(){
		return columnData;
	}

	public void setColumnData(ArrayList<TableData> columnData){
		this.columnData = columnData;
	}

	private ArrayList<TableData> columnData;

	@Override
	public Object getValueAt(int row, int col){
		switch (col){
		case 0:
			return columnData.get(row).getId();
		case 1:
			return columnData.get(row).getFirstname();
		case 2:
			return columnData.get(row).getSurname();
		default:
			return null;
		}
	}
	
	public String getColumnName(int col){
		switch (col){
		case 0:
			return "Id";
		case 1:
			return "Firstname";
		case 2:
			return "Surname";
		default:
			return null;
		}
	}
	
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}

}
