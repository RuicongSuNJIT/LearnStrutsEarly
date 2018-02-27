package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

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
		setTip("恭喜您, " + getUsername() + ", 您已注册成功!");
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {

		if ("surc".equals(getUsername()) && "1414213".equals(getPassword())) {
			ActionContext.getContext().getSession().put("user", getUsername());
			setTip("欢迎, " + getUsername() + ", 您已登录!");
			return SUCCESS;
		}
		return ERROR;
	}

}
