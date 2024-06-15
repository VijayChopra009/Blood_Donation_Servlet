package beans;



import dao.Dao;

public class NgoDetailBean {
    private String Date;
    private String address;
    private String city;
    private int pincode;
    private String state;
    private String details;
    private Long contact;

    
    public NgoDetailBean() { }

	public String getDate() {
		return Date;
	}

	
	public void setDate(String date) {
		this.Date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}
    
	public boolean ngoverify() {
		return new Dao().camps(this);
	}
    
}
