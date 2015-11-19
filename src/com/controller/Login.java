package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DAO;
import com.model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String message=null;
		String resource="login.jsp";
		try{
				DAO d=new DAO();
				User user=d.getLogin(uid, pass);
				if(user.getType().equals("patient")){
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					resource="welcome.jsp";
				}
				else{
					message="Invalid User Type";
				}
			}
			catch(Exception e){
				message=e.getMessage();
			}
			
		request.setAttribute("msg", message);
		RequestDispatcher rd=request.getRequestDispatcher(resource);
		rd.forward(request, response);
		
	}

}
