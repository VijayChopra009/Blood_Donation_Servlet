<%@ page import="myconnection.MyConnection" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital Data</title>
    <style>
        body {
            font-family: 'Times New Roman', serif;
            margin: 0;
            padding: 0;
            background-color: #eaeaea;
            color: #333;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 20px;
        }
        .card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.8);
            margin: 15px;
            padding: 20px;
            width: 300px;
            text-align: center;
            border: 1px solid #ddd;
        }
        .card h2 {
            margin: 0 0 15px;
            font-size: 1.75em;
            color: #0056b3;
        }
        .card p {
            margin: 5px 0;
            font-size: 1.1em;
        }
        .card p strong {
            color: #333;
        }
        a {
            display: block;
            width: fit-content;
            margin: 20px auto;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #0056b3;
            border-radius: 5px;
            font-size: 1.2em;
        }
        a:hover {
            background-color: #003d7a;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = MyConnection.getConnection();
                ps = conn.prepareStatement("SELECT * FROM hospitallogin");
                rs = ps.executeQuery();
                while (rs.next()) {
        %>
            <div class="card">
                <h2><%= rs.getString("NAME") %></h2>
                <p><strong>A Positive:</strong> <%= rs.getString("A_POSITIVE") %></p>
                <p><strong>A Negative:</strong> <%= rs.getString("A_NEGATIVE") %></p>
                <p><strong>B Positive:</strong> <%= rs.getString("B_POSITIVE") %></p>
                <p><strong>B Negative:</strong> <%= rs.getString("B_NEGATIVE") %></p>
                <p><strong>AB Positive:</strong> <%= rs.getString("AB_POSITIVE") %></p>
                <p><strong>AB Negative:</strong> <%= rs.getString("AB_NEGATIVE") %></p>
                <p><strong>O Positive:</strong> <%= rs.getString("O_POSITIVE") %></p>
                <p><strong>O Negative:</strong> <%= rs.getString("O_NEGATIVE") %></p>
            </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </div>
   <a href='index.html'>Return Home</a>
</body>
</html>
