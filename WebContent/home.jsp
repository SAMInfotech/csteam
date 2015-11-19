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
              <h3><a href="home.jsp">Home</a></h3>
              <h3> <a href="login.jsp">Login</a></h3>
              <h3> <a href="patient.jsp">UserSignUp</a></h3>
               <h3> <a href="doctor.jsp">DoctorSignUp</a></h3>
            </div>
            <div id="content" align="center">
                <p>
               <h3 style="color: blue;">
               
                Spread awareness about the various and most harmful diseases which can affect human. A platform for medical practitioners to engage in community awareness and education programs. Knowledge of measures that can be taken to prevent life threatening diseases that can lead to the enormous decrease in the number of victims. Early diagnosis and treatment can help cure the disease easily.</h3>
                </p>
                <marquee  onmouseover="this.stop()" onmouseout="this.start()" direction="up" scrolldelay="300">
						<%-- <%
						
							try{
							ArrayList<Event> eventlist=DAO.getEvent();
							if(eventlist.size()>0){
							for(Event event:eventlist){
								 %>
								 <font style="color: blue;"><a href="#"><%=event.getEventname()%></a></font><br>
								 When:<%=event.getDate() %><br>
			             
			            	where:<%=event.getEvedisc()%><br>
							<%}
							}else
								{
								out.print("no events");
								}
							
							}catch(Exception e)
							{
							out.print(e);	
							}
							%> --%>
							<h3 style="color: green;background-color: white;text-align: center;">Eyes Camp <br> when: 20,Dec 2015 2:00 PM to 6PM <br>Where : HSR Layout</h3>
											
							</marquee>
            </div>
        </div>
        <div id="bottom" align="center">
            Copyright HEDX 2015
        </div>
</body>
</html>