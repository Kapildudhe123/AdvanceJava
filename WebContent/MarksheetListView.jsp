<%@page import="in.co.rays.bean.MarksheetBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style>
</style>
	<center>
		<form action="MarksheetListCtl" method="post">

			<%@include file="Header.jsp"%>
			<%
				List list = (List) request.getAttribute("list");
				int pageNo = (int) request.getAttribute("pageNo");
				int nextListSize = (int) request.getAttribute("nextListSize");
				
				int index=((pageNo-1)*5) + 1;

				Iterator it = list.iterator();
			%>
			<table>
				<tr>
					<td><input type="text" name="name"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
			<table border="1">
				<tr>
					<th><font color="red">Select</font></th>
					<th><font color="red">Id</font></th>
					<th><font color="red">Name</font></th>
					<th><font color="red">Roll_No</font></th>
					<th><font color="red">Physisc</font></th>
					<th><font color="red">Chemistry</font></th>
					<th><font color="red">Maths</font></th>
					<th><font color="red">EDIT</font></th>
				</tr>

				<%
					//MarksheetBean bea;
					while (it.hasNext()) {
						MarksheetBean bea = (MarksheetBean) it.next();
						//bean=(MarksheetBean)it.next();
				%>

				<tr>
				<td><input type="checkbox" name="ids" value="<%=bea.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bea.getName()%></td>
					<td><%=bea.getRollNo()%></td>
					<td><%=bea.getPhysisc()%></td>
					<td><%=bea.getChemistry()%></td>
					<td><%=bea.getMaths()%></td>
					<td><a href="MarksheetCtl?id=<%=bea.getId()%>">edit</a></td>


				</tr>
				<%
					}
				%>
				<table>
					<tr>
						<th></th>
						<td><input type="hidden" name="pageNo" value="<%=pageNo%>"></td>
						<td><input type="submit" name="operation" value="previous"
							<%=(pageNo != 1) ? " " : "disabled"%>></td>
							
							<td><input type="submit" name="operation" value="delete"></td>
							
						<td><input type="submit" name="operation" value="next"
							<%=(nextListSize != 0) ? "" : "disabled"%>></td>
					</tr>
				</table>
			</table>
		</form>
	</center>
</body>
</html>