package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import po.User;
import po.UserInfo;

public class UserDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CRM");
	private EntityManager em = emf.createEntityManager();

	public void insert(UserInfo userInfo) {
		em.getTransaction().begin();
		em.persist(userInfo);
		System.out.println(userInfo.getId());
		em.getTransaction().commit();
		System.out.println(userInfo.getId());
	}
	
	public void insert(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public void makeFriends(User user1, User user2) {
		em.getTransaction().begin();
		user1.addFriend(user2);
		user2.addFriend(user1);
		em.flush();
		em.getTransaction().commit();
		// user1.getFriendsOf().size() = ?
	}

	public User load(long i) {
		return em.find(User.class, i);
	}
}
