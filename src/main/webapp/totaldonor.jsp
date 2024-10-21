<%@page import="myconnection.MyConnection"%>
<%@ page import="java.sql.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>NGO Camp Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	margin: 0;
	padding: 0;
}

.container {
	width: 500px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.7);
	border-radius: 8px;
	margin-top: 50px;
}

h2 {
	margin-top: 30px;
	text-align: center;
	color: #007BFF;
}

.camp-wrapper {
	margin: 20px 0;
}

.camp-wrapper h3 {
	margin: 10px 0;
	color: #0056b3;
}

a {
	display: inline-block;
	margin-top: 20px;
	text-decoration: none;
	color: #fff;
	background-color: #007BFF;
	padding: 10px 20px;
	border-radius: 4px
}
</style>
</head>
<body>
	<h2>TOTAL DONORS</h2>
	<div class="container">
		<div class="camp-wrapper">
			<%
            try {
                Connection conn = MyConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT count(*) as total_donors FROM donorDetails");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                	int totaldonor= rs.getInt("total_donors");
                    out.println("<h3>Total donor register: " + totaldonor + "</h3>");   
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Error: " + e.getMessage());
            } %>
		</div>
		<a href='index.html'>Return Home</a>
	</div>
</body>
</html>
