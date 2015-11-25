package com.data;

import com.model.Event;
import com.model.Patient;
import com.model.Topic;
import com.model.User;







import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class DAO {
	public void savePatient(Patient p)throws Exception
	{
		Connection con=DBManager.getCon();
		PreparedStatement st1=con.prepareStatement("select * from login where userId=?");
		st1.setString(1,p.getUserid());
		ResultSet rs=st1.executeQuery();
		if(rs.next()){
			throw new Exception("userid already exists");
		}
		else{
		PreparedStatement st=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		
		PreparedStatement stm=con.prepareStatement("insert login(userid,password,name,type) values(?,?,?,?)");
		stm.setString(1, p.getUserid());
		stm.setString(2, p.getPassword());
		stm.setString(3, p.getName());
		stm.setString(4, p.getType());
		
		st.setString(1,p.getUserid() );
		st.setString(2,p.getPassword());
		st.setString(3,p.getName());
		st.setString(4,p.getAddress());
		st.setTimestamp(5, new java.sql.Timestamp(p.getDob().getTime()));
		st.setString(6,p.getGender());
		st.setString(7,p.getCity());
		st.setString(8,p.getContact());
		st.setString(9,p.getQualification());
		st.setString(10,p.getBloodPressure());
		st.setString(11,p.getOccupation());
		st.setString(12,p.getBloodSugar());
		st.setString(13,p.getBloodGroup());
		st.setString(14,p.getWeight());
		st.setString(15,p.getHeight());
		
		int m=stm.executeUpdate();
		int result=st.executeUpdate();
		if(result!=1)
		{
			throw new Exception("Data not inserted");
		}
		}
	}
	public User getLogin(String uid,String pass)throws Exception{
		Connection con=DBManager.getCon();
		User user=null;
		PreparedStatement st=con.prepareStatement("select * from login where userid=? and password=?");
		st.setString(1,uid);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			user=new User();
			user.setUserId(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setName(rs.getString(3));
			user.setType(rs.getString(4));
		}
		else{
			throw new Exception("Wrong userid or Password");
		}
		return user;
	}
	public void saveTopic(Topic topic)throws Exception{
		Connection con=DBManager.getCon();
		PreparedStatement st=con.prepareStatement("insert topic(topicname,comment,userid,time) values(?,?,?,?);");
		st.setString(1,topic.getTopicName());
		st.setString(2, topic.getComment());
		st.setString(3, topic.getUserId());
		st.setTimestamp(4,new java.sql.Timestamp(topic.getTime().getTime()));
		int result=st.executeUpdate();
		if(result!=1)
		{
			throw new Exception("Data not inserted");
		}
		}
	public ArrayList<Topic> myTopic(String userid)throws Exception
	{

		Connection con=DBManager.getCon();		
		ArrayList<Topic> topiclist=new ArrayList<>();
		PreparedStatement st=con.prepareStatement("select * from topic where userid=? order by time desc");
		st.setString(1,userid);
		ResultSet rs=st.executeQuery();
		while(rs.next()){	
			Topic topic=new Topic();
			topic.setTopicid(rs.getInt(1));
			topic.setTopicName(rs.getString(2));
			topic.setComment(rs.getString(3));
			topic.setUserId(rs.getString(4));
			topic.setTime(rs.getTimestamp(5));
			topiclist.add(topic);						
			}
		return topiclist;
	}
	public void saveEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
		
		Connection con=DBManager.getCon();
		PreparedStatement st=con.prepareStatement("insert into event(eventName,eventDescription,eventTime,eventVenue,createdById) values(?,?,?,?,?);");
		st.setString(1, event.getEventName());
		st.setString(2, event.getEventDescription());
		DateFormat sqlDateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		Date cdate = null;
		try { 
			cdate = (event.getEventTime() != null && !event.getEventTime().trim()
					.isEmpty()) ? sqlDateFormatter.parse(event.getEventTime())
					: new Date();
					
				
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		st.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cdate));
		st.setString(4, event.getEventVenue());
		st.setString(5, event.getCreatedById());
		int result=st.executeUpdate();
		if(result!=1)
		{
			throw new Exception("Data not inserted");
		}
		}
		
		
		public ArrayList<Event> getEventDetails(){
			ArrayList<Event> list=new ArrayList<Event>();
			Event event=null;
			try {
				Connection con=DBManager.getCon();
				PreparedStatement ps=con.prepareStatement("SELECT * FROM EVENT ORDER BY eventid DESC LIMIT 5;");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					event=new Event();
					event.setEventId(rs.getInt("eventId"));
					event.setEventName(rs.getString("eventName"));
					event.setEventDescription(rs.getString("eventDescription"));
					event.setEventTime(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("eventTime")));
					event.setEventVenue(rs.getString("eventVenue"));
					event.setCreatedById(rs.getString("createdById"));
				    list.add(event);
				}
			} catch (Exception se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
				System.out.println("Hi");
				
			}	
			return list;
		}
		public ArrayList<Event> getAllEvents() {
			ArrayList<Event> list=new ArrayList<Event>();
			Event event=null;
			try {
				Connection con=DBManager.getCon();
				PreparedStatement ps=con.prepareStatement("SELECT * FROM EVENT;");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					event=new Event();
					event.setEventId(rs.getInt("eventId"));
					event.setEventName(rs.getString("eventName"));
					event.setEventDescription(rs.getString("eventDescription"));
					event.setEventTime(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("eventTime")));
					event.setEventVenue(rs.getString("eventVenue"));
					event.setCreatedById(rs.getString("createdById"));
				    list.add(event);
				}
			} catch (Exception se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
				System.out.println("Hi");
				
			}	
			return list;
			
		}
		public Event editEventDetails(int eventId) {
			Event event=null;
			try {
				Connection con=DBManager.getCon();
				PreparedStatement ps=con.prepareStatement("SELECT * FROM EVENT WHERE eventId=?;");
				ps.setInt(1, eventId);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					event=new Event();
					event.setEventId(rs.getInt("eventId"));
					event.setEventName(rs.getString("eventName"));
					event.setEventDescription(rs.getString("eventDescription"));
					event.setEventTime(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getTimestamp("eventTime")));
					event.setEventVenue(rs.getString("eventVenue"));
					event.setCreatedById(rs.getString("createdById"));
				   
				}
			} catch (Exception se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
				System.out.println("Hi");
				
			}	
			return event;
			
		}
		public ArrayList<Event> updateEvent(Event event) {
			// TODO Auto-generated method stub
			System.out.println("Hi");
			ArrayList<Event> list=new ArrayList<Event>();
			try {
				Connection con;
				con = DBManager.getCon();
				PreparedStatement st;
				st = con.prepareStatement("Update event set eventName=?,eventDescription=?,eventTime=?,eventVenue=?,createdById=? where eventId=?;");
				st.setString(1, event.getEventName());
				st.setString(2, event.getEventDescription());
				DateFormat sqlDateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
				Date cdate = null;
				try { 
					cdate = (event.getEventTime() != null && !event.getEventTime().trim()
							.isEmpty()) ? sqlDateFormatter.parse(event.getEventTime())
							: new Date();
							
						
							
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					e.getMessage();
				}
				st.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cdate));
				st.setString(4, event.getEventVenue());
				st.setString(5, event.getCreatedById());
				st.setInt(6, event.getEventId());
				int result=st.executeUpdate();
				
				if(result>0)
				{
					list=getAllEvents();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				
			}
			return list;
		}
		
		
		

}
