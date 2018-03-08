package user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action
public class TryUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8915010368128065474L;

	@Action(value = "tryUser", results = {
			@Result(name = "success", location = "/succTestHibernate.jsp") })

	public String tryUser() throws Exception {
		return SUCCESS;
	}

}
