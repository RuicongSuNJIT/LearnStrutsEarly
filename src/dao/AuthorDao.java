package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Person;

public class AuthorDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");
	private EntityManager em = emf.createEntityManager();

	public void insert(Person author) {
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
	}

	public Person load(long id) {
		return em.find(Person.class, id);
	}
}
