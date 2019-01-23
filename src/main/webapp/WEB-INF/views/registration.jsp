<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/registration" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

	<label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="userName" required>
    
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="userEmail" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="userPassword" required>

    <label for="mob"><b>Mobile</b></label>
    <input type="password" placeholder="Enter Password" name="userMobile" required>
   
   <select>
   	<option value="male">Male</option>
   	<option value="female">Female</option>
   </select>
   
    <div class="clearfix">
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>

</body>
</html>