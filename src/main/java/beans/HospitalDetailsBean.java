package beans;

import dao.Dao;

public class HospitalDetailsBean {
	private int id;
	private String email;
	private String name;
	private String password;
	private int A_positive;
	private int B_positive;
	private int AB_positive;
	private int O_positive;
	private int A_negative;
	private int B_negative;
	private int AB_negative;
	private int O_negative;

	public HospitalDetailsBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getA_positive() {
		return A_positive;
	}

	public void setA_positive(int a_positive) {
		A_positive = a_positive;
	}

	public int getB_positive() {
		return B_positive;
	}

	public void setB_positive(int b_positive) {
		B_positive = b_positive;
	}

	public int getAB_positive() {
		return AB_positive;
	}

	public void setAB_positive(int aB_positive) {
		AB_positive = aB_positive;
	}

	public int getO_positive() {
		return O_positive;
	}

	public void setO_positive(int o_positive) {
		O_positive = o_positive;
	}

	public int getA_negative() {
		return A_negative;
	}

	public void setA_negative(int a_negative) {
		A_negative = a_negative;
	}

	public int getB_negative() {
		return B_negative;
	}

	public void setB_negative(int b_negative) {
		B_negative = b_negative;
	}

	public int getAB_negative() {
		return AB_negative;
	}

	public void setAB_negative(int aB_negative) {
		AB_negative = aB_negative;
	}

	public int getO_negative() {
		return O_negative;
	}

	public void setO_negative(int o_negative) {
		O_negative = o_negative;
	}

	public boolean hospitaldetail() {
		return new Dao().gethospitaldetails(this);
	}

}
