package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.GetbyBean;
import beans.LoginBean;
import beans.RegisterBean;
import myconnection.MyConnection;

public class Dao {

	//login
	public boolean Logindonor(LoginBean lb) {
		boolean value=false;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from donor where email=? and password=?");
			ps.setString(1, lb.getEmail());
			ps.setString(2, lb.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				value=true;
				System.out.println("login verified  :  "+value);
				System.out.println("Email  "+rs.getString(1));
				System.out.println("password   "+rs.getString(2));
				return value;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	//Register Donor
	public boolean registerdonor(RegisterBean rb) {
		boolean value=false;
		int x=0,x1=0;
		try {
			Connection conn = MyConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into donorDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,rb.getFirstname());
			ps.setString(2,rb.getLastname());
			ps.setString(3,rb.getEmail());
			ps.setString(4,rb.getPassword());
			ps.setLong(5,rb.getMobno());
			ps.setString(6,rb.getGender());
			ps.setInt(7,rb.getAge());
			ps.setString(8,rb.getBloodg());
			ps.setString(9,rb.getCity());
			ps.setString(10,rb.getAddress());
			ps.setString(11,rb.getState());
			ps.setInt(12,rb.getPincode());
			ps.setString(13,rb.getLocation());
			x=ps.executeUpdate();
			System.out.println("Successfully inserted into donorDetails table  "+x);
			if(x !=0) {
                PreparedStatement ps1=conn.prepareStatement("insert into donor values(?,?)");
                ps1.setString(1,rb.getEmail());
                ps1.setString(2,rb.getPassword());
                x1=ps1.executeUpdate();
                System.out.println("successfully inserted into donor table  "+x1);
                if(x1 !=0) {
                	value=true;
                	return value;
                }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public List<GetbyBean> getbypincode(GetbyBean gb){
		List<GetbyBean> al = new ArrayList<GetbyBean>();
		try {
			Connection conn=MyConnection.getConnection();
//			PreparedStatement ps=conn.prepareStatement("select * from donorDetails where PINCODE=?");
			PreparedStatement ps=conn.prepareStatement("select * from donorDetails where PINCODE=? and bloodgroup=?");
			ps.setInt(1,gb.getPincode());
			ps.setString(2,gb.getBloodg());
     		System.out.println(gb.getPincode());
     		System.out.println(gb.getBloodg());
			ResultSet rs=ps.executeQuery();
			System.out.println("getting by pincode.......");
			while(rs.next()) {
				gb=new GetbyBean();
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
				System.out.println(gb.getFirstname());
				System.out.println(gb.getLastname());
			}
			System.out.println("added to list successfullys");
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
