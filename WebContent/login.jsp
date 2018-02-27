<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage" /></title>
</head>
<body>
	<s:form action="login">
		<s:textfield name="username" key="user" />
		<s:password name="password" key="pass" />
		<s:submit key="login" />
		<s:submit key="regist" onclick="register()" />
	</s:form>
</body>
<script type="text/javascript">
	function register() {
		var userForm = document.forms[0];
		userForm.action = "register";
	}
</script>
</html>