package za.co.reference.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

public class SwingTest extends JFrame{
	
	public SwingTest(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		setTitle("Swing Test");
		setPreferredSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addTablePanel();
		pack();
		setLocationRelativeTo(null); //To centre the window
		setVisible(true);
	}
	
	private void addTablePanel(){
		JPanel tablePanel = new JPanel();
		JTable table = new JTable(new ItemTableModel(prepareTableData()));
		table.setDefaultRenderer(String.class, new ItemTableCellRenderer());
		tablePanel.add(table);
		getContentPane().add(tablePanel);
	}
	
	private ArrayList<TableData> prepareTableData(){
		ArrayList<TableData> tableData = new ArrayList<TableData>();
		tableData.add(new TableData(1, "John", "Doe"));
		tableData.add(new TableData(2, "Jim", "Dow"));
		tableData.add(new TableData(3, "Jill", "Dough"));
		tableData.add(new TableData(4, "Johnson", "Do"));
		return tableData;
	}

}
