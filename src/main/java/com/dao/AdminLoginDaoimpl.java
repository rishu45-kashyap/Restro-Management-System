package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDaoimpl implements AdminLoginDao {
   private String result;
	@Override
	public String checkAdminLoginData(String username, String password) {
		
		try {
			 Connection connection = ConnectionFactroy.getConnection();
	            // Corrected SQL query
	            String sql = "SELECT * FROM adminlogin WHERE username = ? AND password = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            ResultSet rs = statement.executeQuery();

	            if (rs.next()) {
	                result = "EXIST";
	            } else {
	                result = "NOTEXIST";
	            }
			
		} catch (Exception e) {
			result="FAILED";
			e.printStackTrace();
		}
		
		return result;
	}

}
