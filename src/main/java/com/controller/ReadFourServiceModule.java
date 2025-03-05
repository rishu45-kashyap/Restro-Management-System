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


@WebServlet("/ReadFourServiceModule")
public class ReadFourServiceModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
		
		ServiceModuleserviceImpl serviceModuleserviceImpl = new ServiceModuleserviceImpl();
		ArrayList<ServiceModulePojo> arryList = serviceModuleserviceImpl.readFourService();
		session.setAttribute("check", "FROMSERVLET");

		if(arryList== null) {
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW ");
			response.sendRedirect("index.jsp");
		}
		else if(arryList.isEmpty()) 
		{
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("index.jsp");
			
			
		}
		else {
			String datetime = arryList.get(0).getDatetime();
			if (datetime.equals("ne")) {
				session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
				response.sendRedirect("index.jsp");
				
				
				
			}
			else {
				session.setAttribute("servicedata", arryList);
				response.sendRedirect("index.jsp");
				
			}
		}
		
	}

}
