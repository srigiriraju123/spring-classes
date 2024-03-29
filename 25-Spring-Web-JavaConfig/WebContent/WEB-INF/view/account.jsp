 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <html>
	<head>
		<title>Bank Management System</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
	</head>
	<body>
		<h1>Open Account Form</h1>
		 <form:form method="post" commandName="account">
		  Account Number:<br>
		  <form:input type="text" path="id"/> <form:errors path="id"/><br>
		  Account Name:<br>
		  <form:input type="text" path="name"/> <form:errors path="name"/><br>
		  Initial Balance:<br>
		  <form:input type="text" path="balance"/> <form:errors path="balance"/><br>
		  <br>
		  <input type="submit" value="Open Account">
		</form:form> 
		
		<hr>
		  <c:if test="${not empty account }">
		  	<table border="1">
		  		<tr>
		  			<td>Account Number</td>
		  			<td>Name</td>
		  			<td>Balance</td>
		  		</tr>
		  		<tr>
		  			<td>${account.id }</td>
		  			<td>${account.name }</td>
		  			<td>${account.balance }</td>
		  		</tr>
		  	</table>
		  </c:if>
	</body>
</html>