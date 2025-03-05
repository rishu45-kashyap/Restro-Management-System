package com.validation;

public class BookingValidationImpl implements BookingValidation {
     private String result;
	@Override
	public String BookingService1(String name, String email, String numPeople, String specialRequest) {
		 if (name == null || name.isEmpty() || name.length() < 2 || name.length() > 50) {
	            result = "INVALID NAME LENGHT";
	        }

	        // Email validation
	        else if (email == null || email.isEmpty() || email.length() < 13 || email.length() > 30 || !email.contains("@")) {
	            result = "INVALID EMAIL";
	        }

	        // NumPeople validation
	        else if (numPeople == null || numPeople.isEmpty() || Integer.parseInt(numPeople) < 1 || Integer.parseInt(numPeople) > 4) {
	            result = "INVALID NUMBER OF PEOPLE";
	        }

	        // SpecialRequest validation
	        else if (specialRequest == null || specialRequest.isEmpty() || specialRequest.length() < 20 || specialRequest.length() > 50) {
	            result = "INVALID SPECIAL REQUEST";
	        }

	        else {
	            result = "VALID";
	        }

	        return result;
	}
}
