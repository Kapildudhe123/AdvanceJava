<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<%@include file="Header.jsp"%>
	<%
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<form action="">
		<table border="1">

			<tr>
				<th><font color="blue">First_Name</font></th>
				<th><font color="blue">Last_Name</font></th>
				<th><font color="blue">Dob</font></th>
				<th><font color="blue">Mobile_no</font></th>
				<th><font color="blue">Email</font></th>
				<th><font color="blue">College_id</font></th>
				<th><font color="blue">College_Name</font></th>
			</tr>

			<%
				while (it.hasNext()) {
					StudentBean be = (StudentBean) it.next();
				
			%>
			<tr>
			<td><%=be.getFirst_Name()%></td>
			<td><%=be.getLast_Name() %></td>
			<td><%=be.getDob() %></td>
			<td><%=be.getMobile_No() %></td>
			<td><%=be.getEmail() %></td>
			<td><%=be.getCollege_id() %></td>
			<td><%=be.getCollge_Name() %></td>
					
		<%
		} 
		%>
		</table>
	</form>
</center>
</body>
</html>