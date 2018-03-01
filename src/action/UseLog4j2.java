package action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class UseLog4j2 extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4459145719304406276L;
	static final Logger logger = LogManager
			.getLogger(UseLog4j2.class.getName());

	@Action(value = "logTest", results = {
			@Result(name = "success", location = "/error.jsp") })
	public String execute() throws Exception {
		logger.info("This is just a test.");
		logger.error("error");
		return "success";
	}
}
