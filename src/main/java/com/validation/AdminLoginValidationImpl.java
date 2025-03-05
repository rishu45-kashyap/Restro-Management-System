package com.validation;

public class AdminLoginValidationImpl implements AdminLoginValidation {
private String result;
	@Override
	public String adminLoginValidation(String username, String password) {
		try {
			int user_len=username.length();
			int pass_len=password.length();
			if(user_len<6|| user_len>20)
			{
				result=" INVALID USERNAME";
			}
			else if (pass_len<5||pass_len>20) 
			{
				result=" INVALID PASSWORD";
			} 
			else {
				result="VALID";

			}
			
			
		} catch (Exception e) {
			result="SOMETHING WENT WRONG";
			e.printStackTrace();
		}
		return result;
		
	}

}
