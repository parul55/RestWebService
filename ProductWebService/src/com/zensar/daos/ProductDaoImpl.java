
package com.zensar.daos;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zensar.entities.Product;

/*
 * Author:	Parul Singh
 * Creation Date: 26th Jul 2019 10.00AM
 * Modified Date: 26th Jul 2019 10.00AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Data Access Object Interface implementor
 * It implements all the methods of ProductDao interface
 * It uses Hibernate API to access product data from Dao.
 */
public class ProductDaoImpl implements ProductDao {

	/* (non-Javadoc)
	 * @see com.zensar.daos.ProductDao#insert(com.zensar.entities.Product)
	 */
	
	private Session session;
	
	
	
	public ProductDaoImpl() {
		
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		session=factory.openSession();
		System.out.println("DB Connection established");
		
		
	}
	
	
	

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
			Transaction tx=session.beginTransaction();
			session.save(product);
			tx.commit();
			System.out.println("Product inserted");
	}
	

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		session.save(product);
		tx.commit();
		System.out.println("Product updated");
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		session.delete(product);
		//session.save(product);
		tx.commit();
		System.out.println("Product deleted");
		
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		
		return session.get(Product.class, productId);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from Product");
		return query.getResultList();
	}

}
