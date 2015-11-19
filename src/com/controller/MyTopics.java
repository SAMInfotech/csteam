package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DAO;
import com.model.Topic;
import com.model.User;

/**
 * Servlet implementation class MyTopics
 */
@WebServlet("/MyTopics")
public class MyTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String message=null;
		String resource="welcome.jsp";
					
		try{
			DAO d=new DAO();
			ArrayList<Topic> topiclist1=d.myTopic(user.getUserId());
			request.setAttribute("topiclist",topiclist1);
			resource="mytopic.jsp";
				
		}
		catch(Exception e)
		{
			message=e.getMessage();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(resource);
		request.setAttribute("msg",message);
		rd.forward(request,response);
		}
	

}
