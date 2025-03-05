package com.service;

import java.util.ArrayList;

import com.model.ServiceModulePojo;

public interface ServiceModuleservice {
	public String addService(String iconname, String title, String description);
	public String addService1(String iconname, String title, String description);
	public ArrayList<ServiceModulePojo> readService(); 
	public ArrayList<ServiceModulePojo> readFourService();
	public String  deleteService(String sn);



}
