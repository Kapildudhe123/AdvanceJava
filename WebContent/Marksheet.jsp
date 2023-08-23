<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>
	<center>
		</head>

		<%
			String msg = (String) request.getAttribute("msg");
		%>

		<form action="MarksheetCtl" method="post">
			<table>
			
			<%
			if(msg!=null){
				%>
			<%=msg%>
					<%
					}
					%>
				<tr>
					<th>Name:-</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>Roll_No:-</th>
					<td><input type="text" name="rollNo"></td>
				</tr>
				<tr>
					<th>physisc:-</th>
					<td><input type="text" name="physisc"></td>
				</tr>
				<tr>
					<th>chemistry:-</th>
					<td><input type="text" name="chemistry"></td>
				</tr>
				<tr>
					<th>maths:-</th>
					<td><input type="text" name="maths"></td>
				</tr>
				<th></th>
				<th><input type="submit" name="operation" value="SignUp"> <input
					 type="submit" name="operation" value="Reset"></th>
				</tr>

			</table>

		</form>
</body>
</center>
</html>