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
		<p style="line-height: 30px;vertical-align: middle;">彩票一级分类：</p>
	</div>
	<div class="col-10">
		<select class="select" id="type"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票二级分类：</p>
	</div>
	<div class="col-10">
		<select class="select" id="type2"></select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票名字：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="name" />
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
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="begintime" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">下架时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="endtime" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">彩票状态：</p>
	</div>
	<div class="col-10">
		<select class="select" id="status">
			<option value="0">下架</option>
			<option value="1">上架</option>
		</select>
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">奖池：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="jiangchi" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">开奖时间：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
			id="kaijiangtime" />
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
  window.onload = function ()
	{
	$.ajax({
			url:'${pageContext.request.contextPath }/caipiaodian.do?p=addcaipiaolisting_leixing',
			type:'post',
			success:function(data){
			var json = eval(data);
			
			for(var i = 0 ; i < json.length ; i++)
			{
				$("#type").append('<option value='+json[i].id+'>'+json[i].mingcheng+'</option>');
			}
			}
		});
		$.ajax({
			url:'${pageContext.request.contextPath }/caipiaodian.do?p=addcaipiaolisting_leixing2',
			type:'post',
			success:function(data){
			alert(data)
			var json = eval(data);
			
			for(var i = 0 ; i < json.length ; i++)
			{
				$("#type2").append('<option value='+json[i].id+'>'+json[i].name+'</option>');
			}
			}
		});
		var id= $.getUrlVar('id');
		$.ajax({
			url:'${pageContext.request.contextPath }/caipiaodian.do?p=caipiao_biji_data',
			type:'post',
			data:{
			id:id,
			},
			success:function(data){
			alert(data)
			var json = eval('('+data+')')
			$("#type").val(json.caipiaobiao.caipiaoLeixing.id);
			$("#type1").val(json.caipiaobiao.name);
			$("#name").val(json.name);
			$("#price").val(json.price);
			
			$("#begintime").val(json.begintime);
			$("#endtime").val(json.endtime);
			$("#kaijiangtime").val(json.kaijiangtime);
			
			$("#jiangchi").val(json.jiangchi);
			$("#status").val(json.status);
			}
		});
		
		
	}
	$("#tijiao").click(function()
	{
	var id= $.getUrlVar('id');
	var name = $("#name").val();
	var type = $("#type").val();
	var type2 = $("#type2").val();
	var price = $("#price").val();
	var begintime = $("#begintime").val();
	var endtime = $("#endtime").val();
	var status = $("#status").val();
	var kaijiangtime = $("#kaijiangtime").val();
	var jiangchi = $("#jiangchi").val();
	$.ajax({
		url:'${pageContext.request.contextPath}/caipiaodian.do?p=caipiao_biji_insert',
		type:'post',
		data:{
			id:id,
			name:name,
			type:type,
			type2:type2,
			price:price,
			begintime:begintime,
			endtime:endtime,
			status:status,
			kaijiangtime:kaijiangtime,
			jiangchi:jiangchi,
		},
		success:function(data){
			alert(data);
			window.location.href="${pageContext.request.contextPath}/caipiaodian.do?p=caipiaolisting";
		}
	
	});
	});
  
  </script>
</body>


</html>
