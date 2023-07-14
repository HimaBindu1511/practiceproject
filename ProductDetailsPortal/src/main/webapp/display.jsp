<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border = 4 align = left>
		<tr>
			<th>ID</th>
			<td><%=session.getAttribute("id") %></td>
		</tr>
		<tr>
			<th>Product Name</th>
			<td><%=session.getAttribute("pname") %></td>
		</tr>
		<tr>
			<th>Product Price</th>
			<td><%=session.getAttribute("pprice") %></td>
		</tr>
	</table>

</body>
</html>