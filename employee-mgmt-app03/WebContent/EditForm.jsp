<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<div style="background-color:#ff8080;height:400px;width:800px">
<h2 class="bg-primary" style=" margin-top:50px; color:white;">Edit Employee</h2>

<form class="form-group" action="employeeForm">
<input type="hidden" name="flag" value="2">
Existing ID:<input type="text" name="id" ><br>
 Updated  name:<input type="text" name='name' ><br>
 Updated Age:<input type="text" name='age'><br>
 Updated Desg:<input type="text" name='desg'><br>
 Updated Country:<input type="text" name='country'><br>
<input class="btn btn-primary" type="submit" value="Change">
</form>
</div>
</body>
</html>