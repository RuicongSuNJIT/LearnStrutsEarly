package action;

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
		book.initAuthor(author);
		book.setTitle("SSx");
		book.setIsbn("978-7-121-16085-1");
		authorDao.insert(author);
		bookDao.insert(book);
		return SUCCESS;
	}
}
