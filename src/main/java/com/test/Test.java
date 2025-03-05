package com.test;

import java.util.ArrayList;

import com.dao.ConnectionFactroy;
import com.dao.ContactDaoImpl;
import com.model.ContactPojo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<ContactPojo> contact = new ContactDaoImpl().readContact();
		 for(ContactPojo cp : contact) {
			 System.out.println(cp.toString());
		 }
		   

	}

}
