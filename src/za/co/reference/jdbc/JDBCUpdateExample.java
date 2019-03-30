package za.co.reference.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUpdateExample{
	
	public static void main(String[] args){
		JDBCUpdateExample jdbcUpdateExample = new JDBCUpdateExample();
		jdbcUpdateExample.establishConnection();
		jdbcUpdateExample.executeSelectQuery();
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
		String query = "update someTable set fieldName = ? where someField = ?";
		try{
			PreparedStatement selectStatement = connection.prepareStatement(query);
			selectStatement.setString(0, "Some value");
			selectStatement.setString(1, "Some value");
			int update = selectStatement.executeUpdate();
			selectStatement.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	private Connection connection;

}
