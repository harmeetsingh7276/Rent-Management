<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.rentmanagement.model.Tenants"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Tenant Details</title>
</head>
<body>
	<h1>Rent Management</h1>
	<h2>List of Tenant Details</h2>
	<%
	List<Tenants> tenants=(List<Tenants>) request.getAttribute("listOfTenantsDetails");
	for(Tenants t:tenants){
		out.print("<hr/>"+t);
	}
	%> 
</body>
</html>