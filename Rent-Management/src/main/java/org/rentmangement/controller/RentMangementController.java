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
		case "updateInformation":
			updateInformation(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "listTenants":
			listTenants(request, response);
			break;
		case "deleteTenant":
			deleteTenant(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public void updateInformation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mob = request.getParameter("mobileNumber");
		Tenants t = new DAO().getTenantsFromMobileNumber(mob);
		if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {
			t.setName(request.getParameter("name"));
		}
		if (request.getParameter("idProof") != null && !request.getParameter("idProof").isEmpty()) {
			t.setIdProof(request.getParameter("idProof"));
		}
		if (request.getParameter("deposit") != null && !request.getParameter("deposit").isEmpty()) {
			t.setDeposit(request.getParameter("deposit"));
		}
		if (request.getParameter("rent") != null && !request.getParameter("rent").isEmpty()) {
			t.setRent(request.getParameter("rent"));
		}
		if (request.getParameter("dateOfDeposit") != null && !request.getParameter("dateOfDeposit").isEmpty()) {
			t.setDateOfDepositGiven(request.getParameter("dateOfDeposit"));
		}
		if (request.getParameter("dateOfLiving") != null && !request.getParameter("dateOfLiving").isEmpty()) {
			t.setDateOfLiving(request.getParameter("dateOfLiving"));
		}
		new DAO().updateInformation(t);
		listTenants(request, response);
	}

	public void listTenants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tenants> lst = new DAO().listTenantsDetails();
		request.setAttribute("listOfTenantsDetails", lst);
		request.getRequestDispatcher("listTenants.jsp").forward(request, response);
	}

	public void addTenant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tenants t = new Tenants(request.getParameter("mobileNumber"), request.getParameter("name"),
				request.getParameter("idProof"), request.getParameter("deposit"), request.getParameter("rent"),
				request.getParameter("dateOfDeposit"), request.getParameter("dateOfLiving"));
		// System.out.println(t);
		new DAO().addTenantsDetails(t);
		listTenants(request, response);
	}

	private void deleteTenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mob=request.getParameter("mobileNumber");
		new DAO().deleteTenant(mob);
		System.out.println("Deleted");
		listTenants(request, response);
	}
}
