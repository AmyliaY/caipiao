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
	if (projectName == "/admin" || projectName == "/daili")
		projectName = "";

	return ( projectName);
}
var path = getRootPath() ; 

onsubmit=function(){
	var username=$(".txtuser").val();//获取用户名
	var password=$(".txtpasw").val();//获取密码
	if(username.trim().length<=0 && password.trim().length<=0){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("请输入用户名和密码");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	if(username.trim().length<=0){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("请输入用户名");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	if(password.trim().length<=0){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("请输入密码");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	var yzm=$(".txtyzm").val();
	if(yzm.trim().length<=0){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("请输入验证码");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	var fg=false;
	var x=Math.random();
	$.ajax({
		type:"POST",
		url:path+"/adminlogin.do?p=yzm&sjs="+x,
		async:false,
		data:"yzm="+yzm,
		success:function(data){
			if(data=="true")
				fg=true;
		}
		
	});
	if(fg==false){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("验证码错误");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		var x=Math.random();
		$("#txtimg").attr("src",path+"/yzm.do?p=yzm&sjs="+x);
		return false;
	}
	
	var us=false;
	$.ajax({
		type:"POST",
		url:path+"/daililogin.do?p=checkuser&sjs="+x,
		async:false,
		data:{username:username,password:password},
		success:function(data){
			if(data=="true")
				us=true;
		}
	});
	if(us.equals("false")){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("用户名与密码不匹配");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	if(us.equals("false2")){
		$(".login_begin").css("background-color","#FFEBEB").css("border","1px solid #FACCC6").css("color","#E4393C").css("font-size","15px");
		$(".login_userneirong").text("此用户已经登陆，请在另一客户端退出后重试");
		$(".login_beginimg").show();
		$(".login_userneirong").stop(true,false).animate({marginLeft:'30px'},500); 
		$(".login_userneirong").animate({marginLeft:'0px'},500);
		return false;
	}
	$("#logingbtn").val("正在登陆...");
}
$(function(){
	//切换验证码
	$("#txtimg").click(function(){
		var x=Math.random();
		$(this).attr("src",path+"/yzm.do?p=yzm&sjs="+x);
	});
	$("input[name=login_jz]").change(function(){		
		//判断是否选定自动登录
		var auto=$(this).is(':checked');
		$("input[name=auto]").val(auto);
	});
});