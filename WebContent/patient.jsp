<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
  <script type="text/javascript" src="js/doctorauth.js"></script>
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
            
               <h1>Signup Form</h1>
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	%>
                	<font style="color: red;" ><%=msg %></font>
                <%}
                %>
               <form action="Patient" method="post" name="patient">
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
               <td>Address:</td><td><textarea cols="15" rows="3" name="address"></textarea></td>
               </tr>
               <tr>
               <td>DOB:</td><td><input type="text" id="datepicker" name="dob"></td>
               </tr>
                <tr>
               <td>Gender:</td><td><input type="radio" name="gender" value="Male">Male
               <input type="radio" name="gender" value="Female">Female
               </td>
               </tr>
                <tr>
               <td>City:</td><td> <select name="city">
               <option value="">Select City</option>
               <option value="bangalore">Bangalore</option>
               <option value="chandigarh">Chandigarh</option>
               <option value="hyderbad">Hyderabad</option>
               <option value="delhi">Delhi</option>
               </select>
               </td>
               </tr>
               <tr>
               <td>Contact:</td><td><input type="text" name="contact"></td>
               </tr>
                <tr>
               <td>Qualification:</td><td><input type="text" name="qualification"></td>
               </tr>
                <tr>
               <td>BloodPressure:</td><td><input type="text" name="bloodPressure"></td>
               </tr>
                <tr>
               <td>Occupation:</td><td><input type="text" name="occupation"></td>
               </tr>
                <tr>
               <td>BloodSugar:</td><td><input type="text" name="bloodSugar"></td>
               </tr>
                <tr>
               <td>BloodGroup:</td><td><input type="text" name="bloodGroup"></td>
               </tr>
                <tr>
               <td>Weight:</td><td><input type="text" name="weight"></td>
               </tr>
                <tr>
               <td>Height:</td><td><input type="text" name="height"></td>
               </tr>
               <tr>
               <td colspan="2" align="center"><input type="image" src="image/signup.png" onclick="return auth()"></td>
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