<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	.error{color:red}
</style>
<title>Customer Form</title>
</head>
<body>
(*) means required
	<form:form action="processCustomerForm" modelAttribute="customer">
		First name: <form:input path="firstName" />
		<br><br>
		Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		Free Passes (*): <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error"/>
		<br><br>
		Postal Code (*): <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>