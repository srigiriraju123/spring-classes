<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO USER PAGE OF SPRING SECURITY TUTORIAL</title>
</head>
<body>
	<c:if test="${not empty pageContext.request.userPrincipal.name}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name}
                 | <a href="<c:url value="/login?logout" />" > Logout</a></h2>
	</c:if>
	<h1>User : ${author}</h1>	
	<h2>Message : ${message}</h2>	
</body>
</html>