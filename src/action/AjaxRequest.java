package action;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

import pojo.User;

@ParentPackage(value = "json-default")
public class AjaxRequest extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8955978923261098183L;

	private String username;
	private String password;
	private pojo.Result result;

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

	public pojo.Result getResult() {
		return result;
	}

	@Action(value = "ajaxRequest", results = {
			@Result(name = "success", type = "json", params = { "root",
					"result" }) })
	public String ajaxRequest() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		Map<String, Object> map = new HashMap<>();
		map.put("object", user);
		map.put("array", new User[] { user, user });
		List<User> list = new LinkedList<>();
		list.add(user);
		list.add(user);
		map.put("list", list);
		result = new pojo.Result(pojo.Result.OK, map);
		return SUCCESS;
	}
}
