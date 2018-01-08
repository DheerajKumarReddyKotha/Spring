<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Enrollment Form</title>
</head>
<body>
	<form:form action="processEnrollment" modelAttribute="student">
		First name: <form:input path="firstName" /><br>
		Last name: <form:input path="lastName" /><br>
		Country: <form:select path="country">
		<form:options items="${countryOptions}"/>
			<%-- <form:option value="Brazil" label="Brazil"></form:option>
			<form:option value="France" label="France"></form:option>
			<form:option value="Germany" label="Germany"></form:option>
			<form:option value="India" label="India"></form:option> --%>
		</form:select><br><br>
		FavoriteLanguage:
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/> 
		<%-- JAVA <form:radiobutton path="favoriteLanguage" value="Java"/>
		C <form:radiobutton path="favoriteLanguage" value="C"/>
		C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
		RUBY <form:radiobutton path="favoriteLanguage" value="Ruby"/><br><br> --%>
		<br><br>
		<%-- <form:checkbox path="operatingSystems" items="${student.operatingSystems}"/> --%>
		WINDOWS <form:checkbox path="operatingSystems" value="Windows"/>
		MAC <form:checkbox path="operatingSystems" value="Mac"/>
		LINUX <form:checkbox path="operatingSystems" value="Linux"/>
		UNIX <form:checkbox path="operatingSystems" value="Unix"/><br><br>
		<br><br>
		<input type="submit" name="enroll" />
	</form:form>
</body>
</html>