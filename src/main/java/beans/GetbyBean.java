package beans;

import java.util.List;

import dao.Dao;

public class GetbyBean {
	private int pincode;
	private String firstname;
	private String lastname;
	private String email;
	private long Mobno;
	private String gender;
	private int age;
	private String bloodg;
	private String state;
	private String city;
	private String address;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobno() {
		return Mobno;
	}

	public void setMobno(long mobno) {
		Mobno = mobno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodg() {
		return bloodg;
	}

	public void setBloodg(String bloodg) {
		this.bloodg = bloodg;
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

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getPincode() {
		return pincode;
	}
	
	public List<GetbyBean> getallrecord() {
	 return new Dao().getbypincode(this);
	}
}
