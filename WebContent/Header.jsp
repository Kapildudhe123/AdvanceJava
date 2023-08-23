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
		UserBean bean = (UserBean) session.getAttribute("user");
	%>

	<%
		if (bean != null) {
	%>
	<h3><font color="blue">
		Hii,
		<%=bean.getFirstName()%></font></h3>
		<a href="UserListCtl">*UserList</a>
		<a href="MarksheetListCtl">*MarksheetList</a>
		<a href= "StudentListCtl">*StudentList</a>
		<a href="LoginCtl?operation=Logout">*Logout</a>
		
	<%
		} else {
	%>
	<h3><font color="blue">Hi,Guest</font></h3>

	<%
		}
	%>
	
	<hr>

</body>
</html>