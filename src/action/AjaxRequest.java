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
//这个package 不是java的package 而是struts里的结构。package里有result type ,interceptor 等等。这样可以用夫类包里的内容，value 是指定parent package是谁
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
			//type指定处理的result的类，xml/这里给的parameter是给处理类（struts本身来处理result和相应文件egjsp的class）来看的，root的参数的值是result。result是这个class变量，然后所以传给处理类的是string
			//然后处理类通过反射来找到result真正的值。 
			//没有root的话所有的field都会被处理成json打印返回出去，这里用root指定了某一个filed(result)被处理成json打印返回回去
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
