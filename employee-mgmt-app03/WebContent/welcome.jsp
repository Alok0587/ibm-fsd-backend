<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Employee page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div style="background-color:#ff8080;height:400px;width:800px">
<h2  class="bg-primary" style=" margin-top:50px; color:white;">Welcome To Employee Page</h2>
<br>
<br>
<div style="margin-left:50px;">
<a type="button" class="btn btn-primary" href="employeeForm.jsp">Add Employee</a><br><br>
<a type="button" class="btn btn-primary" href="EditForm.jsp" >Edit Employee Details</a><br><br>
<a type="button" class="btn btn-primary" href="ViewById.jsp">View Employee by ID</a><br><br>
<a type="button" class="btn btn-primary" href="DeleteById.jsp">Delete Employee By ID</a><br><br>
<a type="button" class="btn btn-primary" href="ViewAll.jsp">View All Employee</a>
</div>
</div>
</body>
</html>