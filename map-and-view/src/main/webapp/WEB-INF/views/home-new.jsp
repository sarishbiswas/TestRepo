<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 

<html>
<head>
<title>display data from the table using jsp</title>
</head>
<body>
<h2>Data from the table Employee</h2>
<%
try {
String connectionURL = "jdbc:mysql://localhost:3306/mydb";
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "");
statement = connection.createStatement();
String QueryString = "SELECT * from employee";
rs = statement.executeQuery(QueryString);
%>
<TABLE border="2">
<tr><th>ID</th>
<th>Name</th></tr>
<%
while (rs.next()) {
%>
<TR>
<TD><%=rs.getString(1)%></TD>
<TD><%=rs.getString(2)%></TD>
</TR>
<% } %>
<%
// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>
<%
out.println("Unable to connect to database.");
}
%>
</TABLE>
	<a href="insert"><input type="button" name="home"
						value="INSERT" /></a>
	<a href="update"><input type="button" name="home"
						value="UPDATE" /></a>
	<a href="delete"><input type="button" name="home"
						value="DELETE" /></a>
</body>
</html>