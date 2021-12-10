<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no ">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>	
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Spring Security Demo - Login page</title>
</head>
<body>
	<div>
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign in</div>
				</div>
				<div style="padding-top: 30px;" class="panel-body">
					<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post" class="form-horizontal">
						<div class="form-group">
							<div class="col-xs-15">
								<div>
									<c:if test="${param.error != null}">
										<div class="alert alert-dangercol-xs-offset-1 col-xs-10">
											Invalid username or password
										</div>
									</c:if>
									<!--		            
									<div class="alert alert-success col-xs-offset-1 col-xs-10">
										You have been logged out.
									</div>
								    -->
								</div>
							</div>
						</div>
						<div style="margin-bottom: 25px;" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" name="username" placeholder="Enter login" class="form-control">
						</div>
						
						<div style="margin-bottom: 25px;" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input type="text" name="password" placeholder="Enter password" class="form-control">
						</div>
						
						<div style="margin-top: 10px;" class="form-group">
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</div>
						
					</form:form>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>