package labs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainRunner {

	private MainRunner() throws SQLException {
		// Make connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
		// Login
		try {
			new LoginProcess(myConn.createStatement());
		} catch (Exception e) {
			System.err.println("Login error:" + e);
		}

	}

	public static void main(String[] args) throws SQLException {
		new MainRunner();
	}

}
