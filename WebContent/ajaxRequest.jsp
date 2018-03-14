<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="ajaxReq"></s:text></title>
</head>
<body>
	<button onclick="ajaxRequest()">
		<s:text name="send"></s:text>
	</button>
</body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function ajaxRequest() {
		$.ajax({
			//请求的地址
			'url' : 'ajaxRequest.action',
			'type' : 'POST',
			//请求参数
			'data' : {
				'username' : '123',
				'password' : '456'
			},
			//接到的返回值的类型
			'dataType' : 'json',
			//success代表相应请求的结果。（200http请求成功）而不是ajaxrequest.java里的resultname。如果请求成功调用success函数。success是一种function。
			'success' : function(data) {
				$('body').append('<br />')
				print(data, $('body'), '');
			}
		});
	}

	function print(data, out, prefix) {
		for ( var key in data) {
			if (data[key] instanceof Array) {
				var len = data[key].length;
				for (var i = 0; i < len; ++i) {
					out.append(prefix + i);
					out.append('<br />');
					print(data[key][i], out, '&nbsp;' + prefix + '-');
				}
			} else if (data[key] instanceof Object) {
				out.append(prefix + key);
				out.append('<br />');
				print(data[key], out, '&nbsp;' + prefix + '-');
			} else {
				out.append(prefix + key + '=' + data[key]);
				out.append('<br />');
			}
		}
	}
</script>
</html>