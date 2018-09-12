
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/lib/respond.min.js"></script>
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
<!--[if IE 6]>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>开奖纪录 - 修改开奖纪录- ShuangSeQiu.admin v2.4 ,</title>

</head>
<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-qiuhao-add">
			<input type="hidden" name="id" value="${param.id }" />
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>充值时间：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="time"
						class="input-text Wdate" value="${cpzchongzhijilu.time }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>商户手机号：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<select id="phone" name="phone" class="input-text"></select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>充值金额：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" name="money" class="input-text"
						value="${cpzchongzhijilu.money }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>状态：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<select name="status" class="input-text" id="status">
						<option value="0">成功</option>
						<option value="1">失败</option>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>充值类型：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<select name="type" class="input-text" id="type">
						<option value="0">微信</option>
						<option value="1">支付宝</option>
						<option value="2">银行卡</option>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>订单编号：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<select name="dingdanid" class="input-text" id="dingdanid">
					</select>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-4 col-sm-4 col-xs-offset-4 col-sm-offset-5">
					<input class="btn btn-primary radius" type="submit" id="add"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>

	</article>

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
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/icheck.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/validate.js">

</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/jquery.form.js"></script>
	<script type="text/javascript">
$(function(){
	$("#form-qiuhao-add").validate({

		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${pageContext.request.contextPath}/cpdchongzhirecord.do?p=bianji" ,
				success: function(data){
					layer.msg('修改成功!',{icon:6,time:1000});
					setTimeout(function(){window.parent.location.reload();},1000);

				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:2,time:1000});
				}
			});
		}
	
	})
	
	;
});
window.onload=function()
{
	
	var type = "${cpzchongzhijilu.type}";
	$("#type").val(type)
	var status = "${cpzchongzhijilu.status}";
	$("#status").val(status)
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/cpdchongzhirecord.do?p=getdingdanid',
		success:function(data)
		{
			var json = eval(data);
			for(var i=0;i<json.length;i++)
			$("#dingdanid").append(
				'<option value='+json[i].id+'>'+json[i].id+'</option>'
			);
		}
	});
	var dingdan = "${cpzchongzhijilu.dingdan}";
	$("#dingdan").val(dingdan)
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/cpdchongzhirecord.do?p=cpdphone',
		success:function(data)
		{
			var json = eval(data);
			for(var i=0;i<json.length;i++)
			$("#phone").append(
				'<option value='+json[i].phone+'>'+json[i].phone+'</option>'
			);
		}
	});
	var phone = "${cpzchongzhijilu.caipiaodian.phone}";
	$("#phone").val(phone)
}
</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>

</html>
