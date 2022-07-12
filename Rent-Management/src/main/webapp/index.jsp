<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
<h1>Rent Management</h1>
<h2>Add Tenant Details</h2>
<a href="${pageContext.request.contextPath}/RentMangementController?action=listTenants">View Tenant Details</a>
<form action="RentMangementController?action=addTenant" method="post">
	Enter Mobile Number:<input type="text" id="mobileNumber" name="mobileNumber"/>
	<p/>
	Enter Name:<input type="text" id="name" name="name"/>
	<p/>
	Enter URL:<input type="text" id="idProof" name="idProof"/>
	<p/>
	Enter Deposit:<input type="text" id="deposit" name="deposit"/>
	<p/>
	Enter Rent:<input type="text" id="rent" name="rent"/>
	<p/>
	Enter Date Of Deposit:<input type="text" id="dateOfDeposit" name="dateOfDeposit"/>
	<p/>
	Enter Date Of Living:<input type="text" id="dateOfLiving" name="dateOfLiving"/>
	<p/>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>