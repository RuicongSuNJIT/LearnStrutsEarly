package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Order;

public class OrderDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");
	private EntityManager em = emf.createEntityManager();

	public void insert(Order order) {
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
}
