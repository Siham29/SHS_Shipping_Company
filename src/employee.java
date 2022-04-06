
public class employee {
	private int eID ;
	private String phone_num ;
	private String address_name;	
	private String EmployeeType ;

	public employee(int EID ,String Phone_num, String Address_name, String employeeType ) {
		super();
		eID = EID;
		phone_num = Phone_num;
		address_name = Address_name;
		 EmployeeType =employeeType;	
}

	public employee (int EID) {
		super();
	    eID = EID;
	}
	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getEmployeeType() {
		return EmployeeType;
	}

	public void setEmployeeType(String employeeType) {
		EmployeeType = employeeType;
	}
	
}