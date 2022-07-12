package org.rentmangement.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rentmanagement.model.Tenants;

public final class DAO {
	
	public DAO() {

	}

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tenants.class)
			.buildSessionFactory();

	public void addTenantsDetails(Tenants tenant) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(tenant);
		session.getTransaction().commit();
		System.out.println("Added Details for" + tenant.getName());
	}

}
