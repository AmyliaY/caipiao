<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.util.JsonFilter"%>
<%@page import="net.sf.json.JsonConfig"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/css/css.css"
	rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>彩票店列表</title>
</head>
<%  if (session.getAttribute("admin")==null) response.sendRedirect(request.getContextPath()+"/admin/login.jsp");%>
<body>

	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		彩票店管理 <span class="c-gray en">&gt;</span> 彩票店列表 <a
			class="btn btn-success radius r mr-20"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i> </a>
	</nav>
	<div class="pd-20">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"> <select id="store">
					<option value="0">体彩店</option>
					<option value="1">福彩店</option>
					<option value="2">未定义</option>
			</select>
			</span> <span class="r">共有数据：<strong id="sum">${caipiaodianmap.sum}</strong>
				条
			</span>
		</div>
		<div class="mt-20">
			<table id="tab"
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="40">序号</th>
						<th width="40">手机号</th>
						<th width="40">密码</th>
						<th width="40">店名</th>
						<th width="40">所在区</th>
						<th width="40">详细地址</th>
						<th width="40">经度</th>
						<th width="40">纬度</th>

						<th width="40">是否体彩</th>
						<th width="40">是否福彩</th>
						<th width="40">注册时间</th>
						<th width="40">可提现金额</th>
						<th width="40">开始营业时间</th>
						<th width="40">结束营业时间</th>
						<th width="40">注册时间</th>
						<th width="40">操作</th>
					</tr>
				</thead>
				<tbody id="data">

				</tbody>
			</table>
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="6"><img src="../images/spacer.gif" width="1"
						height="1" /></td>
				</tr>
				<tr>
					<td height="33">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0" class="right-font08">
							<tr>
								<td width="50%">第 <span class="right-text09" id="page1">${ caipiaodianmap.page}</span>
									页 | 共 <span class="right-text09" id="pagecount">${caipiaodianmap.pagecount }</span>
									页
								</td>
								<td width="32%" align="right" id="xiugaitype">[
									<button class="right-font08" id="shouye">首页</button> |
									<button class="right-font08" id="last">上一页</button> |
									<button class="right-font08" id="next">下一页</button> |
									<button class="right-font08" id="moye">末页</button> ] 转至：
								</td>
								<td width="5%">
									<table width="20" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="1%" style="width:22px; "><input
												name="textfield3" type="text" id="page"
												value="${caipiaodianmap.page}" class="right-textfield03"
												size="3" /></td>
											<td width="87%"></td>
											<td width="87%"><input name="Submit23222" type="submit"
												value="GO" onclick="viewGo()" /></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
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
		//重置密码
		//页数跳转
		$("#moye").click(function()
		{
			var xuanze = $("#store").val();
			var page = document.getElementById("pagecount").value;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
			});
	$("#shouye").click(function()
		{
			var xuanze = $("#store").val();
			var page = document.getElementById("pagecount").value;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting&",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
			
			
		});
		$("#next").click(function()
		{
		var xuanze = $("#store").val();
			var page = document.getElementById("page1").innerHTML;
			page=page*1+1*1;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
	
		
		
		
		});
		$("#last").click(function()
		{
		var xuanze = $("#store").val();
			var page = document.getElementById("page1").innerHTML;
			page= page*1+1*1;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
	
		
		
		
		});
		$("#shouye").click(function()
		{
			var xuanze = $("#store").val();
			var page = document.getElementById("page1").value;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
	
			
			
		});
		
		function viewGo() {
			var xuanze = $("#store").val();
			var page = document.getElementById("page").value;
			$.ajax({
				url : "${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting",
				type : 'post',
				data : {
					xuanze : xuanze,
					page:page,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
						$("#data").html("");
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
	
		}
	
		window.onload = function() {
			var xuanze = $("#store").val();
			$.ajax({
				url : '${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting',
				type : 'post',
				data : {
					xuanze : xuanze,
				},
				success : function(data) {
					if (data != null) {
						var json = eval(data);
	
						for (var i = 0; i < json.length; i++) {
							$("#data").append(
								'<tr class="text-c">' +
								'<td>' +
								json[i].id +
								'</td>' +
								'<td>' +
								json[i].phone +
								'</td>' +
								'<td>' +
								json[i].password +
								'</td>' +
								'<td>' +
								json[i].name +
								'</td>' +
	
								'<td>' +
								json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
								'</td>' +
								'<td>' +
								json[i].address +
								'</td>' +
								'<td>' +
								json[i].jingdu +
								'</td>' +
								'<td>' +
								json[i].weidu +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisticai' + i + '" >' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isticai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
								'<td>' +
								'<span class="label label-default radius notisfucai' + i + '">' +
								'否' +
								'</span>' +
								'<span class="label label-success radius isfucai' + i + '">' +
								'是' +
								'</span>' +
								'</td>' +
	
								'<td>' +
								json[i].time +
								'</td>' +
	
								'<td>' +
								json[i].ketixian +
								'</td>' +
								'<td>' +
								json[i].begingtime +
								'</td>' +
								'<td>' +
								json[i].endtime +
								'</td>' +
								'<td>' +
								json[i].time +
								'</td>' +
								'<td>' +
								'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
								'编辑' +
								'</a>' +
								'</td>' +
								'</tr>'
							);
	
							if (json[i].isticai == 1) {
								$(".notisticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isticai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							}
	
							if (json[i].isfucai == 1) {
								$(".notisfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
	
	
								});
							} else {
								$(".isfucai" + i).each(function() {
									$(this).attr('style', 'display:none');
								});
							}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
						}
	
	
	
					}
				}
			});
	
	
		}
		$("#store").click(
			function() {
				var xuanze = $("#store").val();
				$.ajax({
					url : '${pageContext.request.contextPath}/caipiaodian.do?p=caipiaodianlisting',
					type : 'post',
					data : {
						xuanze : xuanze,
					},
					success : function(data) {
						if (data != null) {
							var json = eval(data);
							$("#data").html("");
							for (var i = 0; i < json.length; i++) {
	
								$("#data").append(
									'<tr class="text-c">' +
									'<td>' +
									json[i].id +
									'</td>' +
									'<td>' +
									json[i].phone +
									'</td>' +
									'<td>' +
									json[i].password +
									'</td>' +
									'<td>' +
									json[i].name +
									'</td>' +
	
									'<td>' +
									json[i].area.city.provice.prName + json[i].area.city.ctName + json[i].area.arName +
									'</td>' +
									'<td>' +
									json[i].address +
									'</td>' +
									'<td>' +
									json[i].jingdu +
									'</td>' +
									'<td>' +
									json[i].weidu +
									'</td>' +
									'<td>' +
									'<span class="label label-default radius notisticai' + i + '" >' +
									'否' +
									'</span>' +
									'<span class="label label-success radius isticai' + i + '">' +
									'是' +
									'</span>' +
									'</td>' +
									'<td>' +
									'<span class="label label-default radius notisfucai' + i + '">' +
									'否' +
									'</span>' +
									'<span class="label label-success radius isfucai' + i + '">' +
									'是' +
									'</span>' +
									'</td>' +
	
									'<td>' +
									json[i].time +
									'</td>' +
	
									'<td>' +
									json[i].ketixian +
									'</td>' +
									'<td>' +
									json[i].begingtime +
									'</td>' +
									'<td>' +
									json[i].endtime +
									'</td>' +
									'<td>' +
									json[i].time +
									'</td>' +
									'<td>' +
									'<a href="${pageContext.request.contextPath}/caipiaodian.do?p=dianlistingid&id=' + json[i].id + '" class="label label-success radius">' +
									'编辑' +
									'</a>' +
									'</td>' +
									'</tr>'
								);
	
								if (json[i].isticai == 1) {
									$(".notisticai" + i).each(function() {
										$(this).attr('style', 'display:none');
	
	
									});
								} else {
									$(".isticai" + i).each(function() {
										$(this).attr('style', 'display:none');
	
	
									});
								}
	
								if (json[i].isfucai == 1) {
									$(".notisfucai" + i).each(function() {
										$(this).attr('style', 'display:none');
	
	
									});
								} else {
									$(".isfucai" + i).each(function() {
										$(this).attr('style', 'display:none');
									});
								}
										$("#sum").text(json[i].sum);
										$("#page").val(json[i].page);
										$("#page1").text(json[i].page);
										$("#pagecount").text(json[i].pagecount);
							}
							
								
						}
					}
				});
	
			}
		);
	</script>