<%@page import="beans.HospitalDetailsBean"%>
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
    }
    .navbar h1 {
        margin: 0;
        display: inline-block;
        text-transform:capitalize;
    }
       .nav-right {
       float:right;
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
    .navbar .nav-right a:hover{
    text-decoration:underline;
    }
    
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: calc(100vh - 60px);
        padding: 20px;
    }
    .form-container {
            margin:30px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 80%;
        max-width: 800px;
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }
    h2 {
        color: #333;
        margin-bottom: 10px;
        text-align: center;
        width: 100%;
    }
    .form-group {
        margin-bottom: 15px;
        width: 100%;
    }
    .left, .right {
        flex: 1;
        min-width: 200px;
    }
    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }
    input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #5cb85c;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        display: block;
        margin: 0 auto;
    }
    input[type="submit"]:hover {
        background-color: #4cae4c;
    }
</style>
</head>
<body>

    <div class="navbar">
        <h1>Welcome : <%=(String) session.getAttribute("name") %></h1>
        <a class='nav-right' href="logout.jsp">Logout</a>
    </div>

    <div class="container">
        <form action="updatehospital" method='post'>
        <div class="form-container">
            <h2>Blood Units Inventory </h2>
            <input type="hidden" id="email" name="email" value="<%=session.getAttribute("email") %>">
            <input type="hidden" id="name" name="name" value="<%= session.getAttribute("name") %>">
            <div class="left">
                <div class="form-group">
                    <label for="aPositive">A_Positive Blood Units:</label>
                    <input type="number" id="aPositive" name="aPositive" value="<%=session.getAttribute("A") %>">
                </div>
                <div class="form-group">
                    <label for="aNegative">A_Negative Blood Units:</label>
                    <input type="number" id="aNegative" name="aNegative" value="<%=session.getAttribute("An") %>">
                </div>
                <div class="form-group">
                    <label for="bPositive">B_Positive Blood Units:</label>
                    <input type="number" id="bPositive" name="bPositive" value="<%=session.getAttribute("B") %>">
                </div>
                <div class="form-group">
                    <label for="bNegative">B_Negative Blood Units:</label>
                    <input type="number" id="bNegative" name="bNegative" value="<%=session.getAttribute("Bn") %>">
                </div>
            </div>
            <div class="right">
                <div class="form-group">
                    <label for="abPositive">AB_Positive Blood Units:</label>
                    <input type="number" id="abPositive" name="abPositive" value="<%=session.getAttribute("AB") %>">
                </div>
                <div class="form-group">
                    <label for="abNegative">AB_Negative Blood Units:</label>
                    <input type="number" id="abNegative" name="abNegative" value="<%=session.getAttribute("ABn") %>">
                </div>
                <div class="form-group">
                    <label for="oPositive">O_Positive Blood Units:</label>
                    <input type="number" id="oPositive" name="oPositive" value="<%=session.getAttribute("O") %>">
                </div>
                <div class="form-group">
                    <label for="oNegative">O_Negative Blood Units:</label>
                    <input type="number" id="oNegative" name="oNegative" value="<%=session.getAttribute("On") %>">
                </div>
            </div>
            <div class="form-group">
                <input type="submit" value="Update Units">
            </div>
        </div>
        </form>
    </div>
</body>
</html>
