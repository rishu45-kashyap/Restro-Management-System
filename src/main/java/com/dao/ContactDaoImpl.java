package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {
	private String result;

	@Override
	public String saveContact(String name, String email, String subject, String message, String datetime) {
		Connection connection = null;
		try {
			connection = ConnectionFactroy.getConnection();
			String Sql = "insert into Contact (name,email,subject,message,dateTime)values(?,?,?,?,? )";
			PreparedStatement ps = connection.prepareStatement(Sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, message);
			ps.setString(5, datetime);
			int row = ps.executeUpdate();
			if (row == 1) {
				result = "MESSAGE SENT SUCESSFULLY";

			} else {
				result = "FAIELD";
			}

		} catch (Exception e) {

			e.printStackTrace();
			result = "FAIELD";
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ArrayList<ContactPojo> readContact() {
		Connection connection =null;

		ArrayList<ContactPojo> arrayList = new ArrayList<ContactPojo>();
		  try {
			    connection = ConnectionFactroy.getConnection();
			  String sql = "Select * from Contact";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ResultSet rs = ps.executeQuery();
			  
			  
		  if( !rs.next())
		  {
				arrayList.add(new ContactPojo(0, "ne", "ne", "ne", "ne", "ne"));  			  }
			  else 
			  
			  {
				do {
					arrayList.add(new ContactPojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"), rs.getString("subject"), 
							   rs.getString("message"), rs.getString("datetime")));
					
				}
			  
			  
			  while(rs.next()); 
				   
				      //arrayList.add(ContactPojo);
			  
			  			  }
			System.out.println(arrayList.size());

		} catch (Exception e) {
			 System.out.println("Error: " + e.getMessage());

			e.printStackTrace();
			arrayList.clear();
		}
		  finally {
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
	public String deleteContact(int sn) {
		Connection connection = null;
		try {
			connection = ConnectionFactroy.getConnection();
			String Sql = "DELETE FROM Contact WHERE sn=?";
			PreparedStatement ps = connection.prepareStatement(Sql);
			ps.setInt(1, sn);
			int row = ps.executeUpdate();
			if (row == 1) {
				result = "MESSAGE Delete  SUCESSFULLY";

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
