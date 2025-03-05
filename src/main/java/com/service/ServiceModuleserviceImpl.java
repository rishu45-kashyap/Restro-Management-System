package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ContactDaoImpl;
import com.dao.ServiceDaoImpl;
import com.model.ServiceModulePojo;
import com.validation.ServiceModuleValidationImpl;

public class ServiceModuleserviceImpl implements ServiceModuleservice {
    private String result;
	@Override
	public String addService(String iconname, String title, String description) {
		
		try {
			ServiceModuleValidationImpl serviceModuleValidationImpl = new ServiceModuleValidationImpl();
			result=serviceModuleValidationImpl.serviceModuleValidation(iconname, title, description);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	@Override
	public String addService1(String iconname, String title, String description) {
		
		try {
			 ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			 String datetime = LocalDateTime.now().toString();
			 result=serviceDaoImpl.saveService(iconname, title, description, datetime);
			
		} catch (Exception e) {
	       e.printStackTrace();
		}
		return result;
		
	}
	@Override
	public ArrayList<ServiceModulePojo> readService() {
		ArrayList<ServiceModulePojo> arrayList= null;
		try {
			 ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			 arrayList = serviceDaoImpl.readAllService();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return arrayList;
	}
	@Override
	public ArrayList<ServiceModulePojo> readFourService() {
		ArrayList<ServiceModulePojo> arrayList= null;
		try {
			 ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			 arrayList = serviceDaoImpl.readfourService();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return arrayList;
	}
	@Override
	public String deleteService(String sn) {
		
		try {

			int intsn = Integer.parseInt(sn);
			ServiceDaoImpl serviceDaoImpl = new ServiceDaoImpl();
			
			result = serviceDaoImpl.deleteService(intsn);
		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}

		return result;
	}

}
