package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.GetbyBean;
import beans.HospitalDetailsBean;
import beans.HospitalUpdateBean;
import beans.NgoDetailBean;
import beans.HospitalRegisterBean;
import myServlets.hospitalRegisterServlet;
import beans.DonorLoginBean;
import beans.DonorRegisterBean;
import myconnection.MyConnection;

public class Dao {

	/////////////////// Donor login /////////////////////////
	public boolean Logindonor(DonorLoginBean lb) {
		boolean value = false;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from donor where email=? and password=?");
			ps.setString(1, lb.getEmail());
			ps.setString(2, lb.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				value = true;
				System.out.println("login verified  :  " + value);
				System.out.println("Email  " + rs.getString(1));
				System.out.println("password   " + rs.getString(2));
				return value;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	////////////////////////// Register Donor//////////////////////////
	public boolean registerdonor(DonorRegisterBean rb) {
		boolean value = false;
		int x = 0, x1 = 0;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into donorDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, rb.getFirstname());
			ps.setString(2, rb.getLastname());
			ps.setString(3, rb.getEmail());
			ps.setString(4, rb.getPassword());
			ps.setLong(5, rb.getMobno());
			ps.setString(6, rb.getGender());
			ps.setInt(7, rb.getAge());
			ps.setString(8, rb.getBloodg());
			ps.setString(9, rb.getCity());
			ps.setString(10, rb.getAddress());
			ps.setString(11, rb.getState());
			ps.setInt(12, rb.getPincode());
			ps.setString(13, rb.getLocation());
			x = ps.executeUpdate();
			System.out.println("Successfully inserted into donorDetails table  " + x);
			if (x != 0) {
				PreparedStatement ps1 = conn.prepareStatement("insert into donor values(?,?)");
				ps1.setString(1, rb.getEmail());
				ps1.setString(2, rb.getPassword());
				x1 = ps1.executeUpdate();
				System.out.println("successfully inserted into donor table  " + x1);
				if (x1 != 0) {
					value = true;
				
					return value;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	//////////////////////////////// get the details of donors/////////////////
	public List<GetbyBean> getbypincode(GetbyBean gb) {
		List<GetbyBean> al = new ArrayList<GetbyBean>();
		try {
			Connection conn = MyConnection.getConnection();
//			PreparedStatement ps=conn.prepareStatement("select * from donorDetails where PINCODE=?");
			PreparedStatement ps = conn.prepareStatement("select * from donorDetails where PINCODE=? and bloodgroup=?");
			ps.setInt(1, gb.getPincode());
			ps.setString(2, gb.getBloodg());
			ResultSet rs = ps.executeQuery();
			System.out.println("getting by pincode.......");
			while (rs.next()) {
				gb = new GetbyBean();
				gb.setFirstname(rs.getString(1));
				gb.setLastname(rs.getString(2));
				gb.setEmail(rs.getString(3));
				gb.setMobno(rs.getLong(5));
				gb.setGender(rs.getString(6));
				gb.setAge(rs.getInt(7));
				gb.setBloodg(rs.getString(8));
				gb.setCity(rs.getString(9));
				gb.setAddress(rs.getString(10));
				gb.setState(rs.getString(11));
				gb.setPincode(rs.getInt(12));
				al.add(gb);
			}
			System.out.println("added to list successfullys");
	
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	////////////////////// hospitalregistration ////////////////////
	public boolean registerhospital(HospitalRegisterBean rb) {
		boolean value = false;
		int x = 0, x1 = 0;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into hospitalregister values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, rb.getId());
			ps.setString(2, rb.getName());
			ps.setString(3, rb.getEmail());
			ps.setString(4, rb.getPassword());
			ps.setLong(5, rb.getMobno());
			ps.setString(6, rb.getState());
			ps.setString(7, rb.getCity());
			ps.setInt(8, rb.getPincode());
			ps.setString(9, rb.getAddress());
			x = ps.executeUpdate();
			System.out.println("Successfully inserted into hospitalregister table  " + x);
			if (x != 0) {
				PreparedStatement ps1 = conn.prepareStatement("insert into hospitallogin values(?,?,?,0,0,0,0,0,0,0,0,?)");
				ps1.setInt(1, rb.getId());
				ps1.setString(2, rb.getEmail());
				ps1.setString(3, rb.getPassword());
				ps1.setString(12, rb.getName());
				x1 = ps1.executeUpdate();
				System.out.println("successfully inserted into hospitallogin  " + x1);
				if (x1 != 0) {
					value = true;
					return value;
				}else {
					conn.rollback();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	////////////////  get the details of hospital and Login hospital   //////////
	public boolean gethospitaldetails(HospitalDetailsBean gb) {
		boolean value = false;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from hospitallogin where EMAIL=? and password=?");
			ps.setString(1, gb.getEmail());
			ps.setString(2, gb.getPassword());
			System.out.println("login email = " + gb.getEmail());
			System.out.println("login password = " + gb.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				gb.setId(rs.getInt(1));
				gb.setEmail(rs.getString(2));
				gb.setA_positive(rs.getInt(4));
				gb.setA_negative(rs.getInt(5));
				gb.setB_positive(rs.getInt(6));
				gb.setB_negative(rs.getInt(7));
				gb.setAB_positive(rs.getInt(8));
				gb.setAB_negative(rs.getInt(9));
				gb.setO_positive(rs.getInt(10));
				gb.setO_negative(rs.getInt(11));
				gb.setName(rs.getString(12));
				value = true;
			}
			
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public boolean updateHospitalDetails(HospitalUpdateBean uh) {
	    boolean value = false;
	    try {
	        Connection conn = MyConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(
	                "UPDATE hospitallogin SET A_POSITIVE = ?, A_NEGATIVE = ?, B_POSITIVE = ?, B_NEGATIVE = ?, AB_POSITIVE = ?, AB_NEGATIVE = ?, O_POSITIVE = ?, O_NEGATIVE = ?,NAME=? WHERE EMAIL = ?");
	        ps.setInt(1, uh.getA_positive());
	        ps.setInt(2, uh.getA_negative());
	        ps.setInt(3, uh.getB_positive());
	        ps.setInt(4, uh.getB_negative());
	        ps.setInt(5, uh.getAB_positive());
	        ps.setInt(6, uh.getAB_negative());
	        ps.setInt(7, uh.getO_positive());
	        ps.setInt(8, uh.getO_negative());
	        ps.setString(9, uh.getName());
	        ps.setString(10, uh.getEmail()); 
	        int x = ps.executeUpdate();
	        System.out.println("Updated hospital details successfully into db " + x);
	        if (x != 0) {
	        	 System.out.println("a+ = " +uh.getA_positive());
	 	        System.out.println("a- = " +uh.getA_positive());
	 	      
	            value = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return value;
	}

	////////////////////////// ngo camp//////////////////////////
	public boolean  camps(NgoDetailBean nb) {
		boolean value = false;
		int x = 0;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into ngocamp values(?,?,?,?,?,?,?)");
			ps.setString(1,nb.getDate());
			ps.setString(2,nb.getAddress());
			ps.setString(3,nb.getCity());
			ps.setInt(4,nb.getPincode() );
			ps.setString(5,nb.getState());
			ps.setLong(6,nb.getContact());
			ps.setString(7,nb.getDetails());
			x = ps.executeUpdate();
			System.out.println("Successfully inserted into ngo camp table  " + x);
			if (x != 0) {
					value = true;
					return value;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
