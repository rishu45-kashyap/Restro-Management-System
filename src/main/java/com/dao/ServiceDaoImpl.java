package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ContactPojo;
import com.model.ServiceModulePojo;

public class ServiceDaoImpl implements ServiceDao {
	private String result;

	@Override
	public String saveService(String iconname, String title, String description, String datetime) {

		try {

			Connection connection = ConnectionFactroy.getConnection();
			String sql = " INSERT INTO service(iconname,title,description,datetime) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, iconname);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, description);
			preparedStatement.setString(4, datetime);
			int ex = preparedStatement.executeUpdate();

			if (ex == 1) {
				result = "SERVICE ADDED SUCCESFULLY ";

			} else {
				result = "SOMETHING WENT WRONG";
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = "SOMETHING WENT WRONG";
		}

		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String readAllService(String iconname, String title, String description, String daetime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ServiceModulePojo> readAllService() {
		Connection connection = null;

		ArrayList<ServiceModulePojo> arrayList = new ArrayList<ServiceModulePojo>();
		try {
			connection = ConnectionFactroy.getConnection();
			String sql = "Select * from service";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
			{
				
				arrayList.add( new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
				
			

			do {
				ServiceModulePojo serviceModulePojo = new ServiceModulePojo(rs.getInt("sn"), rs.getString("iconname"),
						rs.getString("title"), rs.getString("description"), rs.getString("datetime"));
				arrayList.add(serviceModulePojo);
			}

			 while(rs.next());
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

			e.printStackTrace();
			arrayList.clear();
		} finally {
			try {
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());

			}
		}

		return arrayList;
	}

	@Override
	public ArrayList<ServiceModulePojo> readfourService() {
		Connection connection = null;

		ArrayList<ServiceModulePojo> arrayList = new ArrayList<ServiceModulePojo>();
		try {
			connection = ConnectionFactroy.getConnection();
			String sql = "Select * from service LIMIT 4";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
			{
				
				arrayList.add( new ServiceModulePojo(0, "ne", "ne", "ne", "ne"));
			}
			else
			{
				
			

			do {
				ServiceModulePojo serviceModulePojo = new ServiceModulePojo(rs.getInt("sn"), rs.getString("iconname"),
						rs.getString("title"), rs.getString("description"), rs.getString("datetime"));
				arrayList.add(serviceModulePojo);
			}

			 while(rs.next());
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

			e.printStackTrace();
			arrayList.clear();
		} finally {
			try {
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());

			}
		}

		return arrayList;
		}

	@Override
	public String deleteService(int sn) {
		Connection connection = null;
		try {
			connection = ConnectionFactroy.getConnection();
			String Sql = "DELETE FROM service WHERE sn=?";
			PreparedStatement ps = connection.prepareStatement(Sql);
			ps.setInt(1, sn);
			int row = ps.executeUpdate();
			if (row == 1) {
				result = "SERVICE Delete  SUCESSFULLY";

			} else {
				result = "SOMETHING WENT WRONG";
			}

		} catch (Exception e) {

			e.printStackTrace();
			result = "SOMETHING WENT WRONG";
		}
		// TODO Auto-generated method stub
		return result;
	}

}
