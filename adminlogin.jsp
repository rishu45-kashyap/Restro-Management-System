<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: radial-gradient(circle, #1a1a2e, #16213e);
            overflow: hidden;
        }

        .login-container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 0px 20px rgba(255, 255, 255, 0.2);
            width: 350px;
            text-align: center;
            backdrop-filter: blur(10px);
            animation: fadeIn 1s ease-in-out, glowing 2s infinite alternate;
            position: relative;
        }

        @keyframes glowing {
            0% {
                box-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
            }
            100% {
                box-shadow: 0 0 20px rgba(0, 255, 255, 0.8);
            }
        }

        h1 {
            margin-bottom: 20px;
            color: #fff;
            font-size: 24px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        .input-group {
            margin-bottom: 20px;
            text-align: left;
            position: relative;
        }

        .input-group i {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: #ccc;
            font-size: 18px;
        }

        label {
            display: block;
            color: #fff;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px 35px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            outline: none;
            transition: 0.3s ease-in-out;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            background: rgba(255, 255, 255, 0.3);
            box-shadow: 0 0 15px rgba(0, 255, 255, 0.8);
            transform: scale(1.05);
        }

        .submit-button {
            width: 100%;
            padding: 12px;
            background: linear-gradient(45deg, #00c6ff, #0072ff);
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
            text-transform: uppercase;
            letter-spacing: 1px;
            position: relative;
            overflow: hidden;
        }

        .submit-button:hover {
            background: linear-gradient(45deg, #0072ff, #00c6ff);
            transform: scale(1.05);
            box-shadow: 0 0 15px rgba(0, 255, 255, 0.8);
        }

        .success-message {
            position: absolute;
            top: -50px;
            left: 50%;
            transform: translateX(-50%);
            background: #28a745;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
            display: none;
            animation: slideDown 0.5s ease-in-out;
            font-weight: bold;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes slideDown {
            from {
                top: -80px;
                opacity: 0;
            }
            to {
                top: -50px;
                opacity: 1;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <%@include file="message.jsp" %>
        <div class="success-message" id="successMsg"></div>
        <h1>Admin Login</h1>
        <form id="loginForm" action="AdminLoginServlet1" method="POST">
            <div class="input-group">
                <i class="fas fa-user"></i>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <i class="fas fa-lock"></i>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="submit-button">Login</button>
        </form>
    </div>

    <script>
        document.getElementById("loginForm").addEventListener("submit", function(event) {
            event.preventDefault();
            let username = document.getElementById("username").value;
            let successMessage = document.getElementById("successMsg");
            successMessage.innerHTML = `✔ Welcome, <strong>${username}</strong>! Login Successful!`;
            successMessage.style.display = "block";

            setTimeout(() => {
                this.submit();
            }, 1500);
        });
    </script>
</body>
</html>
