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
	width: 50%;
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
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">用户名：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="username" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">手机号：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="phone" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">密码：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="pwd" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">头像：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="touxiang" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">可用积分：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="jifen" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">冻结积分：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="dongjie" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">已提现金额：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="yitixian" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">开户银行：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="bank" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">银行账号：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="zhanghao" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">开户人：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="kaihuren" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">收藏店铺：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="shoucang" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">推荐店铺：</p>
	</div>
	<div class="col-10">
		<input type="text" class="input-text" id="tuijian" />
	</div>
	<div class="col-2">
		<p style="line-height: 30px;vertical-align: middle;">注册时间：</p>
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
  window.onload = function ()
	{
	var id = $.getUrlVar('id');
	var url = "${pageContext.request.contextPath}/users.do?p=userlisting_biji_json";
	$.getJSON(
	url,
	{id:id},
	function(json)
	{
		$("#username").val(json.name);
		$("#phone").val(json.phone);
		$("#pwd").val(json.password);
		$("#touxiang").val(json.touxiang);
		$("#jifen").val(json.jifen);
		$("#dongjie").val(json.dongji);
		$("#yitixian").val(json.yitixian);
		$("#bank").val(json.bank);
		$("#zhanghao").val(json.zhanghao);
		$("#kaihuren").val(json.xingming);
		$("#tuijian").val(json.tuijiandianpu)
		$("#shoucang").val(json.shoucangdianpu);
		$("#time").val(json.time);
	});
  }
  $("#tijiao").click(
  function(){
  		var url ="${pageContext.request.contextPath}/users.do?p=userlisting_biji_tijiao";
  		var id = $.getUrlVar('id');
  	    var username = $("#username").val();
		var phone = $("#phone").val();
		var pwd = $("#pwd").val();
		var touxiang = $("#touxiang").val();
		var jifen = $("#jifen").val();
		
		var dongjie = $("#dongjie").val();
		var yitixian = $("#yitixian").val();
		var bank = $("#bank").val();
		var zhanghao = $("#zhanghao").val();
		var kaihuren = $("#kaihuren").val();
		var tuijian = $("#tuijian").val();
		var shoucang = $("#shoucang").val();
		var time = $("#time").val();
		$.getJSON(
		url,
		{
		id:id,
		username:username,
		phone:phone,
		pwd:pwd,
		touxiang:touxiang,
		jifen:jifen,
		dongjie:dongjie,
		yitixian:yitixian,
		bank:bank,
		zhanghao:zhanghao,
		kaihuren:kaihuren,
		tuijian:tuijian,
		shoucang:shoucang,
		time:time,
		},
		function(json)
		{
			alert('编辑'+json.name+'的信息成功');
			window.location.href="${pageContext.request.contextPath}/users.do?p=userlisting";
			
  		});
  }
  );
  </script>
</body>



</html>
