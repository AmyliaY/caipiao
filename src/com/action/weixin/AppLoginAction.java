package com.action.weixin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import sun.misc.BASE64Decoder;

import com.alipay.sign.MD5;
import com.pojo.Users;
import com.service.app.AppLoginService;
import com.util.Base64Util;
import com.util.FileUtil;
import com.util.JsonFilter;
import com.util.MD5Util;
import com.util.Upload;

@Controller
@RequestMapping("/applogin.do")
public class AppLoginAction {
	
	@Autowired
	private AppLoginService appLoginService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @return
	 */
	@RequestMapping(params="p=isLogin")
	@ResponseBody
	public  String isLogin()
	{
		Users users = (Users) request.getSession().getAttribute("users");
		if(users!=null){
			JsonConfig config=new JsonConfig();
			config.setExcludes(new String[]{"password"});
			JsonFilter.ignoredSet(config);
			String json = JSONObject.fromObject(users,config).toString();
			return json;
		}else{
			return "";
		}
	}
	
	/**
	 * 登录
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(params="p=applogin")
	public String applogin(HttpServletResponse response) throws IOException
	{
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		String userpwd2 = MD5Util.getMD5(MD5Util.getMD5(userpwd + "sunjob")
				+ "sunjob");
		Users users=appLoginService.applogin(username,userpwd2);
		request.getSession().setAttribute("users", users);
		if(users!=null){
			JsonConfig config=new JsonConfig();
			config.setExcludes(new String[]{"password"});
			JsonFilter.ignoredSet(config);
			String json = JSONObject.fromObject(users,config).toString();
			return json;
		}else{
			response.getWriter().print("请先登录");
		}
		return null;
	}
	
	/**
	 * 注销
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="p=zhuxiao")
	@ResponseBody
	public String  zhuxiao()
	{
		 request.getSession().invalidate();
		 return "success";
	}
	
	/**
	 * 上传头像
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(params="p=uploadHeadimg")
	public String uploadHeadimg(HttpServletResponse response) throws IOException
	{
		String path=request.getSession().getServletContext().getRealPath("/admin/images/tx");// 上传到指定目录
		Users user =  (Users) request.getSession().getAttribute("users");
		int id =user.getId();	//会员ID
		String imgdata=request.getParameter("imgdata");	//图片
		String imgPath=request.getParameter("imgPath");	//图片路径
		String userPhone=user.getPhone();//request.getParameter("userPhone");	//用户手机号码
		
		int index=imgPath.lastIndexOf(".");
		String ss=imgPath.substring(index);
		String newHeadimg=userPhone+"-"+System.currentTimeMillis()+ss;//图片名称
		
		//删除文件夹中之前的头像图片
        File folder = new File(path);
		File[] files = folder.listFiles();
		for(File f:files){
			if(f.getName().substring(0,11).equals(userPhone)){
				f.delete();
			}
		}
		
		 //Base64解码  
		BASE64Decoder decoder = new BASE64Decoder();  
		
        byte[] b = decoder.decodeBuffer(imgdata);  
        for(int i=0;i<b.length;++i)  
        {  
            if(b[i]<0)  
            {//调整异常数据  
                b[i]+=256;  
            }  
        }  
        //生成jpeg图片  
        File file=new File(path+"/"+newHeadimg);
        OutputStream out = new FileOutputStream(file);      
        out.write(b);  
        out.flush();  
        out.close();  
		boolean f=appLoginService.uploadHeadimg(id,newHeadimg);
		if(f)
			response.getWriter().print(true);
		else
			response.getWriter().print(false);
		return null;
	}
}
