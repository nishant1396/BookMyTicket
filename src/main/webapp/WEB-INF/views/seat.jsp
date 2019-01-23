<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Seats</title>
</head>
<style>

#squaredOne{

	text-align: center;
	margin-left: 28%;
	
}

h3{

font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
text-align:center;
color: #FF7F50;
font-size:35px;

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
    width: 35%;
    text-align:center;
}

button:hover {
    opacity: 0.8;
}


</style>

<body bgcolor="#FFFAFA">

	<form action="${pageContext.request.contextPath}/payment" method="post">
	<div id="squaredOne">
	<br>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<td><input type="checkbox" name="vehicle1" value="A1"> A1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A2"> A2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A3"> A3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A4"> A4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A5"> A5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A6"> A6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A7"> A7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A8"> A8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="A9"> A9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="B1"> B1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B2"> B2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B3"> B3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B4"> B4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B5"> B5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B6"> B6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B7"> B7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B8"> B8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="B9"> B9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="C1"> C1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C2"> C2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C3"> C3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C4"> C4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C5"> C5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C6"> C6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C7"> C7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C8"> C8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="C9"> C9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="D1"> D1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D2"> D2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D3"> D3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D4"> D4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D5"> D5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D6"> D6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D7"> D7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D8"> D8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="D9"> D9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="E1"> E1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E2"> E2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E3"> E3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E4"> E4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E5"> E5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E6"> E6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E7"> E7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E8"> E8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="E9"> E9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="F1"> F1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F2"> F2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F3"> F3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F4"> F4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F5"> F5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F6"> F6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F7"> F7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F8"> F8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="F9"> F9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="G1"> G1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G2"> G2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G3"> G3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G4"> G4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G5"> G5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G6"> G6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G7"> G7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G8"> G8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="G9"> G9 &nbsp &nbsp </td>
		</tr>
		
		<tr>
			<td><input type="checkbox" name="vehicle1" value="H1"> H1 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H2"> H2 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H3"> H3 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H4"> H4 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H5"> H5 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H6"> H6 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H7"> H7 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H8"> H8 &nbsp &nbsp </td>
			<td><input type="checkbox" name="vehicle1" value="H9"> H9 &nbsp &nbsp </td>
		</tr>
		
	</table>
	</div>
	
	<h3>Screen This Side</h3>
	<br>
	<br>
	<br>
	<br>
	<center>
	<button type="submit" > <b>Proceed To Pay </button>
	</center>
	</form>
	


</body>
</html>