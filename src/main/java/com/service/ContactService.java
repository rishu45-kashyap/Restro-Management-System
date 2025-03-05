package com.service;

import java.util.ArrayList;

import com.model.ContactPojo;

public interface ContactService { 
	public  String  ContactService1(String name , String email,String subject,String message);
	public  String  ContactService2(String name , String email,String subject,String message);
	public ArrayList<ContactPojo> readContactService();
	public  String  deleteService(String sn);


}
