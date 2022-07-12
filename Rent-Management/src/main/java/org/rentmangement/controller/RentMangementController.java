package org.rentmangement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.rentmanagement.model.Tenants;
import org.rentmangement.hibernate.DAO.DAO;

@WebServlet("/RentMangementController")
public class RentMangementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//insert data in db taking input from the html and storing in db locally
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tenants t = new Tenants(request.getParameter("mobileNumber"), request.getParameter("name"),
				request.getParameter("idProof"), Integer.parseInt(request.getParameter("deposit")),
				Integer.parseInt(request.getParameter("rent")), request.getParameter("dateOfDeposit"),
				request.getParameter("dateOfLiving"));
		//System.out.println(t);
		new DAO().addTenantsDetails(t);
	}

}
