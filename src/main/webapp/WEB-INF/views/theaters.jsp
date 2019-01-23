<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/resources/account.png" type="image/gif" sizes="20x20">
<meta charset="ISO-8859-1">
<title> Select City </title>
</head>

<style>
#nextstep {
 margin: 0 auto; 
	text-align: center;
   overflow:hidden;
   width:350px;
   -moz-border-radius: 9px 9px 9px 9px;
   -webkit-border-radius: 9px 9px 9px 9px;
   border-radius: 9px 9px 9px 9px;
   box-shadow: 1px 1px 11px #330033;
   background: #a9dfbf  no-repeat scroll 319px center;
   position : relative;
}

#footer {
   position:absolute;
   bottom:0;
   width:100%;
   height:60px;
}

#mainselection select {
   border: 0;
   color:  #145a32 ;
   background: transparent;
   font-size: 20px;
   font-weight: bold;
   padding: 2px 10px;
   width: 378px;
   *width: 350px;
   *background: #a9dfbf ;
   -webkit-appearance: none;
}

#mainselection {
margin: 0 auto; 
	text-align: center;
   overflow:hidden;
   width:350px;
   -moz-border-radius: 9px 9px 9px 9px;
   -webkit-border-radius: 9px 9px 9px 9px;
   border-radius: 9px 9px 9px 9px;
   box-shadow: 1px 1px 11px #330033;
   background: #a9dfbf  no-repeat scroll 319px center;
}



button {
float:bottom;
	position:bottom;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 40%;
}

button:hover {
    opacity: 0.8;
}



</style>

<body bgcolor="#eae3ef">

<div id="mainselection" >

	<form action="${pageContext.request.contextPath}/selectMovie" method="post">
		 <select name="theaterId" id="theaterId">
		 	  <option selected disabled>Choose one</option>
			  <option value="pvr">PVR Cinema</option>
			  <option value="car">Carnival</option>
			  <option value="inx">INOX</option>
		</select> 
		
		<div id="nextstep">
		<input type="submit" value="Next step"/>
		</div>
	</form>
	
</div>

<div id="footer" style="text-align: center;">
 <form action="/logout"> 
 	<button type="submit">Sign Out</button>
 </form>
 </div> 
 
</body>
</html>