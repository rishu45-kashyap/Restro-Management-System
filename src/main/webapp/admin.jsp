<%
String check = (String) session.getAttribute("adminlogin");
if (check == null) {
    response.sendRedirect("adminlogin.jsp");
    return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

    <style>
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            display: flex;
            background: #ecf0f1;
        }
        /* Sidebar with gradient and shadow */
        .sidebar {
            width: 250px;
            background: linear-gradient(135deg, #2c3e50, #1a252f);
            color: white;
            height: 100vh;
            padding-top: 20px;
            position: fixed;
            box-shadow: 4px 0 15px rgba(0, 0, 0, 0.3);
        }
        /* Sidebar Links */
        .sidebar a {
            display: flex;
            align-items: center;
            padding: 15px;
            color: white;
            text-decoration: none;
            transition: 0.3s ease-in-out;
            font-size: 16px;
            border-left: 3px solid transparent;
            position: relative;
        }
        .sidebar a i {
            width: 25px;
            text-align: center;
            margin-right: 10px;
            transition: 0.3s ease-in-out;
        }
        /* Neon Light Effect on Hover */
        .sidebar a:hover {
            background: rgba(255, 255, 255, 0.1);
            padding-left: 25px;
            border-left: 3px solid #1abc9c;
            box-shadow: 0 0 10px #1abc9c;
        }
        .sidebar a:hover i {
            color: #1abc9c;
            text-shadow: 0 0 10px #1abc9c, 0 0 20px #1abc9c;
        }
        /* Content */
        .content {
            margin-left: 250px;
            padding: 20px;
            width: 100%;
        }
        /* Header */
        .header {
            background: #3498db;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            border-radius: 8px;
            box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.2);
            animation: glow 1.5s infinite alternate;
        }
        /* Footer */
        .footer {
            background: #1abc9c;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
            font-size: 14px;
            box-shadow: 0px -2px 6px rgba(0, 0, 0, 0.2);
        }
        /* Glow Animation */
        @keyframes glow {
            0% { text-shadow: 0 0 5px #fff, 0 0 10px #3498db; }
            100% { text-shadow: 0 0 10px #fff, 0 0 20px #3498db; }
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <a href="admin.jsp"><i class="fa-solid fa-house"></i> Home</a>
        <a href="readcontact.jsp"><i class="fa-solid fa-envelope"></i> Read Messages</a>
        <a href="addservice.jsp"><i class="fa-solid fa-plus"></i> Add Service</a>
        <a href="ReadServiceDeleteUpdateModule"><i class="fa-solid fa-list"></i> Read Service</a>
        <a href="message1.jsp"><i class="fa-solid fa-user-lock"></i> Login & Signup</a>
        <a href="booking.jsp"><i class="fa-solid fa-calendar-check"></i> All Bookings</a>
        <a href="changepassword.jsp"><i class="fa-solid fa-key"></i> Change Password</a>
        <a href="Logout.jsp"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
    </div>

    <div class="content">
        <div class="header"><i class="fa-solid fa-user-shield"></i> Admin Panel</div>
        <h2><%@include file="message.jsp" %></h2>
        
        <div class="footer"><i class="fa-solid fa-copyright"></i> 2025 Admin Panel</div>
    </div>
</body>
</html>
