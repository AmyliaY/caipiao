<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/admin/css/webuploader.css"
	type="text/css"></link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/lib/layui/css/layui.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/lib/webuploader/0.1.5/webuploader.min.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title></title>
<style type="text/css">
#filePicker {
	float: right
}
</style>
</head>
<body>
	<article class="page-container">
		<form class="layui-form" id="appfile" method="post" action=""
			target="_self">
			<table class="table table-border table-bordered active "
				style="background-color: #F7FBFF;">
				<tbody>
					<tr>
						<td class="text-r">APP版本 :</td>
						<td class="text-l"><input type="text" placeholder="请填写APP版本"
							value="" name="appEdition" class="input-text"
							style="width:400px;" id="appEdition"></td>
					</tr>
					<tr>
						<td class="text-r">APP类型 :</td>
						<td class="text-l">
							<div class="layui-input-block" id="app">
								<input id="android" name="app" value="0" title="android"
									type="radio" checked="checked" /> <input id="ios" name="app"
									value="1" title="ios" type="radio" value="1" />
							</div>
						</td>
					</tr>
					<tr style="height: 170px">
						<td class="text-r">上传 :</td>
						<td class="text-l">
							<div class="formControls col-xs-8 col-sm-9">
								<div class="uploader-list-container"
									style="width: 380px;height: 100px">
									<div class="queueList" style="height: 60px">
										<div id="dndArea">
											<div id="fileList" class="uploader-list"></div>
										</div>
									</div>
									<div class="uploader-thum-container">
										<div id="filePicker" style="">选择文件</div>
										<input type="hidden" name="file" id="fileUpload" value="">
									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<div style="margin-top: 7px;" class="text-c">
				<input class="btn btn-primary radius" value="确认" onclick="queren()"
					style=" color:#FFF; font-weight:bold;font-size:13px; padding-top:5px; padding-bottom:8px; border:none;width: 90px;height: 30px;"
					type="button"> &nbsp;&nbsp; <input
					class="btn btn-primary radius" value="取消" onclick="layer_close();"
					style=" color:#FFF; font-weight:bold;font-size:13px; padding-top:5px; padding-bottom:8px; border:none;width: 90px;height: 30px;"
					type="button">
			</div>
		</form>
	</article>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/layer/2.1/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/js/H-ui.admin.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/lib/lib/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form(); //只有执行了这一步，部分表单元素才会修饰成功

		});
		//得到工程路径
function getRootPath() {
	//http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	if (projectName == "/admin")
		projectName = "";

	return (localhostPaht + projectName);
}
var path = getRootPath() ; 

// 提交
function queren(){
	var appEdition=$("#appEdition").val();
	if (appEdition.trim().length <= 0 ) {
		layer.msg('请输入版本号！', {
			icon : 6,
			time : 2000
		});
		return false;
	}
	$.ajax({
		url: path+"/app.do?p=AppfileUpload",
		type: "post",
		async:false,
		data:$('#appfile').serialize(),
		success:function(data){
			if ("上传成功"==data) {
				//询问框
				layer.confirm('上传成功！', {
				  btn: ['确定'] //按钮
				}, function(){
					window.location.href=path+"/app.do?p=applisting";
				});
			}else if("上传失败"==data){
				layer.msg("上传失败", {icon:6,time:2000});	
			}			
		}
	});
}
//取消
function layer_close(){
	var appEdition=$("#appEdition").val("");
	var fileList=$("#fileList").html("");
}
 $list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;
	var fileName ;   
    //初始化上传组件
    var uploader = WebUploader.create({
		auto:true,
		swf: getRootPath()+'/lib/lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: getRootPath()+'/upload.do',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		method: 'POST'
		/**accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}**/
	});
    uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file , response) {
		fileName = response._raw ; 
		$("#fileUpload").val(fileName);
		
		
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

	</script>
</body>
</html>