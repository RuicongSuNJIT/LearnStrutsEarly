package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action, ServletResponseAware {

	private String username;
	private String password;
	private HttpServletResponse response;

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

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String execute() throws Exception {

		if ("surc".equals(getUsername()) && "1414213".equals(getPassword())) {
			ActionContext.getContext().getSession().put("user", getUsername());
			Cookie cookie = new Cookie("user", getUsername());
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			return SUCCESS;
		}
		return ERROR;
	}

}
