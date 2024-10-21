package myconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private static Connection conn=null;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Vijay@123");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String...s) {
		System.out.println("connection    "+MyConnection.getConnection());
	}
	
}
