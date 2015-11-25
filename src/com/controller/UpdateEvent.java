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
import com.model.Event;
import com.model.User;

/**
 * Servlet implementation class UpdateEvent
 */
@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEvent() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eventId=Integer.parseInt(request.getParameter("id"));
		String eventName = request.getParameter("eventName");
		String eventDescription = request.getParameter("eventDescription");
		String eventDate = request.getParameter("eventTime");
		
		String eventVenue = request.getParameter("eventVenue");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		String resource = "viewevents.jsp";
		String message = null;
		//System.out.println(eventDate);
		// Setting value in the Event class
		try {
			ArrayList<Event> eventList=new ArrayList<Event>();
			Event event = new Event();
			event.setEventId(eventId);
			event.setEventName(eventName);
			event.setEventDescription(eventDescription);
			event.setEventTime(eventDate);
			event.setEventVenue(eventVenue);
			event.setCreatedById(user.getUserId());


		     DAO dao=new DAO();
		     
		    eventList=dao.updateEvent(event);
		    
		    //System.out.println(eventList.size());
		    request.setAttribute("eventList", eventList);
		    RequestDispatcher rd = request.getRequestDispatcher(resource);
			rd.forward(request, response);
		} catch (Exception e) {
			message = e.getMessage();
           System.out.println(message);

		}
		
		
	}
		
		
	}


