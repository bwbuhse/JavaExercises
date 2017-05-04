package labs.sql;

public class Customer {
	private int customerID;
	private String lName;
	private String fName;
	private String address;
	private String phone;
	private String loginID;
	private String passwd;

	Customer(int customerID, String lName, String fName, String address, String phone, String loginID, String passwd) {
		this.customerID = customerID;
		this.lName = lName;
		this.fName = fName;
		this.address = address;
		this.phone = phone;
		this.loginID = loginID;
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerID=" + customerID +
				", lName='" + lName + '\'' +
				", fName='" + fName + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", loginID='" + loginID + '\'' +
				", passwd='" + passwd + '\'' +
				'}';
	}
}
