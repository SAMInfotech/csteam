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
 * Servlet implementation class GetEventDetails
 */
@WebServlet("/GetEventDetails")
public class GetEventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventDetails() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao=new DAO();
		ArrayList<Event> eventlist=new ArrayList<Event>();
		eventlist=dao.getEventDetails();
		//System.out.println(eventlist.size());
		request.setAttribute("eventlist", eventlist);
		
		request.getRequestDispatcher("home.jsp").forward(request,response );
	
		
		
	}

}
