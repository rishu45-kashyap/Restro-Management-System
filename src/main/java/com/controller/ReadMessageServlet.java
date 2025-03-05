package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ContactPojo;
import com.service.ContactServiceImpl;


@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session = request.getSession();
           
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		ArrayList<ContactPojo> arryList = contactServiceImpl.readContactService();
		
		if(arryList== null) {
			session.setAttribute("msg", "SOMETHING WENT WRONG : service layer");
			response.sendRedirect("admin.jsp");
		}
		else if(arryList.isEmpty()) 
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG : dao layer");
			response.sendRedirect("admin.jsp");
			
			
		}
		else {
			String datetime = arryList.get(0).getDatetime();
			if (datetime.equals("ne")) {
				session.setAttribute("msg", "DATA  DOES  NOT ESIST ");
				response.sendRedirect("admin.jsp");
				
				
				
			}
			else {
				session.setAttribute("contactdata", arryList);
				response.sendRedirect("readcontact.jsp");
				
			}
		}
		
		
	}

}
