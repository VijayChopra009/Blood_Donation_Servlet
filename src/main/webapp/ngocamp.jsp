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
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .camp {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .camp:last-child {
            border-bottom: none;
        }
        .camp h3 {
            margin: 0;
            font-size: 18px;
            color: #333;
        }
        .camp p {
            margin: 5px 0;
            color: #666;
        }
    </style>;
</head>
<body>
    <h2>NGO Camp Details</h2>
    <div class="container">
    <%
    try {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ngocamp");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            out.println("<div class='camp'>");
            out.println("<h3>Camp Date: " + rs.getString("CAMP_DATE") + "</h3>");
            out.println("<p><strong>Address:</strong> " + rs.getString("ADDRESS") + "</p>");
            out.println("<p><strong>City:</strong> " + rs.getString("CITY") + "</p>");
            out.println("<p><strong>Pincode:</strong> " + rs.getString("PINCODE") + "</p>");
            out.println("<p><strong>State:</strong> " + rs.getString("STATE") + "</p>");
            out.println("<p><strong>Contact:</strong> " + rs.getString("CONTACT") + "</p>");
            out.println("<p><strong>Details:</strong> " + rs.getString("DETAILS") + "</p>");
            out.println("</div>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error: " + e.getMessage());
    } %>
    </div>
</body>
</html>
