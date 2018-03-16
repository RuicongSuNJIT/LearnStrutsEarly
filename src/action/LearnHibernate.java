package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.AuthorDao;
import dao.BookDao;
import dao.UserDao;
import po.Book;
import po.Person;
import po.UserInfo;

public class LearnHibernate extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084908787563059506L;

	private UserDao userDao = new UserDao();
	private AuthorDao authorDao = new AuthorDao();
	private BookDao bookDao = new BookDao();

	@Action(value = "createTable", results = {
			@Result(name = "success", location = "/succHibernate.jsp") })
	public String createTable() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setFName("Ruicong");
		userInfo.setLName("Su");
		userDao.insert(userInfo);
		return SUCCESS;
	}

	@Action(value = "tableJoin1N", results = {
			@Result(name = "success", location = "/succHibernate.jsp") })
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

	@Action(value = "tableJoin1NLoad", results = {
			@Result(name = "success", location = "/succHibernate.jsp") })
	public String tableJoin1NLoad() throws Exception {
		System.out.println("Load author by ID.");
		Person author = authorDao.load(1);
		System.out.println("Lazy Load books.");
		//这一句中没有执行s	ql语句
		List<Book> books = author.getBooks();
		// try .size();
		System.out.println("Pick one book.");
		//此时才去数据库里找books有什么东西，这是lazy load的方式。entity类里many-to-many这种使用的时候，会用lazy load的方式加载
		//这样做的目的是用user时候，后续操作或许不会考虑books。lazy load是到真正使用books的时候才会load.
		//把一个作者的所有书拿出来，所以即使只拿第一个记录会打印出所有的书。所以如果book.size()的时候，也会打印出所有的书。
		Book book = books.get(0);
		System.out.println("Same author(exact same person object)");
		//这个author和bookAuthor是同一个对象（由hash是同一个hash表明）。说明这里读取的时候用的是以前的那个对象，并没有创建新的对象。
		Person bookAuthor = book.getAuthor();
		System.out.println(author);
		System.out.println(bookAuthor);
		return SUCCESS;
	}

}
