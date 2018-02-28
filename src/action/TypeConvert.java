package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import pojo.User;

public class TypeConvert extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2132178755120867389L;

	private int iNum;
	private double dNum;
	private Integer wrapINum;
	private Double wrapDNum;
	private User user;
	private Map<String, User> mUsers;
	private List<User> lUsers;

	public int getiNum() {
		return iNum;
	}

	public void setiNum(int iNum) {
		this.iNum = iNum;
	}

	public double getdNum() {
		return dNum;
	}

	public void setdNum(double dNum) {
		this.dNum = dNum;
	}

	public Integer getWrapINum() {
		return wrapINum;
	}

	public void setWrapINum(Integer wrapINum) {
		this.wrapINum = wrapINum;
	}

	public Double getWrapDNum() {
		return wrapDNum;
	}

	public void setWrapDNum(Double wrapDNum) {
		this.wrapDNum = wrapDNum;
	}

	public Map<String, User> getmUsers() {
		return mUsers;
	}

	public void setmUsers(Map<String, User> mUsers) {
		this.mUsers = mUsers;
	}

	public List<User> getlUsers() {
		return lUsers;
	}

	public void setlUsers(List<User> lUsers) {
		this.lUsers = lUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Action(value = "typeConv", results = {
			@Result(location = "/succTypeConv.jsp") })
	public String typeConv() throws Exception {
		return SUCCESS;
	}
}
