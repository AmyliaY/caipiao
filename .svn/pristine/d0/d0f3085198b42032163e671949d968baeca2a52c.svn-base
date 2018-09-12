<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--  修改微信参数 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/html5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/respond.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/PIE_IE678.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib//lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib//lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib//skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/lib/layer/2.1/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/js/H-ui.admin.js"></script>


<style>
body, html {
	
}
</style>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		微信设置 <span class="c-gray en">&gt;</span>微信参数
	</nav>

	<div class="pd-20">
		<div class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-4"> <span class="c-red">*</span>APP_ID：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${wxmap.appid}"
						placeholder="" id="appid" onkeyup=value
						= value.replace(/[\W]/g, '');
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
						name="appid">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>APP秘钥：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${wxmap.appsecret}"
						placeholder="" id="appsecret" onkeyup=value
						= value.replace(/[\W]/g, '');
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
						name="appsecret">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>商户号：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${wxmap.mchid}"
						placeholder="" id="mchid" onkeyup=value
						= value.replace(/[^\d]/g, '');
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
						name="mchid">
				</div>
				<div class="col-4"></div>
			</div>

			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>支付密钥：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${wxmap.paykey}"
						placeholder="" id="paykey" onkeyup=value
						= value.replace(/[\W]/g, '');
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
						name="paykey">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>Token：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${wxmap.token}"
						placeholder="" id="token" onkeyup=value
						= value.replace(/[\W]/g, '');
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
						name="token">
				</div>
				<div class="col-4"></div>
				<div class="formControls" style="margin-top: 60px; margin-left:7%">
					<label class="form-label col-4">当前状态&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<c:choose>
							<c:when test="${wxmap.status==1}">
								<span style="color: red">已启用</span>
							</c:when>
							<c:otherwise>
								<span style="color: red">已禁用</span>
							</c:otherwise>
						</c:choose> </a></label>
				</div>
			</div>
			<div class="row cl" style="margin-top: -20px; margin-left: 53%">
				<div class="col-8 col-offset-4" style="margin-left: 5%;">
					<a style="text-decoration: none;" class="btn btn-primary radius"
						onclick="xiugai_status(this,${wxmap.status})"
						href="javascript:void(0)" title="修改状态"><c:choose>
							<c:when test="${wxmap.status==0}">
												&nbsp;&nbsp;启  用&nbsp;&nbsp;
											</c:when>
							<c:otherwise>
												&nbsp;&nbsp;禁  用&nbsp;&nbsp;
											</c:otherwise>
						</c:choose> </a> <input class="btn btn-primary radius" onclick="return tijiao()"
						type="submit" value="&nbsp;&nbsp;保 存&nbsp;&nbsp;">
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function xiugai_status(a,status)
	{
		var url="${pageContext.request.contextPath}/weixinpaycs.do?p=editStatus";
		var param={status:status};
		$.post(url,param,function(data){
			location.replace(location.href);
		});
	}
	function tijiao()
	{
		var appid=$("#appid").val();
		if(appid==null || ""==appid)
		{
			layer.msg("请输入   APP_ID",{icon:6,time:1000});
			return false;
		}
		var appsecret=$("#appsecret").val();
		if(appsecret==null || ""==appsecret)
		{
			layer.msg("请输入   APP秘钥",{icon:6,time:1000});
			return false;
		}
		var mchid=$("#mchid").val();
		if(mchid==null || ""==mchid)
		{
			layer.msg("请输入   商户号",{icon:6,time:1000});
			return false;
		}
		var paykey=$("#paykey").val();
		if(paykey==null || ""==paykey)
		{
			layer.msg("请输入   支付秘钥",{icon:6,time:1000});
			return false;
		}
		var token=$("#token").val();
		if(token==null || ""==token)
		{
			layer.msg("请输入   TOKEN",{icon:6,time:1000});
			return false;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/weixinpaycs.do?p=editwinxinpay",
			type:"post",
			data:{appid:appid,appsecret:appsecret,mchid:mchid,paykey:paykey,token:token},
			success:function()
			{
				layer.confirm("确定保存微信参数吗？",function(){
					layer.msg("保存成功！",{icon:6,time:1000},function(){
						location.replace(location.href);
					});
				});
			}
		});
	}
	</script>
</html>