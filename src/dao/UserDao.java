package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import po.UserInfo;

public class UserDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");

	public void insert(UserInfo userInfo) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(userInfo);
		System.out.println(userInfo.getId());
		em.getTransaction().commit();
		System.out.println(userInfo.getId());
	}
}
