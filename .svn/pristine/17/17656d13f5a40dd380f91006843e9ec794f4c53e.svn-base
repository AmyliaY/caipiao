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
		<p style="line-height: 30px;vertical-align: middle;">名字：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="name" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票类型：</p>
	</div>
	<div class="col-10">
		<select class="select" id="type"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">价格：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="price" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">上架时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="begintime"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">下架时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="endtime"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">状态：</p>
	</div>
	<div class="col-10">
		<select id="status" class="select">
			<option value="0">上架</option>
			<option value="1">下架</option>
		</select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">开奖时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="kaijiangtime"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">奖池：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="jiangchi" />
	</div>
	<button type="button" class="label label-success radius input-text"
		id="tijiao">提交</button>



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
	window.onload = function ()
	{
		$.ajax({
			url:'${pageContext.request.contextPath }/caipiaodian.do?p=addcaipiaolisting_leixing',
			type:'post',
			success:function(data){
			var json = eval('('+data+')');
			
			for(var i = 0 ; i < json.length ; i++)
			{
				$("#type").append('<option value='+json[i].id+'>'+json[i].mingcheng+'</option>');
			}
			}
		});
	}
	$("#tijiao").click(function()
	{
	var name = $("#name").val();
	var type = $("#type").val();
	var price = $("#price").val();
	var begintime = $("#begintime").val();
	var endtime = $("#endtime").val();
	var status = $("#status").val();
	var kaijiangtime = $("#kaijiangtime").val();
	var jiangchi = $("#jiangchi").val();
	$.ajax({
		url:'${pageContext.request.contextPath}/caipiaodian.do?p=addcaipiaolisting',
		type:'post',
		data:{
			name:name,
			type:type,
			price:price,
			begintime:begintime,
			endtime:endtime,
			status:status,
			kaijiangtime:kaijiangtime,
			jiangchi:jiangchi,
		},
		success:function(data){
			alert(data);
			layer_close();
		}
	
	});
	});
	
	</script>
</body>

</html>
