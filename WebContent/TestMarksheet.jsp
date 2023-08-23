<%@page import="in.co.rays.model.MarksheetModel"%>
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
	
		String name = request.getParameter("name");
		int rollno = Integer.parseInt(request.getParameter("rollNo"));
		int physisc = Integer.parseInt(request.getParameter("physisc"));
		int chemistry = Integer.parseInt(request.getParameter("chemistry"));
		int maths = Integer.parseInt(request.getParameter("maths"));

		MarksheetBean bean = new MarksheetBean();
		//bean.setId(id);
		bean.setName(name);
		bean.setRollNo(rollno);
		bean.setPhysisc(physisc);
		bean.setChemistry(chemistry);
		bean.setMaths(maths);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	%>
	<h1><%=name%></h1>
	<h1><%=rollno%></h1>
	<h1><%=physisc%></h1>
	<h1><%=chemistry%></h1>
	<h1><%=maths%></h1>
</body>
</html>