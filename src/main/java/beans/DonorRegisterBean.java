package beans;

import java.io.Serializable;

import dao.Dao;

public class DonorRegisterBean implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private long Mobno;
	private String gender;
	private int age;
	private String bloodg;
	private String state;
	private String city;
	private String address;
	private int pincode;
	private String location;
	
	public DonorRegisterBean() {
		
	}
	
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
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean registerverify() {
	return	new Dao().registerdonor(this);
	}
	

}
