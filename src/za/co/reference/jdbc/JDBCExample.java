package za.co.reference.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class JDBCExample{
	
	public void getSimpleConnection(){
		try
	    {
	      // Step 1: Load the JDBC driver. 
	      Class.forName("com.imaginary.sql.msql.MsqlDriver"); 
	      // Step 2: Establish the connection to the database. 
	      String url = "jdbc:msql://www.myserver.com:1114/contact_mgr"; 
	      Connection conn = DriverManager.getConnection(url,"user1","password");  
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! "); 
	      System.err.println(e.getMessage()); 
	    }
	}
	
	public void preparedStatementSimpleUpdateExample(Connection conn)
	throws SQLException
	{
	  String query = "INSERT INTO Users ("
	    + " user_id,"
	    + " username,"
	    + " firstname,"
	    + " lastname,"
	    + " companyname,"
	    + " email_addr,"
	    + " want_privacy ) VALUES ("
	    + "null, ?, ?, ?, ?, ?, ?)";

	  try {
	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    st.setString(1, "wer");
	    st.setString(2, "wer");
	    st.setString(3, "wer");
	    st.setString(4, "wer");
	    st.setString(5, "wer");
	    st.setString(6, "wer");

	    // execute the preparedstatement insert
	    st.executeUpdate();
	    st.close();
	  } 
	  catch (SQLException se)
	  {
	    // log exception
	    throw se;
	  }
	}
	
	private List preparedStatementSimpleSelectExample (Connection conn, String searchCriteria)
	throws SQLException{
	  List blogs = new LinkedList();
	  String query = "SELECT id, text FROM blogs WHERE UPPER(text) LIKE ?";
	  try{
	    // going to do a search using "upper"
	    searchCriteria = searchCriteria.toUpperCase();

	    // create the preparedstatement and add the criteria
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, "%" + searchCriteria + "%");

	    // process the results
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()){
	      rs.getInt("id");
	      rs.getString("text");
	    }
	    rs.close();
	    ps.close();
	  }
	  catch (SQLException se)
	  {
	    // log exception;
	    throw se;
	  }
	  return blogs;
	}  


	
	public void getConnectionWithProperties(){
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("connectionURL", "jdbc:mysql://localhost/fridgeverify");
		connectionProperties.setProperty("driverClass", "com.mysql.jdbc.Driver");
		connectionProperties.setProperty("user", "username");
		connectionProperties.setProperty("password", "password");
		try{
			Class.forName(connectionProperties.getProperty(ConnectionProperty.DRIVER_CLASS.getName()));
		}
		catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		try{
			fridgeConnection = DriverManager.getConnection(connectionProperties.getProperty(ConnectionProperty
				.CONNECTION_URL.getName()), connectionProperties);
			fridgeConnection.setAutoCommit(false);
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	private void loadConnectivitOrganisationalUnits() throws Exception{
		PreparedStatement organisationalUnitList = getOrganisationalUnitListStatement();
		getOrganisationalUnitListStatement.setString(1, "Some value");
		ResultSet organisationalUnitResultSet = getQueryResultSet(organisationalUnitList);
		organisationalUnitResultSet.first();
		organisationalUnitResultSet.beforeFirst();
		while (organisationalUnitResultSet.next()){
			Long organisationalunitoid = organisationalUnitResultSet.getLong("oid");
			String organisationalunitcode = organisationalUnitResultSet.getString("code");
			String organisationalunitname = organisationalUnitResultSet.getString("name");
		}
	}
	
	public PreparedStatement getOrganisationalUnitListStatement() throws Exception{
		if (getOrganisationalUnitListStatement == null){
			getOrganisationalUnitListStatement = fridgeConnection.prepareStatement(
				"select oid, code, name from organisationalunit where name like ?;");
		}
		return getOrganisationalUnitListStatement;
	}
	
	public ResultSet getQueryResultSet(PreparedStatement preparedStatement){
		try{
			return preparedStatement.executeQuery();
		}
		catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Could not get a a resultset for query. - " + preparedStatement.toString());
		}
	}
	
	public static void main(String[] args){
		JDBCExample jdbcExample = new JDBCExample();
		jdbcExample.getConnectionWithProperties();
		try{
			jdbcExample.loadConnectivitOrganisationalUnits();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Connection fridgeConnection;
	private PreparedStatement getOrganisationalUnitListStatement;

}
