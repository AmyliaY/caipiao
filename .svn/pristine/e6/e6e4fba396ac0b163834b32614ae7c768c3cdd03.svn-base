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
	margin-top: 10%;
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

	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票类型：</p>
	</div>
	<div class="col-10">
		<input class="input-text" id="caipiao_leixing" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">是否启用：</p>
	</div>
	<div class="col-10">
		<select class="select" id="status">
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>


	<button type="button" class="label label-success radius input-text"
		id="tijiao">提交</button>





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
	<script type="text/javascript">
	
	$("#tijiao").click(function()
	{
	
	var caipiao_leixing = $("#caipiao_leixing").val();
	var status = $("#status").val();
	$.ajax({
	url:"${pageContext.request.contextPath}/caipiaodian.do?p=caipiao_leixing_add",
	type:"post",
	data:{
	caipiao_leixing:caipiao_leixing,
	status:status,
	},
	success:function(data)
	{
	alert(data);
	layer_close();
	}
	});
	
	});
	
	
</script>
</body>
</html>
