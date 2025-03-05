package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionFactroy;


@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String messageId = request.getParameter("id");

        if (messageId == null || messageId.isEmpty()) {
            response.sendRedirect("messages.jsp?error=Message ID is missing");
            return;
        }

        try (Connection conn = ConnectionFactroy.getConnection()) {
            String sql = "SELECT * FROM messages WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, messageId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String message = rs.getString("message");
                request.setAttribute("message", message);
                request.getRequestDispatcher("readMessage.jsp").forward(request, response);
            } else {
                response.sendRedirect("messages1.jsp?error=Message not found");
            }
        } catch (Exception e) {
            response.sendRedirect("messages1.jsp?error=" + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String messageId = request.getParameter("id");

        if (messageId == null || messageId.isEmpty()) {
            response.sendRedirect("messages1.jsp?error=Message ID is missing");
            return;
        }

        try (Connection conn = ConnectionFactroy.getConnection()) {
            String sql = "DELETE FROM messages WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, messageId);
            stmt.executeUpdate();

            response.sendRedirect("messages1.jsp?success=Message deleted successfully");
        } catch (Exception e) {
            response.sendRedirect("messages1.jsp?error=" + e.getMessage());
        }
    }
}


