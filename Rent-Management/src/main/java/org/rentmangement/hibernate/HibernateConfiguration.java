package org.rentmangement.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rentmanagement.model.Tenants;

public final class HibernateConfiguration {
	
	private static Session session;
	
	private static SessionFactory factory;

	public static Session getSession() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tenants.class)
				.buildSessionFactory();
		session=factory.getCurrentSession();
		return session;
	}
	
	public static void closeSession() {
		session.close();
		factory.close();
	}
		
}
