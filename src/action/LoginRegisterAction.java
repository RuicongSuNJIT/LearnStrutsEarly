package action;

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

	public String register() throws Exception {
		ActionContext.getContext().getSession().put("user", getUsername());
		return SUCCESS;
	}

	public String login() throws Exception {
		if ("surc".equals(getUsername()) && "1414213".equals(getPassword())) {
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		}
		return ERROR;
	}

}
