<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

.mainselection select {
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

.mainselection {

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
 
 
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
  background-color: #3e8e41;
}

.dropdown {
  float: right;
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  right: 0;
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}

button {
	font-size: 15px;
	align:center;
    background-color: #3CB371;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}

button:hover {
    opacity: 0.8;
}


</style>

<body bgcolor="#FFFFF0">
	
	<form action="${pageContext.request.contextPath}/selectSeat" method="post">
	
	<div class="mainselection" >

		 <select name="cityId" id="cityId">
		 	  <option selected disabled>Select City</option>
			  
			  	<c:forEach items="${cities}" var="city">
			  		<option value="mum"> ${ city } </option>
			  	</c:forEach>
			
		</select> 
	</div>	
	<br>
	<br>
	<br>
	<br>
	<div class="mainselection" >
		<select name="theaterId" id="theaterId">
		 	  <option selected disabled>Select Theater</option>
		 	  
		 	  <c:forEach items="${theaters}" var="theater">
			  		<option value="mum"> ${ theater } </option>
			  	</c:forEach>
			  
		</select> 
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="mainselection" >	
		<select name="movieId" id="movieId">
		 	  <option selected disabled>Select Movie</option>
			  <c:forEach items="${movies}" var="movie">
			  		<option value="mum"> ${ movie } </option>
			  	</c:forEach>
			   
		</select>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="mainselection" > 
		<select name="movieDate" id="movieDate">
		 	  <option selected disabled>Select Date</option>
			<c:forEach items="${dates}" var="date">
			  		<option value="mum"> ${ date } </option>
			  	</c:forEach>
			  
		</select> 
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="mainselection" >	
		<select name="movieTime" id="movieTime">
		 	  <option selected disabled>Select Time</option>
			  <c:forEach items="${timings}" var="time">
			  		<option value="mum"> ${ time } </option>
			  	</c:forEach>
		</select> 
	</div>	
	<br>
	<br>
	<br>
	<br>
		<div id="nextstep">
		<center><button type="submit" ><b>Next </button></center>
		</div>
	</form>

</body>
</html>