package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Book;

public class BookDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");

	public void insert(Book book) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
	}
}
