<%@page import="com.model.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="top">
            
        </div>
        <div>
            <div id="left">
            <%
            User user=(User)session.getAttribute("user");
            %>
            	<h2>Hello !<%=user.getName() %></h2>
              <h3> <a href="#">List Topics</a></h3>
               <h3><a href="#">Search Topic</a></h3>
              <h3> <a href="MyTopics">My Topics</a></h3>
               <h3> <a href="addtopic.jsp">Add Topic</h3>
                <h3> <a href="#">Sign Out</a></h3>
            </div>
            <div id="content">
                
                <% ArrayList<Topic> topiclist= (ArrayList<Topic>)request.getAttribute("topiclist");
    			int i=1;
					if(topiclist.size()>0)
					{
					%>
						<h1>Here are your topics </h1>
						<table id="box-table-a" border='2'>
						<tr>
						<th>Sr No</th>
						<th>Topic Name</th>
						<th>Comment</th>
						<th>User Id</th>
						<th>Comment Date</th>
						<th>Delete</th>
						<th>Edit</th>
						</tr>
					<tr>
					<%for(Topic t:topiclist){	
					%>   
					<td><%=i++%> </td> 	
					<td><%=t.getTopicName()%></td>
					<td><%=t.getComment()%></td>
					<td><%=t.getUserId()%></td>
					<td><%=t.getTime()%></td>
					<td>
						<form action="DeleteTopic" method="get">
						<input type="hidden" name="tid" value="<%=t.getTopicid()%>">
						<input type="submit" value="delete">
						</form>
					</td>
					
					<td>
					<form action="EditTopic" method="get">
					<input type="hidden" name="tid" value="<%=t.getTopicid() %>">
					<input type="hidden" name="comment" value="<%=t.getComment() %>">
					<input type="submit" value="edit">	
					</form>
					</td>
					</tr>	
					<%}%>
					</table>		
				<%}
				else 
				{%>
					<h3>Sorry there are no topics in your list..want to add topic click <a href="addtopic.jsp">here</a></h3> 
				<%}%>
               
               
            </div>
        </div>
        <div id="bottom" align="center">
            Copyright HED-X 2015
        </div>
</body>
</html>