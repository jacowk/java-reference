package za.co.reference.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest{
	
	public static void main(String[] args){
		JDBCTest jdbcTest = new JDBCTest();
		jdbcTest.establishConnection();
		jdbcTest.selectStuff();
	}
	
	private void establishConnection(){
		try{
			Class.forName("com.mysql.jbdc.Driver");
			String url = "jdbc:mysql://localhost/test";
			connection = DriverManager.getConnection(url, "username", "password");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				connection.close();
			}
			catch (SQLException sqle){
				
			}
		}
	}
	
	private void selectStuff(){
		String selectQuery = "select id, name, surname from user where username = ? and password = ?;";
		try{
			PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = selectStatement.executeQuery();
			while (resultSet.next()){
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
			}
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}

	private Connection connection;
	
}
