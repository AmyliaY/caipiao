<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>后台登录 - 水果商城</title>
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/admin/css/login.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/lib/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/admin/js/login.js"></script>
</head>

<body>
	<div class="login_top">

		<%-- <img style="width: 80px;height: 80px;margin-top: 5px;" alt="国湘人力" src="${pageContext.request.contextPath }/images/logo.jpg" />
       --%>
		<div style="padding-top:25px;font-weight: bold;">
			<h1>&nbsp;易乐宝平台管理</h1>
		</div>


		<span class="login_shengfen"></span>
	</div>
	<div class="login_center">
		<div class="login_denglu">
			<img src="${pageContext.request.contextPath }/admin/images/2.png"
				class="logoimg" />
			<div class="login_users">
				<div class="login_yhdl">
					<div class="login_begin">
						<b class="login_beginimg"></b><span class="login_userneirong">平台管理员登录</span>
					</div>
				</div>
				<form target="_top"
					action="${pageContext.request.contextPath }/adminlogin.do?p=tomain"
					method="post">
					<table>

						<tr id="login_firstuser">
							<td align="right">用户名:</td>
							<td><b class="login_txt"><input type="text"
									name="username" class="txtuser" placeholder="请输入用户名" /></b></td>
						</tr>
						<tr>
							<td align="right">密码:</td>
							<td><b class="login_txt"><input type="password"
									name="password" class="txtpasw" placeholder="请输入密码" /></b></td>
						</tr>
						<tr>
							<td align="right">验证码:</td>
							<td><b class="login_txt2"><input type="text" name="yzm"
									class="txtyzm" placeholder="请输入验证码" /></b><img alt="验证码"
								src="${pageContext.request.contextPath}/yzm.do?p=getCode"
								class="txtimg" id="txtimg" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit"
								value="登&nbsp;&nbsp;&nbsp;&nbsp;录" class="login_denglubtn"
								id="logingbtn" /></td>
						</tr>
					</table>

				</form>
			</div>
		</div>
	</div>
	<div class="login_bottom">

		<span class="login_gongsixinxi">深圳光华软件有限公司提供技术支持</span>

	</div>
</body>
<script>
$(function(){
//让ie兼容placeholder的代码
var JPlaceHolder = {
    //检测
    _check : function(){
        return 'placeholder' in document.createElement('input');
    },
    //初始化
    init : function(){
        if(!this._check()){
            this.fix();
        }
    },
    //修复
    fix : function(){
        $(".txtimg").css("border","0px").css("height","36px");
        jQuery(':input[placeholder]').each(function(index, element) {
            var self = $(this), txt = self.attr('placeholder');
            self.wrap($('<div></div>').css({position:'relative', zoom:'1', border:'none', background:'none', padding:'none', margin:'none'}));
            var pos = self.position(), h = self.outerHeight(true), paddingleft = self.css('padding-left');
            var holder = $('<span></span>').text(txt).css({position:'absolute', left:pos.left, top:pos.top+7, height:h, lienHeight:h, paddingLeft:paddingleft, color:'#a9a9a9'}).appendTo(self.parent());
            self.focusin(function(e) {
                holder.hide();
            }).focusout(function(e) {
                if(!self.val()){
                    holder.show();
                }
            });
            holder.click(function(e) {
                holder.hide();
                self.focus();
            });
        });
    }
};
//执行
jQuery(function(){
    JPlaceHolder.init();    
});

});
</script>
</html>
