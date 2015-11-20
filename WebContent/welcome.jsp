<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/styles.css">
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
               <h3> <a href="addtopic.jsp">Add Topic</a></h3>
                <h3> <a href="addevent.jsp">Add Event</a></h3>
                <h3> <a href="#">Sign Out</a></h3>
            </div>
            <div id="content">
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	%>
                	<font style="color: red;" ><%=msg %></font>
                <%}
                %>
                <marquee><img alt="sanjeev" src="image/wel1.jpg"></marquee>
               
               
            </div>
        </div>
        <div id="bottom" align="center">
            Copyright HED-X 2015
        </div>
</body>
</html>