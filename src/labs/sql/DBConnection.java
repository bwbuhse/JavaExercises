package labs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection 
{
	Connection conn;
	Statement stmt;
	java.sql.ResultSet rs;
	
	public DBConnection() 
	{
		getConnection();
	}
	public void getConnection()
	{
		try 
		{
			Class.forName ("com.mysql.jdbc.Driver");  //load driver
			System.out.println("Loaded the mysql driver");
		
			// jdbc:mysql...  database URL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/highschool", "root", "root");
			System.out.println("Successful connection");
			
			stmt = conn.createStatement();     // creates statement to access table in db
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public void closeConnection()
	{   try {   conn.close();        }
		catch(SQLException e)    {   e.printStackTrace();    }
	}
	public Connection getPrivConn()  {  return conn; }
	public Statement getPrivStatement() { return stmt; }
}
