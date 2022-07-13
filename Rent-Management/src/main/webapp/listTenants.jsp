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
<%String mobileNumber="";%>
	<h1>Rent Management</h1>
	<h2>List of Tenant Details</h2>
	<a href="${pageContext.request.contextPath}/">Add User</a> |
	<a href="${pageContext.request.contextPath}/RentMangementController?action=listTenants">View Tenant Details</a>
	<table border="1">
	<tr>
		<th>Mobile Number</th>
		<th>Basic Information</th>
		<th>Update Information</th>
		<th>Operations</th>
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
			mobileNumber=t.getMobileNumber();
			String updateForm="<form action='RentMangementController' method='post'>"+
					"Name:<input type='text' name='name'/><p/>"+
					"Date of Deposit Given:<input type='text' name='dateOfDeposit'/><p/>"+
					"Date of Living:<input type='text' name='dateOfLiving'/><p/>"+
					"Document URL:<input type='text' name='idProof'/><p/>"+
					"Deposit:<input type='text' name='deposit'/><p/>"+
					"Rent:<input type='text' name='rent'/><p/>"+
					"<input type='hidden' name='mobileNumber' value='"+mobileNumber+"'/><p/>"+
					"<input type='hidden' name='action' value='updateInformation'/><p/>"+
					"<input type='submit' value='Update'/><p/>"+
							"</form>";
			out.print("<td>"+updateForm+"</td>");
			out.print("<td>"+"<form action='RentMangementController' method='post'><a href='"+request.getContextPath()+"/RentMangementController?action=deleteTenant&mobileNumber="+mobileNumber+"' onclick='if(!confirm(`Are you sure to delte the tenant?`)) return false'>Delete</a></form>"+"<td>");
		out.print("</tr>");
	}
	%> 
	</table>
</body>
</html>