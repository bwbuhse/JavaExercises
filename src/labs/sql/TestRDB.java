package labs.sql;

import java.sql.Connection;
import java.sql.DriverManager;

@SuppressWarnings("SqlResolve")
public class TestRDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded the mysql driver");

			// Make connection with server !!!!!
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			// db is underneath "test" in phpMyAdmin
			System.out.println("Successful connection");

			System.out.println("Creating statement...");
			java.sql.Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM book";
			java.sql.ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name
				String isbn = rs.getString("isbn/");
				String title = rs.getString("title/");
				String author = rs.getString("author/");
				String publisher = rs.getString("publisher");
				System.out.println(isbn + " " + title + " " + author + " " + publisher);
			}
		} catch (Exception e) {
			System.err.println("Test RDB error: " + e);
		}
	}

}