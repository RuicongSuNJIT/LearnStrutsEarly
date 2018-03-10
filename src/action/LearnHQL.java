package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.OrderDao;
import dao.UserDao;
import po.Order;
import po.User;

@Result(name = "success", location = "/succHibernate.jsp")
public class LearnHQL extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670731553870350523L;
	private UserDao userDao = new UserDao();
	private OrderDao orderDao = new OrderDao();

	@Action(value = "singleResult")
	public String singleResult() throws Exception {
		User user = userDao.loadByName("Lsf");
		user.printOrder();
		return SUCCESS;
	}

	@Action(value = "resultList")
	public String resultList() throws Exception {
		User user = userDao.loadByName("Lsf");
		List<Order> orders = orderDao.getOrdersByUser(user);
		Order.showOrders(orders);
		return SUCCESS;
	}
}
