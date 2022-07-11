package org.rentmanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rentmanagement.model.Tenants;

public class App {

	public static void main(String[] args) {
		//Remember place the hibernate config file in src/java
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tenants.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			//Tenants tenant= new Tenants("7276720124", "Harmeet", "www.google.com", 8000, 4000, "01/07/2022", "01/07/2022");
			Tenants tenant= new Tenants("8087626802", "Payal", "www.google.com", 8000, 4000, "01/07/2022", "01/07/2022");
			session.beginTransaction();
			session.save(tenant);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}

	}

}
