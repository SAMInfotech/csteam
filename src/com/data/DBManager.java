package com.data;
import java.sql.*;
public class DBManager {
public static Connection getCon()throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/wecare","root","root");
}
}
