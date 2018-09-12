<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
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

<title>易乐宝-超级管理员后台</title>
<meta name="keywords"
	content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<c:if test="${empty admin}">
		<c:redirect url="/admin/login.jsp"></c:redirect>
	</c:if>
	<header class="Hui-header cl">
		<a class="Hui-logo l" title="超级管理员后台" href="/">超级管理员后台</a> <a
			class="Hui-logo-m l" href="/" title="H-ui.admin">H-uihit</a> <span
			class="Hui-subtitle l">V1.0</span>
		<nav class="mainnav cl" id="Hui-nav"></nav>
		<ul class="Hui-userbar">
			<li>${admin.name}</li>
			<li class="dropDown dropDown_hover"><a href="#"
				class="dropDown_A">${admin.username} <i class="Hui-iconfont">&#xe6d5;</i>
			</a>
				<ul class="dropDown-menu radius box-shadow">
					<li><a onclick="showMessage(this)" target="iframe_box"
						_href="${pageContext.request.contextPath }/admin.do?p=editpwd&id=${admin.id}"
						title="修改密码">修改密码 </a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/login.jsp">切换账户</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/admin.do?p=tuichu">退出</a>
					</li>
				</ul></li>
			<li id="Hui-msg"><a onclick="showMessage(this)"
				target="iframe_box"
				_href="${pageContext.request.contextPath }/uamessages.do?p=messageslisting"
				title="消息"><span id="msgsum" class="badge badge-danger"></span><i
					class="Hui-iconfont" style="font-size: 18px">&#xe68a;</i> </a></li>
			<li id="Hui-skin" class="dropDown right dropDown_hover"><a
				href="javascript:;" title="换肤"><i class="Hui-iconfont"
					style="font-size: 18px">&#xe62a;</i> </a>
				<ul class="dropDown-menu radius box-shadow">
					<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
					</li>
					<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
					<li><a href="javascript:;" data-val="green" title="绿色">绿色</a>
					</li>
					<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
					<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
					</li>
					<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a>
					</li>
				</ul></li>
		</ul>
		<a href="javascript:;" class="Hui-nav-toggle Hui-iconfont"
			aria-hidden="false">&#xe667;</a>
	</header>
	<aside class="Hui-aside">
		<input runat="server" id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe67f;</i> 基础参数 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/jccs.do?p=jccs&type=1"
							data-title="会员购物赠送多少积分">会员购物赠送多少积分</a> <a
							_href="${pageContext.request.contextPath}/jccs.do?p=jccs&type=2"
							data-title="下线购物赠送多少积分">下线购物赠送多少积分</a> <a
							_href="${pageContext.request.contextPath}/jccs.do?p=jccs&type=3"
							data-title="每积分抵扣多少人民币">每积分抵扣多少人民币</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe62d;</i> 管理员管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/admin.do?p=adminlisting"
							data-title="管理员列表">管理员列表</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe6cc;</i> 会员管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/users.do?p=userlisting"
							data-title="会员列表">会员列表</a></li>
					</ul>
				</dd>
			</dl>

			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe63a;</i> 财务管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/userscaiwu.do?p=userscaiwu"
							data-title="会员财务">会员财务</a> <a
							_href="${pageContext.request.contextPath}/userscaiwu.do?p=userschongzhi"
							data-title="会员充值">会员充值</a> <a
							_href="${pageContext.request.contextPath}/userscaiwu.do?p=usersxiaofei"
							data-title="会员消费">会员消费</a> <a
							_href="${pageContext.request.contextPath}/userscaiwu.do?p=storescaiwu"
							data-title="门店财务">门店财务</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-product">
				<dt>
					<i class="Hui-iconfont">&#xe620;</i> 彩票店管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/caipiaodian.do?p=shenhe"
							data-title="彩票店审核" href="javascript:void(0)">彩票店审核</a> <a
							_href="${pageContext.request.contextPath}/caipiaodian.do?p=shenhejvjuelisting"
							data-title="彩票店审核已拒绝" href="javascript:void(0)">彩票店审核已拒绝</a> <a
							_href="${pageContext.request.contextPath}/admin/caipiaodian/caipiaodianlisting.jsp"
							data-title="彩票店列表" href="javascript:void(0)">彩票店列表</a>
					</ul>
				</dd>
			</dl>
			<dl id="menu-product">
				<dt>
					<i class="Hui-iconfont">&#xe620;</i> 彩票管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/caipiaodian.do?p=caipiao_leixinglisting"
							data-title="彩票类型列表" href="javascript:void(0)">彩票类型列表</a> <a
							_href="${pageContext.request.contextPath}/caipiaodian.do?p=caipiaolisting"
							data-title="彩票管理" href="javascript:void(0)">彩票管理</a> <a
							_href="${pageContext.request.contextPath}/caipiao.do?p=xuangseqiulisting"
							data-title="双色球录入" href="javascript:void(0)">双色球录入</a>
						<li>
					</ul>
				</dd>
			</dl>





			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe6a9;</i> 订单管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/goodsorder.do?p=orderslisting"
							data-title="所有订单">所有订单</a> <a
							_href="${pageContext.request.contextPath}/goodsorder.do?p=orderslisting&status=0"
							data-title="未付款订单" href="javascript:void(0)">未付款订单</a> <a
							_href="${pageContext.request.contextPath}/goodsorder.do?p=orderslisting&status=1"
							data-title="待发货订单" href="javascript:void(0)">待发货订单</a> <a
							_href="${pageContext.request.contextPath}/goodsorder.do?p=orderslisting&status=2"
							data-title="已发货订单" href="javascript:void(0)">已发货订单</a></li>
					</ul>
				</dd>
			</dl>

			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe71d;</i> 充值管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/chongzhirecord.do?p=chongzhilisting"
							data-title="所有充值记录">会员充值记录</a> <a
							_href="${pageContext.request.contextPath}/cpdchongzhirecord.do?p=cpdchongzhilisting"
							data-title="所有充值记录">彩票店充值记录</a> <a
							_href="${pageContext.request.contextPath}/users.do?p=userlisting&type=1"
							data-title="会员充值链接">会员充值链接</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe71f;</i> 支付管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/weixinpaycs.do?p=weixinpaycs"
							data-title="微信参数">微信参数</a> <a
							_href="${pageContext.request.contextPath}/alipaycs.do?p=alipaycs"
							data-title="支付宝参数">支付宝参数</a></li>
					</ul>
				</dd>
			</dl>



			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe6d3;</i> APP版本管理 <i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a
							_href="${pageContext.request.contextPath}/app.do?p=applisting"
							data-title="APP版本列表">APP版本列表</a> <a
							_href="${pageContext.request.contextPath}/admin/app_upgrade/addAPP.jsp"
							data-title="上传APP更新包">上传APP更新包</a></li>
					</ul>
				</dd>
			</dl>

		</div>
	</aside>
	<div class="dislpayArrow">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em>
					</li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i> </a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i> </a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0"
					src="${pageContext.request.contextPath}/tongji.do?p=tongjilisting"></iframe>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/layer/2.1/layer.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.js">
</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.admin.js">
</script>
	<script type="text/javascript">
$(document).ready(function(){
	msg();
});
function msg()
{
	$.ajax({
		url:"${pageContext.request.contextPath}/uamessages.do?p=msgtishi",
		type:"post",
		success:function(data)
		{
			$("#msgsum").html(""+data+"");
		}
	});
}
		
		
/*用户-编辑*/
function member_edit(title, url, id, w, h) {
	layer_show(title, url, w, h);
}
/*房间-查看*/
function member_show(title, url, id, w, h) {
	layer_show(title, url, w, h);
}
/*资讯-添加*/
function article_add(title, url) {
	var index = layer.open( {
		type : 2,
		title : title,
		content : url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title, url) {
	var index = layer.open( {
		type : 2,
		title : title,
		content : url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title, url) {
	var index = layer.open( {
		type : 2,
		title : title,
		content : url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title, url, w, h) {
	layer_full(title, url, w, h);
}

function member_add(title, url, w, h) {
	layer_show(title, url, w, h);
}
</script>
	<script type="text/javascript">
function showMessage(a) {
	var _href = $(a).attr('_href');
	var topWindow = $(window.parent.document);
	var iframe_box = $(window.parent.document.getElementById("iframe_box"))
			.find("iframe");
	iframe_box.attr("src", _href);
}
</script>
</body>
</html>
