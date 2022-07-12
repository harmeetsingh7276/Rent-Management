package org.rentmanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rentmanagement.model.Tenants;

public class App {

	public static void main(String[] args) {
		//Remember place the hibernate config file in src/java  basically keep where App.java is
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tenants.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			List<Tenants> tenants=session.createQuery("from tenants").getResultList();
			
			for(Tenants t:tenants) {
				System.out.println(t);
			}
			//session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
