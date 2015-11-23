<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/loginauth.js"></script>
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
            <div id="content">
                <h1>Login Form</h1>
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	%>
                	<font style="color: red;" ><%=msg %></font>
                <%}
                %>
                <form action="Login" method="get" name="login">
                <table>
                <tr>
                <td>UserID:</td><td><input type="text" name="uid"></td>
                </tr>
                <tr>
                <td>Password:</td><td><input type="password" name="pass"></td>
                </tr>
                <tr>
                <td colspan="2" align="center"><input type="image" src="image/login.png" onclick="return auth()"></td>
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