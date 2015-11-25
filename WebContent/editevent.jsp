<%@page import="com.model.Event"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.datetimepicker.js"></script>
<LINK href="css/jquery.datetimepicker.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">

$(document).ready(function(){	
	$('#datepicker').datetimepicker({
		timepicker:true,
		format:'d/m/Y H:i'
	});
});

</script>
</head>
<body>
<div id="top">
            
        </div>
        <div>
            <div id="left">
           
              <h3> <a href="#">List Topics</a></h3>
               <h3><a href="#">Search Topic</a></h3>
              <h3> <a href="MyTopics">My Topics</a></h3>
               <h3> <a href="addtopic.jsp">Add Topic</a></h3>
               <h3> <a href="addevent.jsp">Add Event</a></h3>
                <h3> <a href="#">Sign Out</a></h3>
            </div>
            <div id="content" align="center">
            <h1>Edit Event</h1>
                <%
                Event event=(Event)request.getAttribute("eventList");
                
                %>
                <form action="UpdateEvent" method="post" >
                <table>
                <input type="hidden" name="id" value="<%=event.getEventId()%>">
                <tr>
                <td>Event Name:</td><td><input type="text" name="eventName" value="<%=event.getEventName()%>"></td>
                </tr>
                <tr>
                <td>Description:</td><td> <textarea rows="3" cols="15" name="eventDescription" ><%=event.getEventDescription()%></textarea> </td>
                </tr>
                <tr><td>Event Time:</td><td><input type="text" name="eventTime" id="datepicker" value="<%=event.getEventTime()%>"></td></tr>
                <tr><td>Event Venue:</td><td><input type="text" name="eventVenue"value="<%=event.getEventVenue()%>"></tr>
                <tr></tr>
                <tr>
                <td colspan="2" align="center"><input type="image" src="image/addevent.png" onclick="return auth()"></td>
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