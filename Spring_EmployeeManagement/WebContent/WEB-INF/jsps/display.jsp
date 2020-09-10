<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<core:if test="${not empty employee_list }">
	<table border="1">
		<tr>
			<td>Employee ID</td>
			<td>Employee Name</td>
			<td>Employee Salary</td>
			<td>Employee Technology</td>
		</tr>
		<core:forEach items="${employee_list}" var="data">
			<tr>
				<td>${data.empId }</td>
				<td>${data.name }</td>
				<td>${data.salary }</td>
				<td>${data.technology }</td>
			</tr>
		</core:forEach>
	</table>
</core:if>
	<core:if test="${empty employee_list }">
		<core:out value="Employee Not Found">
		</core:out>
	</core:if>
	${emp_name }
</body>
</html>