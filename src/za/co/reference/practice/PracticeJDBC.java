package za.co.reference.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PracticeJDBC{
	
	public static void main(String[] args){
		PracticeJDBC jdbcPractice = new PracticeJDBC();
		try{
			jdbcPractice.establishConnection();
			jdbcPractice.performSelect();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				jdbcPractice.connection.close();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
	private void establishConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/testdb";
		connection = DriverManager.getConnection(url, "username", "password");
	}
	
	private void performSelect() throws Exception{
		String query = "select firstname, surname from user where username like '?' and password like '?';";
		PreparedStatement selectStatement = connection.prepareStatement(query);
		selectStatement.setString(1, "username");
		selectStatement.setString(2, "password");
		ResultSet selectResultSet = selectStatement.executeQuery();
		while (selectResultSet.next()){
			selectResultSet.getString("firstname");
			selectResultSet.getString("surname");
		}
	}
	
	private Connection connection;
	
}
