<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- s表示struts标签 。 在这个例子里用s的struts标签和普通的用html的type写的区别就是这里有国际化 -->
<!-- name is the key for the 国际化资源的（properties）的内容，会调用此资源里的value -->
<title><s:text name="loginPage" /></title>
</head>
<body>
<!-- s:form会变成一个form里有table的形式。这个action = ""这里url是和action里的value对应。是用来找那个action对应的 -->
	<s:form action="login">
		<!-- id用来区分html里的一个标签用的，name是指在表单上传的时候对每一个值的命名，就是传给后台的key--比如找相应的这个key对应的action里的variable的name。这个action。。。。java class里相应的相同名字的变量值不用被赋值，直接显示了。所以对应的这个class里必定有varible name和这里的name 相同，可以直接不用赋值，后台自动赋值传入。name是可以相同的，id不能相同是为了前台浏览器服务的。 --对应后台的getparameter。
	下边的key ="user"是国际化用资源里的调用相应值的key 。这里的textfield正如HTML<TYPE ..>里的type签 -->
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