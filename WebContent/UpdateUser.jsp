<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<form action="UserCtl" method="post">

		<table>
			<tr>
				<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
			</tr>
			<tr>
				<th>FirstName:-</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstName()%>"></td>
					</tr>
					<tr>
				<th>lastName:-</th>
				<td><input type="text" name="lastName"
					value="<%=bean.getLastName()%>"></td>
			</tr>
			<tr>
				<th>LoginId:-</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginId()%>"></td>
			</tr>
			<tr>
				<th>Pasword:-</th>
				<td><input type="text" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>
			<tr>
				<th>Dob:-</th>
				<td><input type="text" name="dob" value="<%=bean.getDob()%>"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					value="<%=bean.getAddress()%>"></td>
			</tr>
			<tr>
				
			<th></th>
				<td><input type="submit" name="operation" value="Update">
					<input type="submit" name="operation" value="List"></td>
					</tr>
		</table>

	</form>
</body>
</html>