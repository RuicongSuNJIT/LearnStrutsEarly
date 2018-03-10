package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.Product;

public class ProductDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");
	private EntityManager em = emf.createEntityManager();

	public void insert(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	public Product load(long i) {
		return em.find(Product.class, i);
	}
}
