<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--  修改支付宝参数 --%>
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
#tb_title {
	background: #BBDDE5;
	border-width: 1px;
	border-color: #F4FAFB;
	border-style: solid;
	text-align: center;
}
</style>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		支付宝设置 <span class="c-gray en">&gt;</span>支付宝参数
	</nav>

	<div class="pd-20">
		<div class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-4"> <span class="c-red">*</span>合作身份者ID(partner)：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${alipay.partner}"
						placeholder="" id="partner" name="partner">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>收款支付宝账号(seller_id：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${alipay.seller_id}"
						placeholder="" id="seller_id" name="seller_id">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>商户的私钥（key）：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${alipay.private_key}"
						placeholder="" id="private_key" name="private_key">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>支付宝的公钥：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text"
						value="${alipay.alipay_public_key}" placeholder=""
						id="alipay_public_key" name="alipay_public_key">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl" style="margin-top: 20px;">
				<label class="form-label col-4"> <span class="c-red">*</span>PC支付MD5：
				</label>
				<div class="formControls col-4">
					<input type="text" class="input-text" value="${alipay.md5_key}"
						placeholder="" id="md5_key" name="md5_key">
				</div>
				<div class="col-4"></div>
				<div class="formControls" style="margin-top: 60px; margin-left:7%">
					<label class="form-label col-4">当前状态&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<c:choose>
							<c:when test="${alipay.status==1}">
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
					<a style="text-decoration: none" class="btn btn-primary radius"
						onclick="xiugai_status(this,${alipay.status})"
						href="javascript:void(0)" title="修改状态"><c:choose>
							<c:when test="${alipay.status==0}">
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
		var url="${pageContext.request.contextPath}/alipaycs.do?p=editStatus";
		var param={status:status};
		$.post(url,param,function(data){
			location.replace(location.href);
		});
	}
	function tijiao()
	{
		var partner=$("#partner").val();
		if(partner==null || ""==partner)
		{
			layer.msg("请输入   合作身份者ID(partner)",{icon:6,time:1000});
			return false;
		}
		var seller_id=$("#seller_id").val();
		if(seller_id==null || ""==seller_id)
		{
			layer.msg("请输入   收款支付宝账号(seller_id)",{icon:6,time:1000});
			return false;
		}
		var private_key=$("#private_key").val();
		if(private_key==null || ""==private_key)
		{
			layer.msg("请输入   商户的私钥（key）",{icon:6,time:1000});
			return false;
		}
		var alipay_public_key=$("#alipay_public_key").val();
		if(alipay_public_key==null || ""==alipay_public_key)
		{
			layer.msg("请输入   支付宝的公钥",{icon:6,time:1000});
			return false;
		}
		var md5_key=$("#md5_key").val();
		if(md5_key==null || ""==md5_key)
		{
			layer.msg("请输入   PC支付MD5",{icon:6,time:1000});
			return false;
		}
		alert()
		$.ajax({
			url:"${pageContext.request.contextPath}/alipaycs.do?p=editalipay",
			type:"post",
			data:{partner:partner,seller_id:seller_id,private_key:private_key,alipay_public_key:alipay_public_key,md5_key:md5_key},
			success:function()
			{
				layer.confirm("确定保存支付宝参数吗？",function(){
					layer.msg("保存成功！",{icon:6,time:1000},function(){
						location.replace(location.href);
					});
				});
			}
		});
	}
</script>
</html>