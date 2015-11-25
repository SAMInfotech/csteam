<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.Event"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">
		function ConformToDelete() {
			// var cnf = confirm("Do you want to delete the record?"); 
			if (!confirm("Do you want to delete the record?"))
				return false;
		}
	</script>
</head>
<body>
<div id="top">
            
        </div>
        <div>
            <div id="left">
              <h3><a href="index.jsp">Home</a></h3>
              <h3> <a href="login.jsp">Login</a></h3>
              <h3> <a href="patient.jsp">UserSignUp</a></h3>
               <h3> <a href="doctor.jsp">DoctorSignUp</a></h3>
              
            </div>
            <div id="content" align="center">
            <h1>View Events</h1>
                
                <table border="1" width="100%" cellpadding="2" align="center">
		<TR>
		</TR>
		<TR BGCOLOR="#CCFF99">

			<TD width="50px" valign="top"><b>S.No</b></TD>
			<TD width="100px" valign="top"><b>Event Name</b></TD>
			<TD width="100px" valign="top"><b>Event Description</b></TD>
			<TD width="100px" valign="top"><b>Event DateTime</b></TD>
			<TD width="100px" valign="top"><b>Event Venue</b></TD>
			<TD width="100px" valign="top"><b>CreatedById</b></TD>
			<TD width="100px" valign="top"><b>Edit</b></TD>
			<TD width="100px" valign="top"><b>Delete</b></TD>

		</TR>
                
						
						
						<%
						int j = 1;
						int i=1;
							ArrayList<Event> eventlist=(ArrayList<Event>)request.getAttribute("eventList");

							if(eventlist.size()>0){
							for(Event event:eventlist){
								int id = event.getEventId(); 
								String url= response.encodeURL("EditEvents?id="+ event.getEventId() );

								 if (j % 2 == 0) {%>
								

							<tr align="left" class="Even">
							<%
								} else {
							%>

						</tr>
						<tr align="left" class="Odd">
							<%
								}
							%>


							<td><%=i++ %></td>


							<td><%=event.getEventName()%></td>
							<td><%=event.getEventDescription()%></td>
							<td><%=event.getEventTime()%></td>
							<td><%=event.getEventVenue()%></td>
							<td><%=event.getCreatedById()%></td>
							<td align="center"> <a href="<%= url  %>"> <img src="image/edit.png " width="30px"></img></a></td>
						<td align="center"> 
  <a href="DeleteEvent?id=<%= id %>" onclick="return ConformToDelete()" ><img src="image/4.png" width="30px" ></img></a> 
    </td> 

						</tr>

						<%
							j++;
							}}
						%>
						
							
											
				</table>			
						
            </div>
            
        </div>
        <div id="bottom" align="center">
            Copyright HEDX 2015
        </div>
</body>
</html>