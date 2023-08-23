<%@page import="in.co.rays.bean.MarksheetBean"%>
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
		MarksheetBean bean = (MarksheetBean) request.getAttribute("bean");
	%>
	<form action="MarksheetCtl" method="post">
	<table>
	<tr>
	<td><input type="hidden"name="id" value="<%=bean.getId()%>"></td>
	</tr>
	<tr>
					<th>Name:-</th>
					<td><input type="text" name="name"value="<%=bean.getName()%>"></td>
				</tr>
				<tr>
					<th>Roll_No:-</th>
					<td><input type="text" name="rollNo"value="<%=bean.getRollNo()%>"></td>
				</tr>
				<tr>
					<th>physisc:-</th>
					<td><input type="text" name="physisc"value="<%=bean.getPhysisc()%>"></td>
				</tr>
				<tr>
					<th>chemistry:-</th>
					<td><input type="text" name="chemistry"value="<%=bean.getChemistry()%>"></td>
				</tr>
				<tr>
					<th>maths:-</th>
					<td><input type="text" name="maths"value="<%=bean.getMaths()%>"></td>
				</tr>
				<th></th>
				<th><input type="submit" name="operation" value="List"> <input
					 type="submit" name="operation" value="Update"></th>
				</tr>
	</table>
	</form>
</body>
</html>