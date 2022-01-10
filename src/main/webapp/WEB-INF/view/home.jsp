<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security Demo</title>
</head>
<body>
	<h2>Spring Security Demo</h2>
	<hr>
	<p>Welcome to the Spring Security Demo home page!</p>
	<hr>
	
	<!-- user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s):<security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasRole('MANAGER')">
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>(Only for Managers)
	</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">	
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems meeting</a>(Only for Admins)
	</p>
	</security:authorize>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>