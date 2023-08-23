<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>
	<center>
		</head>

		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<form action="UserCtl" method="post">
			<table>

		<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>

				<h1>
					<font color="blue">STUDENT REGISTRATION FORM</font>
				</h1>
				<tr>
					<th style="color: red;">FirstName:-</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th><font color="red">LastName:-</font></th>
					<td><input type="text" name=lastName></td>
				</tr>
				<tr>
					<th style="color: red;">LoginId:-</th>
					<td><input type="text" name=loginId></td>
				</tr>
				<tr>
					<th style="color: red;">password:-</th>
					<td><input type="text" name=password></td>
				</tr>
				<tr>
					<th style="color: red;">dob:-</th>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<th style="color: red;">address:-</th>
					<td><input type="text" name=address></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignUp">
						<input type="submit" name="operation" value="Reset"></td>
				</tr>
			</table>
		</form>
</body>
</center>
</html>