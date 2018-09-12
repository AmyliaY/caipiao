<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark"
	href="${pageContext.request.contextPath }/lib/favicon.ico">
<LINK rel="Shortcut Icon"
	href="${pageContext.request.contextPath }/lib/favicon.ico" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/html5.js">
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/respond.min.js">
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/PIE_IE678.js">
</script>
<link href="${pageContext.request.contextPath }/lib/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/lib/css/H-ui.admin.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/skin/default/skin.css"
	rel="stylesheet" type="text/css" id="skin" />
<link href="${pageContext.request.contextPath }/lib/css/style.css"
	rel="stylesheet" type="text/css" />
<LINK rel="Bookmark" href="/favicon.ico">
<LINK rel="Shortcut Icon" href="/favicon.ico" />


<link href="${pageContext.request.contextPath }/lib/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/lib/css/H-ui.admin.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/skin/default/skin.css"
	rel="stylesheet" type="text/css" id="skin" />
<link href="${pageContext.request.contextPath }/lib/css/style.css"
	rel="stylesheet" type="text/css" />

<title>双色球录入</title>
<meta name="keywords"
	content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-qiuhao-add">

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>开奖时间：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text"
						onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						id="commentdatemin" name="commentdatemin" class="input-text Wdate">
				</div>
			</div>


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>开奖期数：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<c:if test="${not empty maxqishulist}" var="f">
						<c:forEach items="${maxqishulist}" var="qs" varStatus="status">
							<input type="text" class="input-text" value="${qs+1}"
								placeholder="开奖期数" id="Qishu" name="Qishu">
						</c:forEach>
					</c:if>
					<c:if test="${not f}">
						<input type="text" class="input-text" value="" placeholder="开奖期数"
							id="Qishu" name="Qishu">
					</c:if>
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第一个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第一个红球" id="oneRed" name="oneRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第二个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第二个红球" id="twoRed" name="twoRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第三个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第三个红球" id="threeRed" name="threeRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第四个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第四个红球" id="fourRed" name="fourRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第五个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第五个红球" id="fiveRed" name="fiveRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>第六个红球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="第六个红球" id="sixRed" name="sixRed">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-4"><span
					class="c-red">*</span>蓝球：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" autocomplete="off"
						placeholder="蓝球球号" id="Blue" name="Blue">
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
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/icheck.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/validate.js">

</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/admin/js/jquery.form.js"></script>
	<script type="text/javascript">
	$(function() {
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});

		$("#form-qiuhao-add").validate({
			rules : {
				commentdatemin : {
					required : true,
				},
				Qishu : {
					required : true,
				},
				oneRed : {
					required : true,
					min : 1,
					max : 33,
				},
				twoRed : {
					required : true,
					min : 1,
					max : 33,
				},
				threeRed : {
					required : true,
					min : 1,
					max : 33,
				},
				fourRed : {
					required : true,
					min : 1,
					max : 33,
				},
				fiveRed : {
					required : true,
					min : 1,
					max : 33,
				},
				sixRed : {
					required : true,
					min : 1,
					max : 33,
				},
				Blue : {
					required : true,
					min : 1,
					max : 16,
				},
			},
			onkeyup : false,
			focusCleanup : true,
			success : "valid",
			submitHandler : function(form) {
				
				$(form).ajaxSubmit({
					type : 'post',
					url : '${pageContext.request.contextPath}/caipiao.do?p=addQiuhao',
					success : function(data) {
						layer.msg('添加成功!', {
							icon : 6,
							time : 1000
						});
						setTimeout(function() {
							window.parent.location.reload();
						}, 1000);

					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
						layer.msg('error!', {
							icon : 2,
							time : 1000
						});
					}
				});
			}
		});
	});
</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
