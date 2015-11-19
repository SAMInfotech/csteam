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
            <img alt="sanjeev" src="image/wecare1.jpg" height="100" width="200">
        </div>
        <div>
            <div id="left">
                <h3><a href="home.jsp">Home</a></h3>
              <h3> <a href="login.jsp">Login</a></h3>
              <h3> <a href="patient.jsp">PatientSignUp</a></h3>
               <h3> <a href="doctor.jsp">DoctorSignUp</a></h3>
            </div>
            <div id="content">
            
               <h1>Registration Form</h1>
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	%>
                	<font style="color: red;" ><%=msg %></font>
                <%}
                %>
               <form action="Registration" method="get">
               <table>
               <tr>
               <td>UserID:</td><td><input type="text" name="uid"></td>
               </tr>
                <tr>
               <td>Password:</td><td><input type="password" name="pass"></td>
               </tr>
               <tr>
               <td>Name:</td><td><input type="text" name="name"></td>
               </tr>
                <tr>
               <td>Gender:</td><td><input type="radio" name="gender" value="Male">Male
               <input type="radio" name="gender" value="Female">Female
               </td>
               </tr>
                <tr>
               <td>City:</td><td> <select name="city">
               <option>Bangalore</option>
               <option>Chandigarh</option>
               <option>Hyderabad</option>
               <option>Delhi</option>
               </select>
               </td>
               </tr>
               <tr>
               <td colspan="2"><input type="submit" value="SignUp"></td>
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