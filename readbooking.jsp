<%@ page import="java.util.List" %>
<%@ page import="com.model.Reservation" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Reservations</title>
</head>
<body>
    <h2>Reservations List</h2>

    <% 
        Object reservationsObj = request.getAttribute("reservations");
        if (reservationsObj == null) { 
            out.println("<p style='color:red;'>⚠️ Error: reservations object is NULL!</p>");
        } else {
            List<Reservation> reservations = (List<Reservation>) reservationsObj;
            if (reservations.isEmpty()) { 
                out.println("<p>No reservations found.</p>");
            } else { 
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Date Time</th>
                <th>People</th>
                <th>Special Request</th>
            </tr>
            <% for (Reservation res : reservations) { %>
            <tr>
                <td><%= res.getId() %></td>
                <td><%= res.getName() %></td>
                <td><%= res.getEmail() %></td>
                <td><%= res.getDateTime() %></td>
                <td><%= res.getPeople() %></td>
                <td><%= res.getSpecialRequest() %></td>
            </tr>
            <% } %>
        </table>
    <% } } %>

</body>
</html>
