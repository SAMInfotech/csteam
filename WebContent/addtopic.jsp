<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Topic</title>
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
               <h3> <a href="addtopic.jsp">Add Topic</h3>
                <h3> <a href="#">Sign Out</a></h3>
            </div>
            <div id="content" align="center">
                 <h1>Add Topic</h1>
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	%>
                	<font style="color:green;" ><%=msg %></font>
                <%}
                %>
                <form action="AddTopic" method="post" name="topic">
                <table>
                <tr>
                <td>Topic:</td><td><input type="text" name="topicName"></td>
                </tr>
                <tr>
                <td>Comment:</td><td> <textarea rows="3" cols="15" name="comment"></textarea> </td>
                </tr>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                <td colspan="2" align="center"><input type="image" src="image/addtopic.png" onclick="return auth()"></td>
                </tr>
                </table>
                        
                </form>
            </div>
        </div>
        <div id="bottom" align="center">
            Copyright HED-X 2015
        </div>
</body>
</html>