package com.booking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.booking.admin.bean.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	@Qualifier("admin")
	private Admin admin2;
	
	@Override
	public void saveAdmin(Admin admin) {
	
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		sessionFactory.close();
		
		System.out.println("At dao--  "+admin);
		
		System.out.println("Complete");
		
	}

}
