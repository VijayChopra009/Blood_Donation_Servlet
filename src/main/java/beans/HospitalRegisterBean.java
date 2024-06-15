package beans;

import dao.Dao;

public class HospitalRegisterBean {
	private int id;
	private String name;
	private String email;
	private String password;
	private long Mobno;
	private String state;
	private String city;
	private String address;
	private int pincode;
	
	public HospitalRegisterBean() {
		
	}
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobno() {
		return Mobno;
	}

	public void setMobno(long mobno) {
		Mobno = mobno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public boolean hospitalregisterverify() {
		return	new Dao().registerhospital(this);
		}
	
}
