<%@page import="beans.HospitalUpdateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Blood Units Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .navbar {
        background-color: #333;
        overflow: hidden;
        color: white;
        padding: 15px;
        text-align: center;
        margin-bottom: 20px;
    }
    .navbar h1 {
        margin: 0;
        display: inline-block;
        text-transform: capitalize;
    }
    .nav-right {
        float: right;
        text-decoration: none;
        color: #000;
        background-color: #ff6666;
        padding: 10px 15px;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    .nav-right:hover {
        background-color: #ff3333;
    }
    .navbar .nav-right a:hover {
        text-decoration: underline;
    }
p{
font-size:20px;
text-align:center;
font-weight:bold;}
    
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px 0;
    }
    .form-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 80%;
        max-width: 500px;
        display: flex;
        flex-wrap: wrap;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); 
    }
    .left,
    .right {
        flex: 1;
    }
    .form-group {
        margin-bottom: 15px;
    }
    h3 {
        font-weight: bold;
        margin-bottom: 5px;
    }
    span {
        width: 100%;
        padding: 10px;
        border-radius: 4px;
        display: block;
        font-size:18px;
        font-weight:bold;
        color:red;
    }
</style>
</head>
<body>

<div class="navbar">
    <h1>Welcome : <%=(String) session.getAttribute("name") %></h1>
    <a class='nav-right' href="index.html">Home</a>
</div>

<p >Blood Units Inventory</p>

<div class="container">
    <div class="form-container">
        
        <div class="left">
            <div class="form-group">
                <h3>A_Positive Blood Units:</h3>
                <span><%=session.getAttribute("A") %></span>
            </div>
            <div class="form-group">
                <h3>A_Negative Blood Units:</h3>
                <span><%=session.getAttribute("An") %></span>
            </div>
            <div class="form-group">
                <h3>AB_Positive Blood Units:</h3>
                <span><%=session.getAttribute("AB") %></span>
            </div>
            <div class="form-group">
                <h3>AB_Negative Blood Units:</h3>
                <span><%=session.getAttribute("ABn") %></span>
            </div>
        </div>
        
        <div class="right">
            <div class="form-group">
                <h3>B_Positive Blood Units:</h3>
                <span><%=session.getAttribute("B") %></span>
            </div>
            <div class="form-group">
                <h3>B_Negative Blood Units:</h3>
                <span><%=session.getAttribute("Bn") %></span>
            </div>
            <div class="form-group">
                <h3>O_Positive Blood Units:</h3>
                <span><%=session.getAttribute("O") %></span>
            </div>
            <div class="form-group">
                <h3>O_Negative Blood Units:</h3>
                <span><%=session.getAttribute("On") %></span>
            </div>
        </div>
        
    </div>
</div>

</body>
</html>
