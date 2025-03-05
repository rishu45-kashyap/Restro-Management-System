<%@page import="com.model.ContactPojo"%>
<%@page import="java.util.ArrayList"%>
<%
String check = (String) session.getAttribute("adminlogin");
if (check == null) {
    response.sendRedirect("adminlogin.jsp");
    return;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Messages</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f0f2f5;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            max-width: 1200px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }
        h1 {
            color: #333;
        }
        .nav {
            display: flex;
            justify-content: space-between;
            padding: 10px 20px;
            background: #007BFF;
            border-radius: 12px 12px 0 0;
        }
        .nav a {
            color: white;
            text-decoration: none;
            font-size: 16px;
            padding: 8px 12px;
            border-radius: 5px;
        }
        .nav a:hover {
            background: rgba(255, 255, 255, 0.2);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        .delete-btn {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
        }
        .delete-btn:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="admin.jsp">Home</a>
            <a href="ReadMessageServlet">Refresh</a>
        </div>
        <h1 style="color: blue">READ CONTACT</h1>
          <h2> <%@include file="message.jsp" %></h2>
        
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Subject</th>
                <th>Message</th>
                <th>Date & Time</th>
                <th>Action</th>
            </tr>
            
            <% 
                ArrayList<ContactPojo> arrayList = (ArrayList<ContactPojo>) session.getAttribute("contactdata");
                if (arrayList != null) {
                    for (ContactPojo cp : arrayList) { 
            %>
            <tr>
                <td><%= cp.getName() %></td>
                <td><%= cp.getEmail() %></td>
                <td><%= cp.getSubject() %></td>
                <td><%= cp.getMessage() %></td>
                <td><%= cp.getDatetime() %></td>
                <td>
                    <form action="DeleteContactServlet" method="post" style="margin: 0;">
                        <input type="hidden" name="sn" value="<%= cp.getSn()%>">
                        <button type="submit" class="delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
            <% 
                    } 
                } else { 
            %>
            <tr><td colspan="6">No messages found.</td></tr>
            <% } %>
        </table>
    </div>
</body>
</html>
