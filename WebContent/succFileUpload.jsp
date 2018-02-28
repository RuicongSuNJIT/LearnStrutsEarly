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
	<s:property value="uploadFileName" />
	<br />
	<s:property value="uploadContentType" />
	<br />
	<s:text name="fileSize">
		<s:param>
			<s:property value="fileSize" />
		</s:param>
	</s:text>
</body>
</html>