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
</style>
</head>

<body>
	<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票类型：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="caipiao_leixing" />
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
$.extend({  
  getUrlVars: function(){  
    var vars = [], hash;  
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');  
    for(var i = 0; i < hashes.length; i++)  
    {  
      hash = hashes[i].split('=');  
      vars.push(hash[0]);  
      vars[hash[0]] = hash[1];  
    }  
    return vars;  
  },  
  getUrlVar: function(name){  
    return $.getUrlVars()[name];  
  }  
  
  });
	window.onload=function()
	{
		var id = $.getUrlVar("id");
		
		$.ajax({
			url:'${pageContext.request.contextPath}/caipiaodian.do?p=caipaio_leixinglistingjson',
			type:'post',
			data:{
			id:id
			},
		success:function(data)
		{
			var json = eval('('+data+')');
			$("#caipiao_leixing").val(json.mingcheng);
			$("#status").val(json.status);
		}
		});
	}
	$("#tijiao").click(function()
	{
	var id = $.getUrlVar("id");
	var caipiao_leixing = $("#caipiao_leixing").val();
	var status = $("#status").val();
	$.ajax({
	url:"${pageContext.request.contextPath}/caipiaodian.do?p=caipiao_leixing_bianji",
	type:"post",
	data:{
	id:id,
	caipiao_leixing:caipiao_leixing,
	status:status,
	},
	success:function(data)
	{
	alert(data);
	window.location.href="${pageContext.request.contextPath}/caipiaodian.do?p=caipiao_leixinglisting";
	}
	});
	
	});
</script>
</body>
</html>
