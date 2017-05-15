package labs.sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

@SuppressWarnings("SqlResolve")
class LibraryForms {
	private Statement stmt;

	LibraryForms(Connection connection) {
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void inventory() {
		ResultSet rs;
		JTable table = null;
		try {
			rs = stmt.executeQuery("SELECT isbn, title, author, status FROM book ORDER BY status, isbn");
			table = new JTable(buildTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, new JScrollPane(table), "Inventory",
				JOptionPane.PLAIN_MESSAGE);
	}

	void customers() {
		String out = "";
		try {
			ResultSet rs = stmt.executeQuery("SELECT custid\n" +
					"FROM customer\n" +
					"ORDER BY lname");

			List<Integer> ids = new ArrayList<>();
			while (rs.next()) {
				ids.add(rs.getInt(1));
			}

			StringBuilder outBuilder = new StringBuilder();
			for (int i : ids) {
				rs = stmt.executeQuery("SELECT\n" +
						"  customer.custid,\n" +
						"  customer.fname,\n" +
						"  customer.lname,\n" +
						"  customer.address,\n" +
						"  customer.phone\n" +
						"FROM customer\n" +
						"WHERE custid = " + i);
				rs.next();
				outBuilder.append(String.format("%03d|%10s%15s|%25s%n", rs.getInt(1), rs.getString(2).trim(),
						rs.getString(3).trim(), rs.getString(4).trim()));
				rs = stmt.executeQuery("SELECT book.title\n" +
						"FROM transaction\n" +
						"  INNER JOIN book ON book.isbn = transaction.isbn\n" +
						"  INNER JOIN customer ON customer.custid = transaction.custid\n" +
						"WHERE\n" +
						"  customer.custid = " + i + " AND book.status = 1");
				Set<String> books = new TreeSet<>();
				while (rs.next()) {
					books.add("    -" + rs.getString(1) + "\n");
				}
				for (String s : books)
					outBuilder.append(s);
			}
			out = outBuilder.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JTextArea area = new JTextArea(out);
		area.setEditable(false);
		area.setFont(new Font("monospaced", Font.PLAIN, 12));
		JOptionPane.showMessageDialog(null, new JScrollPane(area), "Customers", JOptionPane.PLAIN_MESSAGE);
	}

	void transactions() {
		ResultSet rs;
		JTable table = null;
		try {
			rs = stmt.executeQuery("SELECT\n" +
					"  transaction.transdate,\n" +
					"  transaction.type,\n" +
					"  customer.custid,\n" +
					"  customer.lname,\n" +
					"  customer.fname,\n" +
					"  book.isbn,\n" +
					"  book.title\n" +
					"FROM transaction\n" +
					"  INNER JOIN book ON book.isbn = transaction.isbn\n" +
					"  INNER JOIN customer ON customer.custid = transaction.custid\n" +
					"ORDER BY\n" +
					"  transaction.transdate DESC;");
			table = new JTable(buildTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, new JScrollPane(table), "Transactions", JOptionPane.PLAIN_MESSAGE);
	}

	private static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}
