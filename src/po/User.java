package po;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "friends", joinColumns = {
			@JoinColumn(name = "person_id") }, inverseJoinColumns = {
					@JoinColumn(name = "friend_id") })
	private List<User> friends;

	@ManyToMany
	@JoinTable(name = "friends", joinColumns = {
			@JoinColumn(name = "friend_id") }, inverseJoinColumns = {
					@JoinColumn(name = "person_id") })
	private List<User> friendOf;

	@OneToMany(mappedBy = "user")
	private List<Order> myOrders;

	public User() {
		friendOf = new LinkedList<>();
		friends = new LinkedList<>();
		myOrders = new LinkedList<>();
	}

	public void addFriend(User friend) {
		friends.add(friend);
	}

	public void printOrder() {
		System.out.println("User - " + name + ":");
		for (Order order : myOrders) {
			System.out.println("  Order #" + order.getId() + ":");
			for (Product product : order.getProducts()) {
				System.out.println("    Product: " + product.getName());
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendOf() {
		return friendOf;
	}

	public List<Order> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}
}
