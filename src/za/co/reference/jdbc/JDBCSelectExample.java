package za.co.reference.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelectExample{
	
	public static void main(String[] args){
		JDBCSelectExample jdbcSelectExample = new JDBCSelectExample();
		jdbcSelectExample.establishConnection();
		jdbcSelectExample.executeSelectQuery();
	}
	
	private void establishConnection(){
		try{
			//Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException sqle){
			sqle.printStackTrace();
		}
		try{
			//Get the database url
			String url = "jdbc:mysql://localhost/fridgeverify";
			//Establish the connection
			connection = DriverManager.getConnection(url,"username","password");
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	private void executeSelectQuery(){
		String query = "select fieldName from someTable where someField = ?";
		try{
			PreparedStatement selectStatement = connection.prepareStatement(query);
			selectStatement.setString(0, "Some value");
			ResultSet resultSet = selectStatement.executeQuery(); //Use this also for insert statements
			while (resultSet.next()){
				resultSet.getString("fieldName");
			}
			selectStatement.close();
			resultSet.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	private Connection connection;

}
