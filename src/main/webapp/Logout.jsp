<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout - Admin Panel</title>
    <style>
        /* Google Font */
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');

        /* Full Page Background Animation */
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #ff9a9e, #fad0c4);
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            overflow: hidden;
            animation: gradientMove 5s infinite alternate;
        }

        @keyframes gradientMove {
            from { background: linear-gradient(135deg, #ff9a9e, #fad0c4); }
            to { background: linear-gradient(135deg, #fad0c4, #ff9a9e); }
        }

        .container {
            background: rgba(255, 255, 255, 0.2);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            text-align: center;
            backdrop-filter: blur(10px);
            width: 450px;
            transition: transform 0.3s ease-in-out;
        }
        .container:hover {
            transform: scale(1.05);
        }

        /* Floating Logout Icon */
        .logout-icon {
            font-size: 60px;
            color: #ff4757;
            margin-bottom: 15px;
            animation: floatIcon 1.5s infinite alternate ease-in-out;
        }
        @keyframes floatIcon {
            from { transform: translateY(0); }
            to { transform: translateY(-8px); }
        }

        /* Animated Logout Message */
        .logout-message {
            font-size: 24px;
            font-weight: 600;
            color: white;
            text-transform: uppercase;
            letter-spacing: 2px;
            position: relative;
            display: inline-block;
            animation: neonGlow 1.5s infinite alternate;
        }

        @keyframes neonGlow {
            from { text-shadow: 0 0 5px white, 0 0 10px #ff4757, 0 0 20px #ff4757; }
            to { text-shadow: 0 0 10px white, 0 0 20px #ff6b81, 0 0 30px #ff6b81; }
        }

        /* Countdown Timer */
        .countdown {
            font-size: 16px;
            color: #fff;
            margin-top: 10px;
        }

        /* Styled Button */
        .login-btn {
            background-color: #ff4757;
            color: white;
            text-decoration: none;
            padding: 12px 18px;
            border-radius: 8px;
            display: inline-block;
            font-size: 16px;
            transition: transform 0.3s ease-in-out, box-shadow 0.3s;
            border: none;
            cursor: pointer;
        }
        .login-btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 4px 15px rgba(255, 71, 87, 0.3);
        }
    </style>

    <script>
        // Countdown for Redirect
        let countdown = 5;
        function startCountdown() {
            let countdownElement = document.getElementById("countdown");
            let interval = setInterval(() => {
                countdown--;
                countdownElement.innerHTML = countdown;
                if (countdown === 0) {
                    clearInterval(interval);
                    window.location.href = "adminlogin.jsp";
                }
            }, 1000);
        }

        window.onload = startCountdown;
    </script>
</head>
<body>
    <div class="container">
        <div class="logout-icon">
            <i class="fas fa-sign-out-alt"></i> <!-- Logout Icon -->
        </div>
        <h1 class="logout-message">You are logged out!</h1>
        <p class="countdown">Redirecting in <span id="countdown">5</span> seconds...</p>

        <a href="adminlogin.jsp" class="login-btn">Login Again</a>
    </div>
</body>
</html>
