package com.controller;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionFactroy;
import com.service.BookingService;
import com.service.BookingServiceImpl;

@WebServlet("/BookTableServlet")

public class BookTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 📌 Get Parameters from Form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String dateTime = request.getParameter("datetime"); // User Input DateTime
            String peopleStr = request.getParameter("people");
            String specialRequest = request.getParameter("message"); // 📌 Retrieve Special Request

//            System.out.println("Received Data:");
//            System.out.println("Name: " + name);
//            System.out.println("Email: " + email);
//            System.out.println("DateTime: " + dateTime);
//            System.out.println("People: " + peopleStr);
//            System.out.println("Special Request: " + specialRequest); // Debug Output

            // 📌 Validation: Null & Empty Checks
            if (name == null || name.isEmpty() || email == null || email.isEmpty() ||
                dateTime == null || dateTime.isEmpty() || peopleStr == null || peopleStr.isEmpty()) {
                System.out.println("Validation Failed: Missing Required Fields!");
                response.sendRedirect("booking.jsp?error=Please fill all required fields!");
                return;
            }

            // 📌 Convert People Count to Integer
            int people;
            try {
                people = Integer.parseInt(peopleStr);
            } catch (NumberFormatException e) {
                System.out.println("Validation Failed: Invalid number of people!");
                response.sendRedirect("booking.jsp?error=Invalid number of people!");
                return;
            }

            // 📌 Convert DateTime to MySQL Format (yyyy-MM-dd HH:mm:ss)
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a"); // Input format (e.g., 03/03/2025 9:52 AM)
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // MySQL format

            Date parsedDate = inputFormat.parse(dateTime);
            String formattedDateTime = outputFormat.format(parsedDate); // Convert to correct format

            // 📌 Database Connection
            Connection con = ConnectionFactroy.getConnection();
            if (con == null) {
                System.out.println("Database Connection Failed!");
                response.sendRedirect("booking.jsp?error=Database Connection Failed!");
                return;
            }

            // 📌 Insert Query
            String query = "INSERT INTO reservation (name, email, date_time, people, special_request) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, formattedDateTime); // ✅ Correctly formatted DateTime
            pstmt.setInt(4, people);
            pstmt.setString(5, (specialRequest != null && !specialRequest.isEmpty()) ? specialRequest : "No Special Requests"); // ✅ Ensure non-null value

            // 📌 Execute Query
            int row = pstmt.executeUpdate();
            con.close();

            // 📌 Debugging: Verify if data was inserted successfully
            if (row == 1) {
               // System.out.println("✅ Reservation Inserted Successfully!");
            } else {
                System.out.println("❌ Failed to Insert Reservation!");
            }

            // 📌 Redirect Back to Booking Page
            response.sendRedirect("booking.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("booking.jsp?error=Database Error!");
        }
    }
}