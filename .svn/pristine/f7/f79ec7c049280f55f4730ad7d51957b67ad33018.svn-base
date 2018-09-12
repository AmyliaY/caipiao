
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="${pageContext.request.contextPath }/lib/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/lib/css/H-ui.admin.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/css/css.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	margin: auto;
	width: 75%;
	text-align: center;
}

button {
	margin-top: 10%;
}

span {
	vertical-align: middle;
}

input {
	vertical-align: middle;
}

div {
	margin-top: 5%;
	height: 30px;
	text-align: center;
}

select {
	height: 30px;
}
</style>
</head>

<body>
	<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
	<form action="/caipiao-web/userscaiwu.do?p=storescaiwutijiao"
		method="post">
		<input type="text" name="id" style="display: none;"
			value="${caipiaodian.id }" />
		<div class="col-2">
			<p style="line-height: 30px;vertical-align: middle;">手机号：</p>
		</div>
		<div class="col-10">
			<input type="text" class="input-text" id="phone" name="phone"
				value="${caipiaodian.phone}" />
		</div>
		</div>
		<div class="col-2">
			<p style="line-height: 30px;vertical-align: middle;">可提现：</p>
		</div>
		<div class="col-10">
			<input type="text" class="input-text" id="ketixian" name="ketixian"
				value="${caipiaodian.ketixian}" />
		</div>
		<div class="col-2">
			<p style="line-height: 30px;vertical-align: middle;">已冻结：</p>
		</div>
		<div class="col-10">
			<input type="text" class="input-text" id="dongji" name="dongji"
				value="${caipiaodian.dongjie}" />
		</div>
		<div class="col-2">
			<p style="line-height: 30px;vertical-align: middle;">已提现：</p>
		</div>
		<div class="col-10">
			<input type="text" class="input-text" id="yitixian" name="yitixian"
				value="${caipiaodian.yitixian}" />
		</div>
		<button type="submit" class="input-text label label-success radius"
			id="tijiao">提交</button>
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/jquery.messager.js">
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
		src="${pageContext.request.contextPath }/lib/js/H-ui.js"></script>
	<script type="text/javascript">
 window.onload=function()
  	{
   		var status = "${status}";
   		if(status=="success")
   			window.parent.location.reload();
   			}
  </script>
</body>

</html>
