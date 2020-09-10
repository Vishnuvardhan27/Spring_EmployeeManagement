<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Please Provide The Information of an Employee<br>
	<form:form modelAttribute="employee" method="POST" action="addEmployee_valid.htm">
	
	Name of the Employee <form:input path="name" size="30"/>
								<font color="red"><form:errors path="name" /></font>
								<br>
	Employee ID <form:input path="empId" size="30"/>
								<font color="red"><form:errors path="empId" /></font>
								<br>
	Salary <form:input path="salary" size="30"/>
								<font color="red"><form:errors path="salary" /></font>
								<br>
	Technology : <form:select path="technology">
					<form:options items="${technologyList }"/>
				</form:select>
	<input type="submit" value="Add Employee">
	</form:form>

</body>
</html>