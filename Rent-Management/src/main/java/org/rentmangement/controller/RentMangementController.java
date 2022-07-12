package org.rentmangement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.rentmanagement.model.Tenants;
import org.rentmangement.hibernate.DAO.DAO;

@WebServlet("/RentMangementController")
public class RentMangementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "addTenant":
			addTenant(request, response);
			break;
		case "listTenants":
			listTenants(request, response);
			break;

		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "listTenants":
			listTenants(request, response);
			break;

		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public void listTenants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tenants> lst=new DAO().listTenantsDetails();
		request.setAttribute("listOfTenantsDetails", lst);
		request.getRequestDispatcher("listTenants.jsp").forward(request, response);
	}

	public void addTenant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tenants t = new Tenants(request.getParameter("mobileNumber"), request.getParameter("name"),
				request.getParameter("idProof"), Integer.parseInt(request.getParameter("deposit")),
				Integer.parseInt(request.getParameter("rent")), request.getParameter("dateOfDeposit"),
				request.getParameter("dateOfLiving"));
		// System.out.println(t);
		new DAO().addTenantsDetails(t);
		listTenants(request,response);
	}
}
