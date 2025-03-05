package com.validation;

public class ContactValidationImpl implements ContactValidation {
	private String result;

	@Override
	public String contactValidation(String name, String email, String subject, String message) {
		
		
		int name_lenght=name.length();
		int email_legth=email.length();
		int subj_lenght=subject.length();
		int mess_length=message.length();
		
		
		
		
		if(name_lenght<2||name_lenght>50) {
			result="INVALID NAME LENGHT";
			}
		
		else if (email_legth<13||email_legth>30|| !email.contains("@")) {
			
			result="INVALID EMAIL";
			
		}
		else if (subj_lenght<10||subj_lenght>80) {
			result="INVALID SUBJECT";
			
		}
		else if (mess_length<20||mess_length>90) {
			result="INVALID MESSAGE";
			
		}
		else {
			result="VALID";
		}
		return result;
	}

}
