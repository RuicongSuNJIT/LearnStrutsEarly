package po;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "date")
	private Date date;

	@ManyToMany
	private List<Product> products;

	@ManyToOne
	private User user;

	public Order() {
		products = new LinkedList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void showOrders(List<Order> orders) {
		for (Order order : orders) {
			System.out.println("Order #" + order.getId() + ":");
			for (Product product : order.getProducts()) {
				System.out.println("  Product: " + product.getName());
			}
		}
	}
}
