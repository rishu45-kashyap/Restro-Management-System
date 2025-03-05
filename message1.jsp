<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dao.ConnectionFactroy"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Messages</title>
</head>
<body>
    <h1>Messages</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Message</th>
            <th>Actions</th>
        </tr>
        <%
            try {
                  Connection  conn= ConnectionFactroy.getConnection();
                String sql = "SELECT * FROM users";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String message = rs.getString("message");
        %>
        <tr>
            <td><%=id%></td>
            <td><%=message%></td>
            <td>
                <a href="MessageServlet?id=<%=id%>">Read/Delete</a>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>
l>