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
	href="${pageContext.request.contextPath }/lib/lib/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>修改基础参数</title>
</head>
<body>
	<div class="pd-20">
		<div class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>金额：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" onblur="yz_uname()"
						value="${map.price}" placeholder="" id="price" name="price">
				</div>
				<div class="col-4" id="divuname"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>积分：</label>
				<div class="formControls col-5" id="zzzz">
					<input type="text" class="input-text" onblur="yz_name()"
						value="${map.jifen}" placeholder="" id="jifen" name="jifen">
				</div>
				<div class="col-4" id="nono"></div>
			</div>
			<div class="row cl">
				<div class="col-9 col-offset-3">
					<input class="btn btn-primary radius" id="sub"
						onclick="return yz_tiaojiao()" type="submit"
						value="&nbsp;&nbsp;设置&nbsp;&nbsp;">
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/layer/2.1/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.admin.js"></script>
	<script type="text/javascript">
//提交时验证是否为null
function yz_tiaojiao()
{	
	var price=$("#price").val();
	var jifen=$("#jifen").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/jccs.do?p=editjccs&type=${map.type}",
		data:{price:price,jifen:jifen},
		type:"post",
		success:function(data){
		    layer.msg("设置成功",{icon:6,time:1000});
			//location.replace(location.href);
		}
	});
}
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
</script>
</body>
</html>