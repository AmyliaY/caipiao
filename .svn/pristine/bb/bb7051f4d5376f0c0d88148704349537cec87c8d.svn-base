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

<title>订单</title>
<meta name="keywords"
	content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">

</head>
<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		充值管理 <span class="c-gray en">&gt;</span> 用户所有充值记录 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<form
			action="${pageContext.request.contextPath}/goodsorder.do?p=orderslisting"
			method="post" name="f" id="f" autocomplete="off">
			<div class="text-c">
				日期范围： <input type="text"
					onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })"
					id="datemin" name="mintime" class="input-text Wdate"
					style="width:120px;"> - <input type="text"
					onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
					id="datemax" name="maxtime" class="input-text Wdate"
					style="width:120px;"> <input type="text" class="input-text"
					style="width:250px" placeholder="订单号" id="kjQishu" name="id">
				<button type="submit" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe665;</i> 搜用户订单
				</button>
			</div>
		</form>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l" style="position: relative;left: 20px"> <a
				href="javascript:;" onclick="plshanchu()"
				class="btn btn-danger radius">批量删除</a></span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="40"><input type="checkbox"></th>
						<th width="120">订单持续时间</th>
						<th width="65">用户手机号</th>
						<th width="65">金额</th>
						<th width="65">状态</th>
						<th width="120">订单开始时间</th>
						<th width="120">订单结束时间</th>
						<th width="65">注数</th>
						<th width="65">接单彩票店1</th>
						<th width="65">接单彩票店2</th>
						<th width="65">接单彩票店3</th>
						<th width="65">接单彩票店4</th>
						<th width="65">接单彩票店5</th>
						<th width="65">实际中标彩票店</th>
						<th width="65">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${map.list}" var="cz" varStatus="i">
						<tr class="text-c">
							<td><input type="checkbox" name="mykjid" value="${cz.id }"></td>
							<td><fmt:formatDate value="${cz.time}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${cz.users.phone}</td>
							<td>${cz.money}</td>
							<td><c:if test="${cz.status==0 }">
									<span class="label label-default radiu">未付款</span>
								</c:if> <c:if test="${cz.status==1 }">
									<span class="label label-default radiu">待发货</span>
								</c:if> <c:if test="${cz.status==2 }">
									<span class="label label-success radiu">已发货</span>
								</c:if></td>

							<td>${cz.begintime}</td>
							<td>${cz.endtime}</td>
							<td>${cz.num}</td>
							<td>${cz.caipiaodianByCpzid1.phone}</td>
							<td>${cz.caipiaodianByCpzid2.phone}</td>
							<td>${cz.caipiaodianByCpzid3.phone}</td>
							<td>${cz.caipiaodianByCpzid4.phone}</td>
							<td>${cz.caipiaodianByCpzid5.phone}</td>
							<td>${cz.caipiaodianByCpzid.phone}</td>
							<td><a href="javascript:;"
								onclick="goodsorder_update('修改开奖纪录','${pageContext.request.contextPath}/goodsorder.do?p=getgoodsorderById&id=${cz.id }','800','550')">编辑</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js">
</script>
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
	<script type="text/javascript">
/* JQuery自带的分页查询*/
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[2,3,4,5,6,7,8,9,10,11,12,13,14]}// 制定列不参与排序
		]
	});
});

/*批量删除*/
function plshanchu(){
	var checkboxNum = $("input[name=mykjid]:checked").length;
	if(checkboxNum==0)
	{
		layer.msg("请勾选要删除的订单",{icon:6,time:1000});
		return false;
	}
	var checkboxList=new Array();
	$("input[name=mykjid]:checked").each(function(){
		checkboxList.push($(this).val());
	});
	layer.confirm("确定要删除吗",function(index){
		$.ajax({
			url:"${pageContext.request.contextPath}/goodsorder.do?p=delete",
			type:"post",
			data:{"kjId":checkboxList.toString()},
			success:function(data){
				layer.msg("批量删除成功!",{icon:6,time:1000});
				location.replace(location.href);
			}
		});
	});
}
function chongzhijilu_update(title,url,w,h)
{
	layer_show(title, url, w, h);
}
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
function goodsorder_update(title,url,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>