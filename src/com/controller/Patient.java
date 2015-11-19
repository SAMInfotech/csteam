package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.DAO;

@WebServlet("/Patient")
public class Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String city=request.getParameter("city");
		String contact=request.getParameter("contact");
		String qualification=request.getParameter("qualification");
		String bloodPressure=request.getParameter("bloodPressure");
		String occupation=request.getParameter("occupation");
		String bloodSugar=request.getParameter("bloodPressure");
		String bloodGroup=request.getParameter("bloodGroup");
		String weight=request.getParameter("weight");
		String height=request.getParameter("height");
		String resource="patient.jsp";
		String message=null;
		
		
		
			
			try{
				SimpleDateFormat sf=new SimpleDateFormat("MM/dd/yyyy");
				Date d1=new Date();
				d1=sf.parse(dob);
				com.model.Patient patient=new com.model.Patient();
				patient.setUserid(uid);
				patient.setPassword(pass);
				patient.setName(name);
				patient.setAddress(address);
				patient.setGender(gender);
				patient.setDob(d1);
				patient.setCity(city);
				patient.setContact(contact);
				patient.setQualification(qualification);
				patient.setBloodPressure(bloodPressure);
				patient.setOccupation(occupation);
				patient.setBloodSugar(bloodSugar);
				patient.setBloodGroup(bloodGroup);
				patient.setWeight(weight);
				patient.setHeight(height);
				patient.setType("patient");
				DAO d=new DAO();
				d.savePatient(patient);
				resource="login.jsp";
				message="Registered Successfully Please Login";
				
			}
			catch(Exception e){
				message=e.getMessage();
			}
			request.setAttribute("msg", message);
			RequestDispatcher rd=request.getRequestDispatcher(resource);
			rd.forward(request, response);
			
	}

}
