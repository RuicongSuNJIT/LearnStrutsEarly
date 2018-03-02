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
			'url' : 'ajaxRequest.action',
			'type' : 'POST',
			'data' : {
				'username' : '123',
				'password' : '456'
			},
			'dataType' : 'json',
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