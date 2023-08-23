<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ForgetPasswordCtl" method="post">

	<%
		String password = (String) request.getAttribute("password");
	%>
	<table>
	<tr>
	<%
	if(password!=null){ 
	%>
	<h1><font color="red">
	<%=password%></font></h1>
	<%
	}
	%>
	</tr>
	<tr>
	<th>LoginId:-</th>
	<td><input type="text"name ="loginId"></td>
	</tr>
	<tr>
	<th></th>
	<td><input type ="submit"value="search"></td>
	</tr>
	
	</form>
	</table>
</body>
</html>