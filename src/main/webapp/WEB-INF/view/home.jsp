<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		<h3>
			<a href="employeeForm">New Employee</a>
		</h3>
		<table border="1">
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="/getEmployee/${employee.id}">Edit</a> <a
						href="/deleteEmployee/${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
			<tr colspan="6" align="center">
			<c:forEach begin="${currentPage}" end="${totalPages}" var="p">
      <a href="page/${p}">${p}</a> 
    </c:forEach>
    </tr>
		</table>
	</div>
</body>
</html>
