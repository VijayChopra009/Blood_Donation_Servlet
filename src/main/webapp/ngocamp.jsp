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
            margin: 20px 0;
        }
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            border-radius:20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        .camp-wrapper {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .camp {
            background-color: #fff;
            
            border: 1px solid #ddd;
            border-radius:20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            flex: 1 1 calc(50% - 20px);
            box-sizing: border-box;
        }
        .camp h3 {
            margin: 0;
            font-size: 18px;
            color: #333;
        }
        .camp p {
            margin: 10px 0 5px;
            color: #666;
        }
        @media (max-width: 768px) {
            .camp {
                flex: 1 1 100%;
            }
        }
    </style>
</head>
<body>
    <h2>NGO Camp Details</h2>
    <div class="container">
        <div class="camp-wrapper">
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
    </div>
</body>
</html>
