package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import po.Order;
import po.User;

public class OrderDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");
	private EntityManager em = emf.createEntityManager();

	private static final String QUERY_BY_NAME = "select o from Order o where user_id = :user_id and date < :date";

	public void insert(Order order) {
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}

	public List<Order> getOrdersByUser(User user) {

		return em.createQuery(QUERY_BY_NAME, Order.class)
				.setParameter("user_id", user.getId())
				.setParameter("date", new Date(), TemporalType.TIMESTAMP)
				.getResultList();
	}
}
