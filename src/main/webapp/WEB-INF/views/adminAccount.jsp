<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Account</title>
</head>
<body>

	<h1>Admin account</h1>
	
	
<!-- 	<select name="cities" id="cities"> -->
	<c:forEach var="city" items="${cities}">
	
	Name : <c:out value="${city.name}"/><p>
	
<%-- 		<option value="amd"> <c:out value="${city.value}"/> </option> --%>
	</c:forEach>
<!-- 	</select> -->
	
	
</body>
</html>