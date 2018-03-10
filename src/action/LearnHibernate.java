package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.AuthorDao;
import dao.BookDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.UserDao;
import po.Book;
import po.Order;
import po.Person;
import po.Product;
import po.User;
import po.UserInfo;

@Result(name = "success", location = "/succHibernate.jsp")
public class LearnHibernate extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084908787563059506L;

	private UserDao userDao = new UserDao();
	private AuthorDao authorDao = new AuthorDao();
	private BookDao bookDao = new BookDao();
	private ProductDao productDao = new ProductDao();
	private OrderDao orderDao = new OrderDao();

	@Action(value = "createTable")
	public String createTable() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setFName("Ruicong");
		userInfo.setLName("Su");
		userDao.insert(userInfo);
		return SUCCESS;
	}

	@Action(value = "tableJoin1N")
	public String tableJoin1N() throws Exception {
		Person author = new Person();
		author.setName("Surc");
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle("SSx");
		book.setIsbn("978-7-121-16085-1");
		authorDao.insert(author);
		bookDao.insert(book);
		return SUCCESS;
	}

	@Action(value = "tableJoin1NLoad")
	public String tableJoin1NLoad() throws Exception {
		System.out.println("Load author by ID.");
		Person author = authorDao.load(1);
		System.out.println("Lazy Load books.");
		List<Book> books = author.getBooks();
		// try .size();
		System.out.println("Pick one book.");
		Book book = books.get(0);
		System.out.println("Same author(exact same person object)");
		Person bookAuthor = book.getAuthor();
		System.out.println(author);
		System.out.println(bookAuthor);
		return SUCCESS;
	}

	@Action(value = "tableJoinNNFriends")
	public String tableJoinNNFriends() throws Exception {
		User user1 = new User();
		user1.setName("Lsf");
		userDao.insert(user1);

		User user2 = new User();
		user2.setName("Hkz");
		userDao.insert(user2);

		userDao.makeFriends(user1, user2);
		return SUCCESS;
	}

	@Action(value = "tableJoinNNFriendsLoad")
	public String tableJoinNNFriendsLoad() throws Exception {
		System.out.println("Load - User( id = 1 )");
		User user1 = userDao.load(1);
		System.out.println("Use \"friends\" List");
		System.out.println("I have " + user1.getFriends().size() + " friends.");
		System.out.println("Use \"friendOf\" List");
		System.out
				.println(user1.getFriendOf().size() + " make friends with me.");
		return SUCCESS;
	}

	@Action(value = "tableJoinNNOrder")
	public String tableJoinNNOrder() throws Exception {
		Product product1 = new Product();
		product1.setName("computer");
		productDao.insert(product1);

		Product product2 = new Product();
		product2.setName("Soap");
		productDao.insert(product2);

		Product product3 = new Product();
		product3.setName("skiing board");
		productDao.insert(product3);

		User user = userDao.load(1);
		Order order = new Order();
		order.setUser(user);
		order.setDate();
		order.addProduct(product1);
		order.addProduct(product2);
		order.addProduct(product3);
		orderDao.insert(order);

		// user.getOrders().size() = ?

		return SUCCESS;
	}

	@Action(value = "tableJoinNNOrderLoad")
	public String tableJoinNNOrderLoad() throws Exception {
		User user = userDao.load(1);
		user.printOrder();
		return SUCCESS;
	}
}
