package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import po.User;

@Result(name = "success", location = "/succHibernate.jsp")
public class LearnHQL extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -670731553870350523L;
	private UserDao userDao = new UserDao();

	@Action(value = "singleResult")
	public String singleResult() throws Exception {
		User user = userDao.loadByName("Lsf");
		user.printOrder();
		return SUCCESS;
	}
}
