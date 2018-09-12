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
</style>
</head>

<body>
	<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">手机号：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="shoujihao" />
	</div>

	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">密码：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="password" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">店铺名：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="stores" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">省份：</p>
	</div>
	<div class="col-10">
		<select class="select" id="sheng" style="height: 30px;"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">城市：</p>
	</div>
	<div class="col-10">
		<select class="select" id="city" style="height: 30px;"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">区：</p>
	</div>
	<div class="col-10">
		<select class="select" id="qu" style="height: 30px;"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">详细地址：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="address" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">经度：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="jingdu" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">纬度：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="weidu" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">是否体彩：</p>
	</div>
	<div class="col-10">
		<select class="select" id="ticai" style="height: 30px;">
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">是否福彩：</p>
	</div>
	<div class="col-10">
		<select class="select" id="fucai" style="height: 30px;">
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">可提现金额：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="tixian" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">开始营业时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="begintime" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">结束营业时间</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="endtime" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">注册时间</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="time" />
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
  	$("#sheng").click(function()
  	{
  	
  	var id = $("#sheng").val();
		
		$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=citylisting",
		type:"post",
		data:{
		id:id,
		},
		success:function(data)
		{
		var json = eval('('+data+')')
		$("#city").html("");
		for(var i = 0 ; i<json.length ; i++)
		{
			
			$("#city").append('<option value= '+json[i].ctId + '>' +json[i].ctName+'</option>')
		}
		var id = $("#city").val();
		$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=qulisting",
		type:"post",
		data:{
		id:id,
		},
		success:function(data)
		{
		var json = eval('('+data+')');
		$("#qu").html("");
		for(var i = 0 ; i<json.length ; i++)
		{
			
			$("#qu").append('<option value= '+json[i].arId + '>' +json[i].arName+'</option>')
		}
			
		}
		});
		}
		});
  	
  	}
  	);
  $("#city").click(function()
  {
  
  var id = $("#city").val();
		$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=qulisting",
		type:"post",
		data:{
		id:id,
		},
		success:function(data)
		{
		var json = eval('('+data+')')
		$("#qu").html("");
		for(var i = 0 ; i<json.length ; i++)
		{
			
			$("#qu").append('<option value= '+json[i].arId + '>' +json[i].arName+'</option>')
		}
			
		}
		});
  });

	window.onload=function()
	{
	$.ajax({
	url:"${pageContext.request.contextPath}/caipiaodian.do?p=arealisting",
	type:"post",
	success:function(data)
	{
	var json = eval('('+data+')')
	for(var i = 0 ; i<json.length ; i++)
	{
		$("#sheng").append('<option value= '+json[i].prId + '>' +json[i].prName+'</option>');
	}
		var id = $("#sheng").val();
		
		$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=citylisting",
		type:"post",
		data:{
		id:id,
		},
		success:function(data)
		{
		var json = eval('('+data+')')
		for(var i = 0 ; i<json.length ; i++)
		{
			$("#city").append('<option value= '+json[i].ctId + '>' +json[i].ctName+'</option>')
		}
		var id = $("#city").val();
		$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=qulisting",
		type:"post",
		data:{
		id:id,
		},
		success:function(data)
		{
		var json = eval('('+data+')')
		for(var i = 0 ; i<json.length ; i++)
		{
			$("#qu").append('<option value= '+json[i].arId + '>' +json[i].arName+'</option>')
		}
			
		}
		});
		}
		});
	}
	});
	获取相应的值的方法:  
  
	// Get object of URL parameters    
  
	// Getting URL var by its nam  
	var id = $.getUrlVar('id');
	$.ajax({
	url:"${pageContext.request.contextPath}/caipiaodian.do?p=dianlisting",
	type:"post",
	data:{
	id:id,
	},
	success:function(data)
	{
	var json = eval('('+data+')')
	$("#shoujihao").val(json.phone);
	$("#password").val(json.password);
	$("#stores").val(json.name);
	$("#sheng").val(json.area.city.provice.prName);
	$("#address").val(json.address);
	$("#jingdu").val(json.jingdu);
	$("#weidu").val(json.weidu);
	$("#ticai").val(json.isticai);
	$("#fucai").val(json.isfucai);
	$("#tixian").val(json.ketixian);
	$("#begintime").val(json.begingtime);
	$("#endtime").val(json.endtime);
	$("#time").val(json.time);
	}
	});
	
	
	}
	$("#tijiao").click(
	function(){
		var id = $.getUrlVar('id'); 
		var shoujihao = $("#shoujihao").val();
		var password = $("#password").val();
		var stores = $("#stores").val();
		var qu = $("#qu").val();
		var address = $("#address").val();
		var jingdu = $("#jingdu").val();
		var weidu = $("#weidu").val();
		var isticai = $("#ticai").val();
		var isfucai = $("#fucai").val();
		var tixian = $("#tixian").val();
		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();
		var time = $("#time").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingupdate",
		type:"post",
		data:{
			id:id,
			shoujihao:shoujihao,
			password:password,
			stores:stores,
			qu:qu,
			address:address,
			jingdu:jingdu,
			weidu:weidu,
			isticai:isticai,
			isfucai:isfucai,
			tixian:tixian,
			begintime:begintime,
			endtime:endtime,
			time:time,
		},
	success:function(data)
	{
		alert(data);
		window.location.href="${pageContext.request.contextPath}/admin/caipiaodian/caipiaodianlisting.jsp";         
	}
	
	});
	}
	);
</script>
</body>
</html>
