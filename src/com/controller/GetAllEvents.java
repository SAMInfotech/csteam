package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.DAO;
import com.model.Event;

/**
 * Servlet implementation class GetAllEvents
 */
@WebServlet("/GetAllEvents")
public class GetAllEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		ArrayList<Event> eventList=new ArrayList<Event>();
		eventList=dao.getAllEvents();
		//System.out.println(eventlist.size());
		request.setAttribute("eventList", eventList);
		
		request.getRequestDispatcher("viewevents.jsp").forward(request,response );
	}

	

}
