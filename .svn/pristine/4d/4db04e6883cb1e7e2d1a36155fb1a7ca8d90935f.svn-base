
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
<title>开奖纪录 - 修改开奖纪录- ShuangSeQiu.admin v2.4</title>

</head>
<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-qiuhao-add">
			<input type="hidden" name="id" value="${param.id }" />
			<c:forEach items="${list }" var="z">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>开奖时间：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							type="text" id="commentdatemin" name="commentdatemin"
							class="input-text Wdate" value="${z.kaijiangTime }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>开奖期数：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" placeholder="开奖期数"
							id="Qishu" name="Qishu" value="${z.qihao }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第一个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第一个红球" id="oneRed" name="oneRed"
							value="${z.hongqiu1 }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第二个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第二个红球" id="twoRed" name="twoRed"
							value="${z.hongqiu2 }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第三个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第三个红球" id="threeRed" name="threeRed"
							value="${z.hongqiu3 }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第四个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第四个红球" id="fourRed" name="fourRed"
							value="${z.hongqiu4}">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第五个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第五个红球" id="fiveRed" name="fiveRed"
							value="${z.hongqiu5 }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>第六个红球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="第六个红球" id="sixRed" name="sixRed"
							value="${z.hongqiu6 }">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-4"><span
						class="c-red">*</span>蓝球：</label>
					<div class="formControls col-xs-4 col-sm-4">
						<input type="text" class="input-text" autocomplete="off"
							placeholder="蓝球球号" id="Blue" name="Blue" value="${z.lanqiu }">
					</div>
				</div>
			</c:forEach>
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
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-qiuhao-add").validate({
		rules:{
			commentdatemin:{
				required:true,
			},
			Qishu:{
				required:true,
			},
			oneRed:{
				required:true,
				min:1,
				max:33,
			},
			twoRed:{
				required:true,
				min:1,
				max:33,
			},
			threeRed:{
				required:true,
				min:1,
				max:33,
			},
			fourRed:{
				required:true,
				min:1,
				max:33,
			},
			fiveRed:{
				required:true,
				min:1,
				max:33,
			},
			sixRed:{
				required:true,
				min:1,
				max:33,
			},
			Blue:{
				required:true,
				min:1,
				max:16,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${pageContext.request.contextPath}/caipiao.do?p=updatekaijiang" ,
				success: function(data){
					layer.msg('修改成功!',{icon:6,time:1000});
					setTimeout(function(){window.parent.location.reload();},1000);

				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:2,time:1000});
				}
			});
		}
	
	});
});
</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
