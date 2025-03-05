package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

public class BookingDaoImpl {
    public String BookingService1(String name, String email, int numPeople, String specialRequest) {
        Connection connection = null;
        try {
        	 connection = ConnectionFactroy.getConnection();
            String sql = "INSERT INTO reservations (name, email, numPeople, specialRequest, dateTime) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, numPeople);
            ps.setString(4, specialRequest);
            ps.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            int row = ps.executeUpdate();
            if (row == 1) {
                return "VALID";
            } else {
                return "FAILED";
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            return "FAILED";
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Ignore
            }
        }
    }
}
