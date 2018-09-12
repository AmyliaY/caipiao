
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
	var url = "${pageContext.request.contextPath}/userscaiwu.do?p=userscaiwu_bianji_json";
	$.getJSON(
	url,
	{id:id},
	function(json)
	{
		$("#username").val(json.name);
		$("#phone").val(json.phone);
		$("#touxiang").val(json.touxiang);
		$("#jifen").val(json.jifen);
		$("#dongjie").val(json.dongji);
		$("#yitixian").val(json.yitixian);
	});
  }
  $("#tijiao").click(
  function(){
  		var url ="${pageContext.request.contextPath}/userscaiwu.do?p=userscaiwu_bianji_tijiao";
  		var id = $.getUrlVar('id');
  	    var username = $("#username").val();
		var phone = $("#phone").val();
		var touxiang = $("#touxiang").val();
		var jifen = $("#jifen").val();
		var dongjie = $("#dongjie").val();
		var yitixian = $("#yitixian").val();
		$.ajax({
		url:url,
		type:'post',
		data:
		{
		id:id,
		username:username,
		phone:phone,
		touxiang:touxiang,
		jifen:jifen,
		dongjie:dongjie,
		yitixian:yitixian,
		},
		success:function(data)
		{
		
			layer.msg('修改成功!',{icon:6,time:1000});
					setTimeout(function(){window.parent.location.reload();},1000);
			
  		}
  });
  });
  
  </script>
</body>



</html>
