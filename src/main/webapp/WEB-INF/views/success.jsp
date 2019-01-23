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
<title> Success </title>
</head>

<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

#info{
text-align: center;
 font-family:  Gill Sans MT;
 color: #088A85;
}
#footer {
   position:absolute;
   bottom:0;
   width:100%;
   height:60px;
}
button {
font-size: 15px;
	align:center;
    background-color: #3CB371;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 65%;
}

button:hover {
    opacity: 0.8;
}

</style>

<body bgcolor="#FFFFE0">

<div id= "info">

 <h1>Ticket Booked Successfully</h1>
 
 <h2>Ticket Details</h2>
 
 <table id="customers">
  <tr>
  <td><h4>Movie Name:</td> <td> ${movieName}  </h4> </td>
 </tr>
 
 <tr>
  <td><h4>Theater:</td> <td> ${movieTheater}  </h4> </td>
  </tr>
  
  <tr>
  <td><h4>Date: </td><td> ${movieDate}  </h4></td>
  </tr>
  
  <tr>
  <td><h4>Seat No.: </td> <td>${seats}  </h4></td>
  </tr>
  
  <tr>
  <td> <h4>Time: </td> <td> ${movieTime} </h4></td>
 </tr>
 </table>
 

</div>

<div id="footer" style="text-align: center;">
 <form action="${pageContext.request.contextPath}/logout"> 
 	<button type="submit"><b>Sign Out</button>
 </form>
</div> 

	
 
</body>
</html>