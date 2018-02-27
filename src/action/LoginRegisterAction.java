package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7983946561281144939L;

	private String username;
	private String password;
	private String tip;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Action(value = "register", results = {
			@Result(name = "success", location = "/registerSuccess.jsp") })

	public String register() throws Exception {
		ActionContext.getContext().getSession().put("user", getUsername());
		return SUCCESS;
	}

	@Action(value = "login", results = {
			@Result(name = "success", location = "/loginSuccess.jsp"),
			@Result(name = "error", location = "/error.jsp") })
	public String login() throws Exception {
		if ("surc".equals(getUsername()) && "1414213".equals(getPassword())) {
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		}
		return ERROR;
	}

}
