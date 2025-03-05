<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj == null || sessionObj.getAttribute("username") == null) {
        response.sendRedirect("index1.jsp?msg=please_login");
        return;
    }
    String username = (String) sessionObj.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: white;
        }
        .container {
            background: rgba(255, 255, 255, 0.2);
            padding: 20px;
            border-radius: 15px;
            display: inline-block;
            box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.2);
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: white;
            background-color: red;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
        }
        .btn:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Welcome, <%= username %> 🎉</h2>
        <p>You are successfully logged in.</p>
        <a class="btn" href="LogoutServlet">Logout</a>
    </div>

</body>
</html>
