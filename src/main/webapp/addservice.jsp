

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
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Service</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
            max-width: 500px;
            width: 100%;
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }
        .container:hover {
            transform: scale(1.02);
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 16px;
            transition: 0.3s;
            outline: none;
        }
        input:focus {
            border-color: #007BFF;
            box-shadow: 0 0 8px rgba(0, 123, 255, 0.2);
        }
        .btn {
            background: linear-gradient(90deg, #ff7eb3, #ff758c);
            color: white;
            padding: 12px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 18px;
            width: 100%;
            transition: background 0.3s ease-in-out;
        }
        .btn:hover {
            background: linear-gradient(90deg, #ff758c, #ff5e62);
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>✨ Add a New Service ✨</h2>
        <h3> <%@include file="message.jsp" %></h3>
        <form action="ServiceModuleServlet1" method="post">
            <div class="form-group">
                <label for="serviceName">Icon Name</label>
                <input type="text" id="serviceName" name="iconname" placeholder="Enter Icon  name" required>
            </div>
            <div class="form-group">
                <label for="serviceCategory"> Ttitle</label>
                <input type="text" id="serviceCategory" name="title" placeholder="Enter Title " required>
            </div>
            <div class="form-group">
                <label for="servicePrice">Description </label>
                <input type="text" id="servicePrice" name="description" placeholder="Enter Description " required>
            </div>
            <button type="submit" class="btn">🚀 Add Service</button>
        </form>
    </div>
</body>
</html>

    