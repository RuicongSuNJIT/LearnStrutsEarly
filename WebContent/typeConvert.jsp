<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="typeConv" /></title>
</head>
<body>

	<s:form action="typeConv">
		<s:textfield name="iNum" key="int" />
		<s:textfield name="wrapINum" key="wInt" />
		<s:textfield name="dNum" key="dou" />
		<s:textfield name="wrapDNum" key="wDou" />
		<s:textfield name="user.username" key="user" />
		<s:password name="user.password" key="pass" />
		<s:textfield name="mUsers['one'].username" label="Map用户['one']:用户名" />
		<s:password name="mUsers['one'].password" label="Map用户['one']:密　码" />
		<s:textfield name="mUsers['two'].username" label="Map用户['two']:用户名" />
		<s:password name="mUsers['two'].password" label="Map用户['two']:密　码" />
		<s:textfield name="lUsers[0].username" label="List用户[0]:用户名" />
		<s:password name="lUsers[0].password" label="List用户[0]:密　码" />
		<s:textfield name="lUsers[1].username" label="List用户[1]:用户名" />
		<s:password name="lUsers[1].password" label="List用户[1]:密　码" />
		<s:submit key="submit" />
	</s:form>
</body>
<script type="text/javascript">
	
</script>
</html>