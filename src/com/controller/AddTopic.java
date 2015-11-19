package com.controller;

import java.io.IOException;
import java.util.Date;

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
@WebServlet("/AddTopic")
public class AddTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String topicName=request.getParameter("topicName");
	String comment=request.getParameter("comment");
	HttpSession session=request.getSession();
	User user=(User)session.getAttribute("user");
	String resource="addtopic.jsp";
	String message=null;
	try {
		Topic topic=new Topic();
		topic.setTopicName(topicName);
		topic.setComment(comment);
		topic.setUserId(user.getUserId());
		topic.setTime(new Date());
		DAO d=new DAO();
		d.saveTopic(topic);
		message="Topic Added Successfully";
			
	} catch (Exception e) {
		message=e.getMessage();
	}
	request.setAttribute("msg",message);
	RequestDispatcher rd=request.getRequestDispatcher(resource);
	rd.forward(request, response);
	}

}
