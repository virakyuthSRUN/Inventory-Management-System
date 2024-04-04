//MODEL CLASS
//GETTER SETTER

import java.io.Serializable;

public class StudentModel implements Serializable {
	private int stid;
	private String Stname;
	private double stpoints;
		
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getStname() {
		return Stname;
	}
	public void setStname(String stname) {
		Stname = stname;
	}
	
	public double getStpoints() {
		return stpoints;
	}
	public void setStpoints(double stpoints) {
		this.stpoints = stpoints;
	}
}
