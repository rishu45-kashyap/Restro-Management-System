<!DOCTYPE html>
<%@page import="com.model.ServiceModulePojo"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Service</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
body {
	background: linear-gradient(45deg, #1a1a2e, #16213e);
	color: white;
	font-family: Arial, sans-serif;
}

.container {
	margin-top: 5%;
	padding: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, 0.1);
	box-shadow: 0 0 15px rgba(255, 255, 255, 0.2);
	backdrop-filter: blur(10px);
	animation: fadeIn 1s ease-in-out;
}

@
keyframes fadeIn {from { opacity:0;
	transform: scale(0.9);
}

to {
	opacity: 1;
	transform: scale(1);
}

}
.form-control {
	background: rgba(255, 255, 255, 0.2);
	border: none;
	color: white;
}

.form-control:focus {
	box-shadow: 0 0 10px #00c3ff;
	border-color: #00c3ff;
}

.btn-update {
	background: #00c3ff;
	color: white;
	transition: 0.3s;
	box-shadow: 0 0 10px rgba(0, 195, 255, 0.5);
}

.btn-update:hover {
	background: #008fb3;
	box-shadow: 0 0 20px rgba(0, 195, 255, 0.7);
}
</style>
</head>
<body>

	<%
	int index = Integer.parseInt(request.getParameter("index"));
	ArrayList<ServiceModulePojo> al = (ArrayList<ServiceModulePojo>) session.getAttribute("servicedata");

	ServiceModulePojo sm = al.get(index);
	%>








	<div class="container w-50 text-center">
		<h2 class="mb-4">Update Service</h2>
		<%=sm.getDatetime() %>
		<form action="#" method="POST">
			<div class="mb-3 text-start">
				<label class="form-label"><i class="fa-solid fa-icons"></i>Icon Name</label> 
					<input type="text" name="icon"   value="<%=sm.getIconname() %>" class="form-control"
					placeholder="Enter Icon Name" required>
			</div>
			<div class="mb-3 text-start">
				<label class="form-label"><i class="fa-solid fa-heading"></i>
					Title</label> <input type="text" name="title"  value="<%=sm.getTitle() %>" class="form-control"
					placeholder="Enter Title" required>
			</div>
			<div class="mb-3 text-start">
				<label class="form-label"><i class="fa-solid fa-align-left"></i>
					Description</label>
				<textarea name="description" class="form-control" rows="3"placeholder="Enter Description" required><%=sm.getDescription()%></textarea>
			</div>
			<button type="submit" class="btn btn-update w-100 py-2">
				Update Service <i class="fa-solid fa-arrow-right"></i>
			</button>
		</form>
	</div>
</body>
</html>