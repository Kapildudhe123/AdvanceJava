<%@page import="in.co.rays.bean.UserBean"%>
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
	<center>
		<form action="UserListCtl" method="post">

			<%@ include file="Header.jsp"%>
			<%
				List list = (List) request.getAttribute("list");
				int pageNo = (int) request.getAttribute("pageNo");
				int nextListSize = (int) request.getAttribute("nextListSize");
				int index = ((pageNo - 1) * 5) + 1;
				Iterator it = list.iterator();
			%>
			<table>
				<tr>
					<th></th>
					<th><font color="red">Dob:-	</font></th>
					<td><input type="text" name="dob"></td>
					<th><font color="red">firstName:-	</font></th>
					<td><input type="text" name="firstName"></td>
					<td><input type="submit" name="operation" value="search"></td>
			</tr>
			</table>
			<table border="1">
				<tr>
					<th><font color="orange">Select</font></thh>
					<th><font color="orange">S.No</font></th>
					<th><font color="orange">FirstName</font></th>
					<th><font color="orange">LastName</font></th>
					<th><font color="orange">LoginId</font></th>
					<th><font color="orange">Password</font></th>
					<th><font color="orange">Dob</font></th>
					<th><font color="orange">Address</font></th>
					<th><font color="orange">Edit</font></th>


				</tr>
				<%
					while (it.hasNext()) {
						bean = (UserBean) it.next();
				%>

				<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getAddress()%></td>
					<td><a href="UserCtl?id=<%=bean.getId()%>">edit</a></td>

				</tr>
				<%
					}
				%>
			</table>
			<table>
				<tr>
					<td><input type="hidden" name="pageNo" value="<%=pageNo%>"></td>
					<td><input type="submit" name="operation" value="previous"
						<%=(pageNo != 1) ? "" : "disabled"%>>
						
						<input type="submit" name="operation" value="delete"></td>
						
					<td><input type="submit" name="operation" value="next"
						<%=(nextListSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>