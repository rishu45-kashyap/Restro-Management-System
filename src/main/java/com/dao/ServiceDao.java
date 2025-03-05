package com.dao;

import java.util.ArrayList;

import com.model.ServiceModulePojo;

public interface ServiceDao {
	public String saveService(String iconname,String title,String description , String daetime);
	public String readAllService(String iconname,String title,String description , String daetime);
	  public ArrayList<ServiceModulePojo> readAllService();
	  public ArrayList<ServiceModulePojo> readfourService();

	  public String deleteService(int sn);
}
