package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.DAO;
import com.model.Event;
import com.model.User;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Getting value from addevent.jsp
		String eventName = request.getParameter("eventName");
		String eventDescription = request.getParameter("eventDescription");
		String eventDate = request.getParameter("eventTime");
		
		String eventVenue = request.getParameter("eventVenue");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String resource = "addevent.jsp";
		String message = null;
		System.out.println(eventDate);
		// Setting value in the Event class
		try {
			Event event = new Event();
			event.setEventName(eventName);
			event.setEventDescription(eventDescription);
			event.setEventTime(eventDate);
			event.setEventVenue(eventVenue);
			event.setCreatedById(user.getUserId());
			
		     DAO dao=new DAO();
		     dao.saveEvent(event);
			message = "Event Added Successfully";

		} catch (Exception e) {
			message = e.getMessage();
		}
		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		rd.forward(request, response);
	}

}
