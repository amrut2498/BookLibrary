package com.lib.tech.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.tech.model.Book;

/**
 * @author Amrut Bugde
 *
 */
@Repository
public class BookRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getAllBooks() {
		Session session = this.sessionFactory.openSession();
		List<Book> bookList = session.createQuery("from Book").getResultList();
		session.close();

		return bookList;
	}

	public void save(Book book) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
	}

	public void deleteBook(Book book) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(book);
		tx.commit();
		session.close();
	}
}
