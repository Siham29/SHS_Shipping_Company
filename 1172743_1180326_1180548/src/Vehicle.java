
public class Vehicle {
	
	private int Vehicle_num;
	private int Emp_id;
	private String vtype;
	
 
	
	public Vehicle (int Emp_id,int vnum, String vtype) {
		super();
		Vehicle_num = vnum ; 
		this.vtype = vtype;
		this.Emp_id = Emp_id;
		
	}



	public int getVehicle_num() {
		return Vehicle_num; 
		
		
	}



	public void setVehicle_num(int vehicle_num) {
		Vehicle_num = vehicle_num;
	}



	public int getEmp_id() {
		return Emp_id;
	}



	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}



	public String getVtype() {
		return vtype;
	}



	public void setEmp_type(String Vtype) {
		vtype = Vtype;
	}
	

}
