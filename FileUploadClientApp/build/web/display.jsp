<%-- 
    Document   : display
    Created on : 27 Mar, 2021, 4:15:30 PM
    Author     : shelc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
 <%@ page import="java.io.*"%>
 <%@ page import="java.sql.*"%>
 <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
 <%@ page import="javax.servlet.*"%>
 <%@ page import="javax.servlet.http.*"%>
 <%@ page import="javax.servlet.http.HttpSession"%>
 <%@ page language="java"%>
 <%@ page session="true"%>
 <%@ page import="java.sql.*"%>
<% 
Blob image = null;
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String iurl1=null;

try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagedatadb?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false","","");
stmt = con.createStatement();
rs = stmt.executeQuery("select * from imagefiles where id = 1");%>
<table border="2">
<tr><th>DISPLAYING IMAGE</th></tr>
<tr><td>Image 2</td></tr>
<tr><td>
<%while(rs.next()){%>
 <img src="<%=rs.getString("image") %>" width="500" height="500"/>
 <%}%>
</td></tr>
</table>
<%}
catch (Exception e) {
out.println("DB problem"); 
return;
}
finally {
try {
rs.close();
stmt.close();
con.close();
}
catch (SQLException e) {
e.printStackTrace();
}
}
%>
</body>
</html>
