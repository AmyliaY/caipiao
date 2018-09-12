
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath }/lib/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/lib/css/H-ui.admin.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/css/css.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/admin/adminlisting/css/addAdmin.css"
	rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加管理员</title>
</head>
<body>
	<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
	<form id="table">

		<input type="text" placeholder="昵称" class="input-text" name="name">

		<input type="text" placeholder="用户名" class="input-text"
			name="username"> <input type="text" placeholder="密码"
			class="input-text" name="password"> <input type="submit"
			value="提交" class="input-text">
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/layer/2.1/layer.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/laypage/1.2/laypage.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/My97DatePicker/WdatePicker.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/datatables/1.10.0/jquery.dataTables.min.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.admin.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/icheck.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/validate.js">

</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/jquery.form.js"></script>
	<script type="text/javascript">

$(function() {
			
			$("#table").validate({
		
			onkeyup : false,
			focusCleanup : true,
			success : "valid",
			submitHandler : function(form) {
				
				$(form).ajaxSubmit({
					type : 'post',
					url : '${pageContext.request.contextPath }/admin.do?p=addAdmin',
					success : function(data) {
						layer.msg('添加成功!', {
							icon : 6,
							time : 1000
						});
						setTimeout(function() {
							window.parent.location.reload();
						}, 1000);

					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
						layer.msg('error!', {
							icon : 2,
							time : 1000
						});
					}
				});
			}
		});
		});
</script>

</body>
</html>
