package misc;

import java.sql.*;

public class SQLTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  //load driver
		System.out.println("Loaded the mysql driver");

		// INSERT PASSWORD AND REMOVE BEFORE PUSHING
		Connection connection = DriverManager.getConnection("jdbc:mysql://tutorial.cudmsvk8sdie.us-east-1.rds.amazonaws.com:3306/TestDB", "bwbuhse", "scms15Oilers");
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM Customers";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			System.out.printf("%-3d|%-20s|%-20s|%-3d%n"
					, resultSet.getInt("ID")
					, resultSet.getString("FirstName")
					, resultSet.getString("LastName")
					, resultSet.getInt("Age")
			);
		}
	}
}
