<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security Demo - login page</title>
<style>
	.failed{color: #ff0000;}
</style>

</head>
<body>
	<h3>My custom login page</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
		<c:if test="${param.error != null }">
			<i class="failed">Invalid user name or password!</i>
		</c:if>
		<p>User name: <input type="text" name="username" /></p>
		<p>Password: <input type="password" name="password"> </p>
		<p><input type="submit" value="Login" /> </p>
	</form:form>
</body>
</html>