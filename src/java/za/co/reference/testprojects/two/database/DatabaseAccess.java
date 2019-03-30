package za.co.reference.testprojects.two.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import za.co.reference.jdbc.ConnectionProperty;
import za.co.reference.testprojects.two.artists.Artist;

public class DatabaseAccess{
	
	public DatabaseAccess(){
		getConnection();
	}
	
	public void getConnection(){
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("connectionURL", "jdbc:mysql://localhost/test");
		connectionProperties.setProperty("driverClass", "com.mysql.jdbc.Driver");
		connectionProperties.setProperty("user", "appserv");
		connectionProperties.setProperty("password", "password");
		try{
			Class.forName(connectionProperties.getProperty(ConnectionProperty.DRIVER_CLASS.getName()));
		}
		catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		try{
			dbConnection = DriverManager.getConnection(connectionProperties.getProperty(ConnectionProperty
				.CONNECTION_URL.getName()), connectionProperties);
			dbConnection.setAutoCommit(false);
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public List<Artist> retrieveAllArtists(){
		List<Artist> artistList = new ArrayList<Artist>();
		String query = "select id, name from artist;";
		try{
			PreparedStatement selectStatement = dbConnection.prepareStatement(query);
			ResultSet resultSet = selectStatement.executeQuery();
			while (resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				artistList.add(new Artist(id, name));
			}
			selectStatement.close();
			resultSet.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return artistList;
	}
	
	public List<Artist> searchArtist(String searchString){
		List<Artist> artistList = new ArrayList<Artist>();
		String query = "select id, name from artist where name like ?;";
		try{
			PreparedStatement searchStatement = dbConnection.prepareStatement(query);
			searchStatement.setString(1, "%" + searchString + "%");
			ResultSet resultSet = searchStatement.executeQuery();
			while (resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				artistList.add(new Artist(id, name));
			}
			searchStatement.close();
			resultSet.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return artistList;
	}
	
	public void addArtist(Artist artist){
		String query = "insert into artist(name, active, deleted, createdate) values (?, true, false, now());";
		try{
			PreparedStatement insertStatement = dbConnection.prepareStatement(query);
			insertStatement.setString(1, artist.getName());
			insertStatement.executeUpdate();
			dbConnection.commit();
			insertStatement.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public void updateArtist(Artist artist){
		String query = "update artist set name = ?, lastmodifieddate = now() where id = ?;";
		try{
			PreparedStatement insertStatement = dbConnection.prepareStatement(query);
			insertStatement.setString(1, artist.getName());
			insertStatement.setInt(2, artist.getId());
			insertStatement.executeUpdate();
			dbConnection.commit();
			insertStatement.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public Artist getArtistByName(Artist artist){
		String query = "select id, name from artist where name like ? limit 1;";
		try{
			PreparedStatement selectStatement = dbConnection.prepareStatement(query);
			selectStatement.setString(1, artist.getName());
			ResultSet resultSet = selectStatement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			artist.setId(id);
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return artist;
	}
	
	public Artist getArtistById(Artist artist){
		String query = "select id, name from artist where id =  ?;";
		try{
			PreparedStatement selectStatement = dbConnection.prepareStatement(query);
			selectStatement.setInt(1, artist.getId());
			ResultSet resultSet = selectStatement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			artist.setName(name);
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return artist;
	}
	
	public void deleteArtist(Artist artist){
		String query = "delete from artist where id = ?";
		try{
			PreparedStatement insertStatement = dbConnection.prepareStatement(query);
			insertStatement.setInt(1, artist.getId());
			insertStatement.executeUpdate();
			dbConnection.commit();
			insertStatement.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	Connection dbConnection = null;

}
