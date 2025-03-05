<%@page import="com.model.ServiceModulePojo"%>
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
    <title>Service List</title>
    <style>
        /* Google Font */
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            max-width: 1200px;
            margin: auto;
            padding: 20px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .nav-links {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-bottom: 20px;
        }
        .nav-links a {
            text-decoration: none;
            font-size: 16px;
            padding: 10px 15px;
            border-radius: 5px;
            color: white;
            background-color: #007BFF;
            transition: background 0.3s;
        }
        .nav-links a:hover {
            background-color: #0056b3;
        }
        .service-card {
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            width: 80%;
            transition: transform 0.3s ease-in-out;
            position: relative;
        }
        .service-card:hover {
            transform: scale(1.02);
        }
        .service-icon {
            font-size: 40px;
            color: #007BFF;
            margin-bottom: 10px;
        }
        .title {
            font-size: 22px;
            font-weight: 600;
            color: #007BFF;
        }
        .description {
            font-size: 16px;
            color: #555;
            margin: 10px 0;
        }
        .datetime {
            font-size: 14px;
            color: #777;
            margin-bottom: 10px;
        }
        .buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
        }
        .btn {
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
            transition: background 0.3s ease;
            display: flex;
            align-items: center;
            gap: 5px;
        }
        .delete-btn {
            background-color: #e74c3c;
            color: white;
        }
        .delete-btn:hover {
            background-color: #c0392b;
        }
        .update-btn {
            background-color: #f1c40f;
            color: black;
        }
        .update-btn:hover {
            background-color: #d4ac0d;
        }
        .icon {
            font-size: 18px;
        }
    </style>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <h1>Service List</h1>

        <div class="nav-links">
            <a href="admin.jsp"><i class="fas fa-home"></i> Home</a>
            <a href="ReadServiceDeleteUpdateModule"><i class="fas fa-sync-alt"></i> Refresh</a>
        </div>

        <%
        ArrayList<ServiceModulePojo> al = (ArrayList<ServiceModulePojo>) session.getAttribute("servicedata"); 
       int index=0;
        
        if (al != null && !al.isEmpty()) {
            for (ServiceModulePojo sm : al) { 
        %>

        <div class="service-card">
            <div class="service-icon">
                <i class="fas fa-cogs"></i> <!-- Service Icon -->
            </div>
            <div class="title"><i class="fas fa-tag icon"></i> Title: <%= sm.getTitle() %></div>
            <div class="description"><i class="fas fa-file-alt icon"></i> Description: <%= sm.getDescription() %></div>
            <div class="datetime"><i class="fas fa-calendar-alt icon"></i> Date & Time: <%= sm.getDatetime() %></div>

            <div class="buttons">
                <!-- Delete Button -->
                <form action="DeleteServiceModuleServlet" method="post">
                    <input type="hidden" name="sn" value="<%= sm.getSn() %>">
                    <button type="submit" class="btn delete-btn">
                        <i class="fas fa-trash"></i> Delete
                    </button>
                </form>
                <a href="updateService.jsp ?index=<%= index%>"></a>

                <!-- Update Button -->
                <%-- <form action="UpdateServiceModuleServlet" method="post">
                    <input type="hidden" name="sn" value="<%= sm.getSn() %>">
                    <button type="submit" class="btn update-btn">
                        <i class="fas fa-edit"></i> Update
                    </button>
                </form> --%>
            </div>
        </div>

        <%
        index++;
            } 
        } else { 
        %>

        <p>No services available.</p>

        <% } %>
    </div>
</body>
</html>
