package com.dao;

import java.util.ArrayList;

import com.model.ContactPojo;

public interface ContactDao {
	public String saveContact(String name, String email, String subject, String message,String datetime);
	
	public String deleteContact(int sn);
	public  ArrayList<ContactPojo> readContact();


}
