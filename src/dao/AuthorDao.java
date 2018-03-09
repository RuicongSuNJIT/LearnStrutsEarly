package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Person;

public class AuthorDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");

	public void insert(Person author) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
	}
}
