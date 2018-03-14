<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="succUpld" /></title>
</head>
<body>
	<s:text name="succUpld" />
	<br />
	<!-- action执行完跳转后的页面，若是jsp，此页面可以直接用action里的变量名 -->
	<s:property value="uploadFileName" />
	<br />
	<s:property value="uploadContentType" />
	<br />
	<s:text name="fileSize">
	<!-- param给国际化里的占位符赋值 -->
		<s:param>
			<s:property value="fileSize" />
		</s:param>
	</s:text>
</body>
</html>