package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConnectionFactroy;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	 String email = request.getParameter("email");
         String password = request.getParameter("password");

         try {
            Connection conn = ConnectionFactroy.getConnection();
             String sql = "SELECT name FROM users WHERE email=? AND password=?";
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, email);
             stmt.setString(2, password);

             ResultSet rs = stmt.executeQuery();
             HttpSession session = request.getSession();

             if (rs.next()) {
                 String userName = rs.getString("name");
                 session.setAttribute("userName", userName);
                 response.sendRedirect("index.jsp");
             } else {
                 session.setAttribute("errorMessage", "Invalid Email or Password!");
                 response.sendRedirect("index1.jsp");
             }
             conn.close();
         } catch (Exception e) {
             e.printStackTrace();
             response.getWriter().println("Error: " + e.getMessage());
         }
     }
 }