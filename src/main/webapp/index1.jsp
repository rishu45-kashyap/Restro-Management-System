<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login & Signup</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            width: 400px;
            background: rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
            transition: transform 0.3s ease-in-out;
        }
        .container:hover {
            transform: scale(1.05);
        }
        .icon {
            font-size: 40px;
            color: #fff;
            margin-bottom: 15px;
        }
        .input-box {
            position: relative;
            margin: 15px 0;
        }
        .input-box input {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            outline: none;
        }
        .btn {
            background-color: #fff;
            color: #2575fc;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
        }
        .toggle {
            margin-top: 15px;
            color: white;
            cursor: pointer;
            text-decoration: underline;
        }
        #signupForm {
            display: none;
        }
    </style>

    <script>
        function toggleForm() {
            let loginForm = document.getElementById("loginForm");
            let signupForm = document.getElementById("signupForm");

            if (loginForm.style.display === "none") {
                loginForm.style.display = "block";
                signupForm.style.display = "none";
            } else {
                loginForm.style.display = "none";
                signupForm.style.display = "block";
            }
        }
    </script>
</head>
<body>

    <div class="container">
        <div id="loginForm">
            <i class="fas fa-user-circle icon"></i>
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <div class="input-box">
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <button class="btn">Login</button>
            </form>
            <p class="toggle" onclick="toggleForm()">Don't have an account? Sign up</p>
        </div>

        <div id="signupForm">
            <i class="fas fa-user-plus icon"></i>
            <h2>Sign Up</h2>
            <form action="SignupServlet" method="post">
                <div class="input-box">
                    <input type="text" name="name" placeholder="Full Name" required>
                </div>
                <div class="input-box">
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <button class="btn">Sign Up</button>
            </form>
            <p class="toggle" onclick="toggleForm()">Already have an account? Login</p>
        </div>
    </div>

</body>
</html> 