package com.service;

import com.dao.BookingDaoImpl;
import com.validation.BookingValidationImpl;

public class BookingServiceImpl implements BookingService {

	@Override
	public String BookingService1(String name, String email, String numPeople, String specialRequest) {
		 BookingValidationImpl validation = new BookingValidationImpl();
	        String validationResult = validation.BookingService1(name, email, numPeople, specialRequest);
	        if (validationResult.equals("VALID")) {
	            BookingDaoImpl dao = new BookingDaoImpl();
	            int people = Integer.parseInt(numPeople);
	            return dao.BookingService1(name, email, people, specialRequest);
	        } else {
	            return validationResult;
	        }
	    }

	

	@Override
	public String BookingService2(String name, String email, String numPeople, String specialRequest) {
		 BookingValidationImpl validation = new BookingValidationImpl();
	        String validationResult = validation.BookingService1(name, email, numPeople, specialRequest);
	        if (validationResult.equals("VALID")) {
	            BookingDaoImpl dao = new BookingDaoImpl();
	            int people = Integer.parseInt(numPeople);
	            return dao.BookingService1(name, email, people, specialRequest);
	        } else {
	            return validationResult;
	        }
	    }
	



	}
   


