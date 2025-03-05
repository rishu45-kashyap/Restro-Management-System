package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactroy {
	private static String url="jdbc:mysql://localhost:3306/restro";
	private static String username="root";
	private static String password="Rishu@45";
	private static String driverClassName="com.mysql.cj.jdbc.Driver";
	private static Connection con;
	
	
	public static Connection getConnection() {
		try {
			Class.forName(driverClassName);
			 con=DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
