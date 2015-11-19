package com.data;

import com.model.Patient;
import com.model.Topic;
import com.model.User;
import java.sql.*;
import java.util.ArrayList;
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

}