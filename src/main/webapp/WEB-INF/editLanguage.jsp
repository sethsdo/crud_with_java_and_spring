<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<div class="container">
			<div>Crud Assignment</div> | <a href="/">Dashboard</a>
			<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
				<form:label path="name">Name
					<form:errors path="name" />
					<form:input path="name" />
				</form:label>
			
				<form:label path="creator">Creator
					<form:errors path="creator" />
					<form:textarea path="creator" />
				</form:label>
			
				<form:label path="version">Version
					<form:errors path="version" />
					<form:input path="version" />
				</form:label>
			
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</body>
</html>