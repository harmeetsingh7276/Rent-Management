package org.rentmangement.hibernate.DAO;

import java.util.List;

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
		System.out.println("Added Details for " + tenant.getName());
	}
	
	public List<Tenants> listTenantsDetails(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Tenants> lst=session.createQuery("from tenants").getResultList();
		//session.getTransaction().commit(); not required while reading
		return lst;
	}

	public void updateInformation(Tenants tenant) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(tenant);
		session.getTransaction().commit();
		System.out.println("Updated Details for " + tenant.getName());
		
	}

	public Tenants getTenantsFromMobileNumber(String mob) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.get(Tenants.class,mob);
	}
}
