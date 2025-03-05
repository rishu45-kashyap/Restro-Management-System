package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ServiceModulePojo;
import com.service.ServiceModuleserviceImpl;


@WebServlet("/ReadServiceDeleteUpdateModule")
public class ReadServiceDeleteUpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 private String result;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServiceModuleserviceImpl serviceModuleserviceImpl = new ServiceModuleserviceImpl();
		ArrayList<ServiceModulePojo> arryList = serviceModuleserviceImpl.readService();
		if(arryList== null) {
			session.setAttribute("msg", "SOMETHING WENT WRONG : service layer");
			response.sendRedirect("readservice.jsp");
		}
		else if(arryList.isEmpty()) 
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG : dao layer");
			response.sendRedirect("readservice.jsp");
			
			
		}
		else {
			String datetime = arryList.get(0).getDatetime();
			if (datetime.equals("ne")) {
				session.setAttribute("msg", "DATA  DOES  NOT EXIST ");
				response.sendRedirect("readservice.jsp");
				
				
				
			}
			else {
				session.setAttribute("servicedata", arryList);
				response.sendRedirect("readservice.jsp");
				
			}
		}
		
	}

}
