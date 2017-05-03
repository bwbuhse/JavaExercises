package labs.sql;

public class MainRunner
{
	DBConnection myConn;
	
	public MainRunner()
	{
		// Start-up jFrame and main/home panel
		
		// Make connection to database
		myConn = new DBConnection();
		// Login
		try {
			new LoginProcess(myConn.getPrivConn(), myConn.getPrivStatement());
		}
		catch(Exception e)
		{
			System.err.println(e);
			System.exit(0);
		}
		// Run programs
		//new RunProgram();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainRunner();
	}

}
