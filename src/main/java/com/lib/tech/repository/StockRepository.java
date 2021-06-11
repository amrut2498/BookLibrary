package com.lib.tech.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.tech.model.Stock;

/**
 * @author Amrut Bugde
 *
 */
@Repository
public class StockRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Stock> getAllStock(){
		Session session = this.sessionFactory.openSession();
		List<Stock> stockList = session.createQuery("from Stock").getResultList();
		session.close();
		
		return stockList;
	}
	public void save(Stock stock) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stock);
		tx.commit();
		session.close();
	}
	public void deleteStock(Stock stock) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(stock);
		tx.commit();
		session.close();
	}
}
