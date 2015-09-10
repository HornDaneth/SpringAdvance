<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Contact Manager</h2>
<c:url value='/submit'  var="theAction"/>
<form:form method="get" action="${ theAction }" commandName="command">
	<table>
		<tr>
			<td><form:label path="firstName">First Name</form:label></td>
			<td><form:input path="firstName"/></td> 
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName"/></td> 
		</tr>
		<tr>
			<td><input type="submit" /></td>
		</tr>
	</table>	
	
</form:form>
</body>
</html>
