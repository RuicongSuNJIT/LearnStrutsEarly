package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import po.UserInfo;

public class UserDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");

	public void insert(UserInfo userInfo) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(userInfo);
		em.getTransaction().commit();
		System.out.println(userInfo.getId());
	}
}
