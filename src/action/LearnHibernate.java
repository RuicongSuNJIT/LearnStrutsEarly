package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import po.UserInfo;

public class LearnHibernate extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084908787563059506L;

	private UserDao userDao = new UserDao();

	@Action(value = "createTable", results = {
			@Result(name = "success", location = "/succHibernate.jsp") })
	public String createTable() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setFName("Ruicong");
		userInfo.setLName("Su");
		userDao.insert(userInfo);
		return SUCCESS;
	}
}
