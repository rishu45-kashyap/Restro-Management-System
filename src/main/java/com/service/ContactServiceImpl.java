package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ContactDaoImpl;
import com.model.ContactPojo;
import com.validation.ContactValidation;
import com.validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {
	private String result;

	@Override
	public String ContactService1(String name, String email, String subject, String message) {
		try {
			ContactValidationImpl contactValidationImpl = new ContactValidationImpl();
			result = contactValidationImpl.contactValidation(name, email, subject, message);

		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String ContactService2(String name, String email, String subject, String message) {
		try {
			String datetime = LocalDateTime.now().toString();
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result = contactDaoImpl.saveContact(name, email, subject, message, datetime);

		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	// Read contact ka ha
	@Override
	public ArrayList<ContactPojo> readContactService() {
		ArrayList<ContactPojo> arrayList = null;
		try {
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			arrayList = contactDaoImpl.readContact();

		} catch (Exception e) {
			e.printStackTrace();

		}
		// TODO Auto-generated method stub
		return arrayList;
	}

	// delete message
	@Override
	public String deleteService(String sn) {

		try {

			int intsn = Integer.parseInt(sn);
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result = contactDaoImpl.deleteContact(intsn);

		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}

		return result;
	}

}
