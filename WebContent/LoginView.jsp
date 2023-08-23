


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
		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<form action="LoginCtl" method="post">

			<%@ include file="Header.jsp"%>
			<table>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>

				<tr>
					<th>LoginId:-</th>
					<td><input type "text" name="loginId">
				</tr>
				<tr>
					<th>Password:-</th>
					<td><input type "text" name="password">
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignIn">
						<input type="submit" name="operation" value="SignUp"></td>
						
						<td><a href="ForgetPasswordCtl">ForgetMyPassword</a></td>
						
				</tr>
			</table>

		</form>
	</center>
</body>
</html>

