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
	<div>
		<s:text name="primType" />
		<br />
		<s:text name="showInt">
			<s:param>
				<s:property value="iNum" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showWInt">
			<s:param>
				<s:property value="wrapINum" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showDou">
			<s:param>
				<s:property value="dNum" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showWDou">
			<s:param>
				<s:property value="wrapDNum" />
			</s:param>
		</s:text>
	</div>
	<div>
		<s:text name="refType" />
		<br />
		<s:text name="oUser" />
		<br />
		<s:text name="showUser">
			<s:param>
				<s:property value="user.username" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showPass">
			<s:param>
				<s:property value="user.password" />
			</s:param>
		</s:text>
	</div>
	<div>
		<s:text name="colType" />
		<br />
		<s:text name="showMUser">
			<s:param>'one'</s:param>
		</s:text>
		<br />
		<s:text name="showUser">
			<s:param>
				<s:property value="mUsers['one'].username" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showPass">
			<s:param>
				<s:property value="mUsers['one'].password" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showMUser">
			<s:param>'two'</s:param>
		</s:text>
		<br />
		<s:text name="showUser">
			<s:param>
				<s:property value="mUsers['two'].username" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showPass">
			<s:param>
				<s:property value="mUsers['two'].password" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showLUser">
			<s:param>0</s:param>
		</s:text>
		<br />
		<s:text name="showUser">
			<s:param>
				<s:property value="lUsers[0].username" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showPass">
			<s:param>
				<s:property value="lUsers[0].password" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showLUser">
			<s:param>1</s:param>
		</s:text>
		<br />
		<s:text name="showUser">
			<s:param>
				<s:property value="lUsers[1].username" />
			</s:param>
		</s:text>
		<br />
		<s:text name="showPass">
			<s:param>
				<s:property value="lUsers[1].password" />
			</s:param>
		</s:text>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>