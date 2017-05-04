package labs.sql;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

@SuppressWarnings("SqlResolve")
class LoginProcess {

	private ResultSet rs;
	private String loginName;

	private JFrame f = new JFrame("User Login");

	private JTextField t = new JTextField(10);
	private JTextField t1 = new JTextField(10);

	LoginProcess(Statement stmt) {
		loginName = null;

		f.setSize(600, 300);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		JLabel ln = new JLabel("User Name:");
		p.add(ln);
		p.add(t);
		JLabel lp = new JLabel("Password:");
		p.add(lp);
		p.add(t1);
		JButton b = new JButton("Login");
		p.add(b);

		f.add(p);
		b.addActionListener(e -> {
			try {
				String user = t.getText().trim();
				String pass = t1.getText().trim();

				String sql = "select * from customer where loginid='" + user + "'and passwd='" +
						pass + "'";
				rs = stmt.executeQuery(sql);

				          // if no rows exist then no user exists

				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Login Successful.");
					loginName = user;
					System.out.println(new Customer(rs.getInt("custid"), rs.getString("lname")
							, rs.getString("fname"), rs.getString("address")
							, rs.getString("phone"), rs.getString("loginid")
							, rs.getString("passwd")));
				} else
					JOptionPane.showMessageDialog(null, "No user account found", "Login Error",
							JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (loginName != null)
					f.dispose();
				else {
					t.setText("");
					t1.setText("");
				}
			}
		});
		f.setVisible(true);

	}
}
