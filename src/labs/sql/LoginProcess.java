package labs.sql;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginProcess {
	
	ResultSet rs;
	String loginName;
	String loginPwd;
	
	JFrame f = new JFrame("User Login");
	JLabel ln = new JLabel("User Name:");
	JLabel lp = new JLabel("Password:");
		
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JButton b = new JButton("Login");
	
	public LoginProcess(Connection conn, Statement stmt)
	{
		loginName = loginPwd = null;
		
		f.setSize(600, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.add(ln);
		p.add(t);
		p.add(lp);
		p.add(t1);
		p.add(b);
		
		f.add(p);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
				String user = t.getText().trim();
				String pass = t1.getText().trim();
				
				String sql = "select login_id, password from student where login_id='"+user+"'and password='"+
				              pass+"'";
				rs = stmt.executeQuery(sql);
				
				int cnt = 0;
				while (rs.next())	// if count >1 do not let them log in
					cnt++;			// if no rows exist then no user exists
					
				if (cnt==1) 
				{
					JOptionPane.showMessageDialog(null,  "Login Successful.");
					loginName = user;
					loginPwd = pass;
				}
				else 
					JOptionPane.showMessageDialog(null,  "No user account found","Login Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				finally {
					if (loginName != null)
						f.dispose();
					else
					{
						t.setText("");
						t1.setText("");
					}
				}
			}
		});
		f.setVisible(true);
		
		
	}
}
