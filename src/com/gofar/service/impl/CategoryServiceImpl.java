package com.gofar.service.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gofar.domain.Category;
import com.gofar.service.CategoryService;
import com.gofar.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {



	private SessionFactory sf ;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}



	public void update(Category c) {
		if (sf == null) {
			System.out.println("sf 为空");
		}
		Session session = sf.openSession();	
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
	}

}
