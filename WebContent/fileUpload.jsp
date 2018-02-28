<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="fileUpld" /></title>
</head>
<body>
	<s:form action="fileUpload" enctype="multipart/form-data">
		<s:file name="upload" key="fileSlct"/>
		<s:submit key="fileUpld"/>
	</s:form>
</body>
<script type="text/javascript">
	
</script>
</html>