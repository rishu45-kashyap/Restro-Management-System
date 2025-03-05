package com.service;

import com.dao.AdminLoginDaoimpl;
import com.validation.AdminLoginValidationImpl;

public class AdminLoginServiceImpl implements AdminLoginService {
	private String result;

	@Override
	public String adminLoginService(String username, String password) {
		try {
			AdminLoginValidationImpl adminLoginValidationImpl = new AdminLoginValidationImpl();
		result = adminLoginValidationImpl.adminLoginValidation(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			result="SEVICE ERROR";
		}
		
		return result;
	}

	@Override
	public String adminLoginService2(String username, String password) {
		try {
			AdminLoginDaoimpl adminLoginDaoimpl = new AdminLoginDaoimpl();
			 result=adminLoginDaoimpl.checkAdminLoginData(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			result="SEVICE ERROR";
		}
		
		return result;
	}
	}


