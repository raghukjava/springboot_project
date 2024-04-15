<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
  function handleClick()
  {
     
       document.getElementById('myForm').action= "/saveEmployee";
     
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Employee</h1>
		
		<form:form id="myForm" action="/saveEmployee" method="post"
			modelAttribute="employee">
			
			
			
			
			
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><form:input path="telephone" /></td>
				</tr>
				<tr>
					<c:choose>

						<c:when test="${'EDIT' eq Mode}">
							<td colspan="2" align="center"><input type="submit"
								value="Update"></td>
						</c:when>

						<c:otherwise>
							<td colspan="2" align="center"><input type="submit"
								value="Save"></td>
						</c:otherwise>
					</c:choose>

				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>






