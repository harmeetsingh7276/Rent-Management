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
	<table border="1">
	<tr>
		<th>Mobile Number</th>
		<th>Basic Information</th>
	</tr>
	<%
	List<Tenants> tenants=(List<Tenants>) request.getAttribute("listOfTenantsDetails");
	for(Tenants t:tenants){
		out.print("<tr>");
			out.print("<td>"+t.getMobileNumber()+"</td>");
			out.print("<td><ul>"+
			"<li>Name:"+t.getName()+"</li>"+
			"<li>Date of Deposit Given:"+t.getDateOfDepositGiven()+"</li>"+
			"<li>Date of Living:"+t.getDateOfLiving()+"</li>"+
			"<li>Doucment url:"+t.getIdProof()+"</li>"+
			"<li>Deposit:"+t.getDeposit()+"</li>"+
			"<li>Rent:"+t.getRent()+"</li>"+
			"</ul></td>");
		out.print("</tr>");
	}
	%> 
	</table>
</body>
</html>