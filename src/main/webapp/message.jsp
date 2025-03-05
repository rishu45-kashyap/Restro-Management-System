<%-- 
<%
String message = (String) session.getAttribute("msg");
if (message != null) 
 {
	if (message.contains("SUCCESSFULY"))
	 {
%>
     <span style="color: blue"> <%=message%></span>
<%
}
	else{
		
	
%>
<span style="color: red"> <%=message%></span>
<%
	}
   }
session.removeAttribute("msg");
%> 


 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Display</title>
<style>
    .success-message {
        color: #00ff00; /* Neon Green */
        font-weight: bold;
        font-size: 22px;
        text-shadow: 0 0 5px #00ff00, 0 0 10px #00ff00, 0 0 20px #008000;
        animation: flicker 1s infinite alternate, glow 2s infinite alternate;
    }

    .error-message {
        color: #ff0000;
        font-weight: bold;
        font-size: 22px;
        text-shadow: 0 0 5px #ff0000, 0 0 10px #ff0000, 0 0 20px #800000;
        animation: shake 0.5s infinite alternate, glow 2s infinite alternate;
    }

    /* ⚡ Lightning Flicker Effect */
    @keyframes flicker {
        0% { opacity: 1; }
        50% { opacity: 0.6; text-shadow: 0 0 10px #00ff00, 0 0 20px #00ff00; }
        100% { opacity: 1; text-shadow: 0 0 5px #00ff00, 0 0 15px #00ff00; }
    }

    /* 🔥 Smooth Glowing Effect */
    @keyframes glow {
        0% { text-shadow: 0 0 5px #00ff00, 0 0 10px #00ff00; }
        100% { text-shadow: 0 0 20px #00ff00, 0 0 40px #00ff00; }
    }

    /* ❌ Error Message Shake Effect */
    @keyframes shake {
        0% { transform: translateX(0); }
        25% { transform: translateX(-5px); }
        50% { transform: translateX(5px); }
        75% { transform: translateX(-5px); }
        100% { transform: translateX(5px); }
    }
</style>
</head>
<body>

<%
String message = (String) session.getAttribute("msg");
if (message != null) {
    if (message.contains("SUCCESSFULY")) {
%>
    <span class="success-message"><%= message %> ⚡</span>
<%
    } else {
%>
    <span class="error-message"><%= message %> ❌</span>
<%
    }
}
session.removeAttribute("msg");
%>

</body>
</html>
