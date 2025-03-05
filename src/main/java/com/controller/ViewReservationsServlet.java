package com.controller;
import com.dao.ConnectionFactroy;
import com.model.Reservation;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewReservationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> reservations = new ArrayList<>();

        try {
            Connection conn = ConnectionFactroy.getConnection();
            String sql = "SELECT id, name, email, datetime, people, special_request FROM reservations";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                reservations.add(new Reservation(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("datetime"),
                    rs.getInt("people"),
                    rs.getString("special_request")
                ));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("readbooking.jsp.jsp").forward(request, response);
    }
}
