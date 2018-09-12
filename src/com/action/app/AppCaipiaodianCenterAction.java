package com.action.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Caipiandianyuangong;
import com.pojo.Caipiaodian;
import com.pojo.Caipiaodianshenqing;
import com.pojo.Shoujiduanxiaoxi;
import com.pojo.Users;
import com.service.app.AppCaipiaodianCenterService;
import com.service.app.AppRegisterService;
import com.util.JsonFilter;
import com.util.MD5Util;
import com.util.SmsUtil;
import com.util.StringUtil;
import com.util.Upload;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import sun.misc.BASE64Decoder;

/**
* @author 全恒
* 福彩 彩票店店铺信息
*/
@Controller
@RequestMapping("/fucaiCenter.do")
public class AppCaipiaodianCenterAction {
	@Autowired
	private AppCaipiaodianCenterService caipiaodianCenterService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AppRegisterService registerService;
	
////////////////////////////登陆部分//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 判断是否登陆(判断session)
	 * @return
	 */
	@RequestMapping(params="p=isLogin")
	@ResponseBody
	public  String isLogin()
	{
		Caipiaodian caipiaodian = (Caipiaodian) request.getSession().getAttribute("caipiaodian");
		if(caipiaodian!=null){
			JsonConfig config=new JsonConfig();
			config.setExcludes(new String[]{"password"});
			JsonFilter.ignoredSet(config);
			String json = JSONObject.fromObject(caipiaodian,config).toString();
			return json;
		}else{
			return "";
		}
	}
	
	/**
	 * 登录后显示营业额和订单数
	 * 登陆的判断标准：既可用彩票店的手机号和密码登陆，也可用员工的手机号和密码登陆
	 * 做一个标记放在json中，用来标记当前登陆者是店长还是店员
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
		Caipiaodian caipiaodian = caipiaodianCenterService.applogin(username,userpwd2);
		request.getSession().setAttribute("caipiaodian", caipiaodian);
		//flag，用来标记登陆的用户是商家还是店员，true指商家，false指店员
		boolean flag = true;
		//如果用户能登陆，就查出该用户的营业额和订单数
		if(caipiaodian!=null){
			String json = caipiaodianCenterService.gotoOperationManager(caipiaodian, flag);
			return json;
		}else{
			//如果为空就查员工表，将ArrayList中的彩票店和员工放在session中
			//ArrayList可以存储不同类型的对象
			ArrayList list = caipiaodianCenterService.applogin2(username,userpwd2);
			if(list.size() > 0){
				request.getSession().setAttribute("caipiaodian", list.get(0));
				request.getSession().setAttribute("caipiaodianEmployee", list.get(1));
				String json = caipiaodianCenterService.gotoOperationManager(caipiaodian, flag=false);
			}else{
				response.getWriter().print("请先登录");
			}
		}
		return null;
	}
	
	/**
	 * 进入业务管理页面：显示营业额和订单数
	 */
	@ResponseBody
	@RequestMapping(params="p=gotoOperationManager")
	public String gotoOperationManager(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Caipiandianyuangong caipiandianyuangong = (Caipiandianyuangong)request.getSession().getAttribute("caipiaodianEmployee");
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		if(caipiandianyuangong != null){
			String json = caipiaodianCenterService.gotoOperationManager(caipiaodian, false);
			return json;
		} else {
			String json = caipiaodianCenterService.gotoOperationManager(caipiaodian, true);
			return json;
		}
	}
	
	/**
	 * 进入个人中心，显示个人信息
	 */
	@ResponseBody
	@RequestMapping(params="p=gotoCaipiaodianCenter")
	public String gotoCaipiaodianCenter(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		Caipiandianyuangong caipiandianyuangong = (Caipiandianyuangong)request.getSession().getAttribute("caipiaodianEmployee");
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"password"});
		config.setExcludes(new String[]{"mima"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		Map map = new HashMap();
		map.put("caipiaodian", caipiaodian);
		if(caipiandianyuangong != null){
			map.put("caipiandianyuangong", caipiandianyuangong);
		}else{
			map.put("caipiandianyuangong", "null");
		}
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}
	
	/**
	 * 注销
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="p=zhuxiao")
	@ResponseBody
	public String zhuxiao()
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
		Caipiaodian caipiaodian =  (Caipiaodian) request.getSession().getAttribute("caipiaodian");
		int id =caipiaodian.getId();	//彩票店ID
		String imgdata=request.getParameter("imgdata");	//图片
		String imgPath=request.getParameter("imgPath");	//图片路径
		String caipiaodianPhone=caipiaodian.getPhone();
		int index=imgPath.lastIndexOf(".");
		String ss=imgPath.substring(index);
		String newHeadimg=caipiaodianPhone+"-"+System.currentTimeMillis()+ss;//图片名称
		//删除文件夹中之前的头像图片
        File folder = new File(path);
		File[] files = folder.listFiles();
		for(File f:files){
			if(f.getName().substring(0,11).equals(caipiaodianPhone)){
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
		boolean f=caipiaodianCenterService.uploadHeadimg(id,newHeadimg);
		if(f)
			response.getWriter().print(true);
		else
			response.getWriter().print(false);
		return null;
	}
	
	/**
	 * 输入手机号，判断该用户是否存在，
	 * 存在则返回yes，获取验证码，
	 * 不存在则返回no，前端给予提示
	 */
	@RequestMapping(params="p=getVerificationCode")
	@ResponseBody
	private String getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//验证手机号的唯一性
		String mobile=request.getParameter("iphone");
		List list=caipiaodianCenterService.findByCaipiaodianMobile(mobile);
		if(list.size()>0)
		{
			response.getWriter().print("false");
			return "no";
		}
		String code=SmsUtil.createCode(4);
		String content="您的验证码为:"+code;
		registerService.saveCode(code, mobile);
		SmsUtil.send(mobile, content);
		return "yes";
	}
	
	/**
	 * 输入验证码，验证验证码的正确性和时效性，
	 * 正确返回yes，错误返回no，过期返回no2
	 */
	@RequestMapping(params="p=checkVerificationCode")
	private void checkVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");//得到验证码
		List list = registerService.findJihuoma(mobile, code);
		if(list.size()>0){
			Shoujiduanxiaoxi jihuoma=(Shoujiduanxiaoxi) list.get(0);
			Timestamp timestamp=jihuoma.getTime();
			Date date=new Date();
			Timestamp cutimestamp = new Timestamp(date.getTime());
			if((cutimestamp.getTime()-timestamp.getTime())/(1000*60)<30){
				response.getWriter().print("yes");
			} else {
				response.getWriter().print("no2");//过期
			}
		} else {
			response.getWriter().print("no");//验证码输入错误
		}
	}
	
	/**
	 * 输入新密码，完成密码修改，成功返回yes，失败返回no
	 */
	@RequestMapping(params="p=changePwd")
	@ResponseBody
	private String changePwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mobile = request.getParameter("mobile");
		String newPwd=request.getParameter("newPwd");
		caipiaodianCenterService.changePwd(mobile,MD5Util.getMD5(MD5Util.getMD5(newPwd+"shuitu")+"shuitu"));
		return "yes";
	}
	
/////////////////////////////////注册部分///////////////////////////////////////////////////////////////////	
	/**
	 * 彩票店注册，分为商户注册和商户验证两部分，
	 * 商户注册时将   彩票店申请表   status设置为-1
	 * 完成商户验证后才将status设置为0
	 * 彩票站状态，-1未进行商户验证，0未审核，1审核通过，2审核未通过
	 */
	
	/**
	 * 发送验证码，并验证手机号和用户名的唯一性
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params="p=get")
	private void doTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//验证用户名的唯一性
		String nickname=request.getParameter("nickname");
		if (nickname!=null)
			nickname = new String(nickname.getBytes("iso8859-1"),"utf-8");
		//System.out.println("用户名："+nickname);
		List list2=caipiaodianCenterService.findByCaipiaodianName(nickname);
		if(list2.size()>0)
		{
			response.getWriter().print("nameFalse");
			return;
		}
		//验证手机号的唯一性
		String mobile=request.getParameter("iphone");
		List list=caipiaodianCenterService.findByCaipiaodianMobile(mobile);
		if(list.size()>0)
		{
			response.getWriter().print("false");
			return;
		}
		String code=SmsUtil.createCode(4);
		String content="您的验证码为:"+code;
		registerService.saveCode(code, mobile);
		SmsUtil.send(mobile, content);
	}
	
	/**
	 * 验证码超时验证
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="p=code")
	private void doCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");//得到验证码
		//System.out.println(code);
		List list = registerService.findJihuoma(mobile, code);
		if(list.size()>0){
			Shoujiduanxiaoxi jihuoma=(Shoujiduanxiaoxi) list.get(0);
			Timestamp timestamp=jihuoma.getTime();
			Date date=new Date();
			Timestamp cutimestamp = new Timestamp(date.getTime());
			if((cutimestamp.getTime()-timestamp.getTime())/(1000*60)<30){
				response.getWriter().print("yes");
			} else {
				response.getWriter().print("no");
			}
		} else {
			response.getWriter().print("no");
		}
	}
	
	/**
	 * 完成初步注册
	 * 将Caipiaodianshenqing表status设置为-1
	 */
	@RequestMapping(params="p=register")
	@ResponseBody
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String password = MD5Util.getMD5(MD5Util.getMD5(pwd + "sunjob")
				+ "sunjob");
		String clientId = request.getParameter("clientId");
		Caipiaodianshenqing caipiaodianshenqing = caipiaodianCenterService.register(nickname, phone, password, clientId);
		request.getSession().setAttribute("caipiaodianshenqing", caipiaodianshenqing);
		return "yes";

	}
	
	/**
	 * 提交身份验证
	 * 完成商户验证后才将Caipiaodianshenqing表status设置为0
	 */
	@RequestMapping(params="p=shopConfirmation")
	@ResponseBody
	public String shopConfirmation(HttpServletRequest request, HttpServletResponse response) {
		Caipiaodianshenqing caipiaodianshenqing = (Caipiaodianshenqing)request.getSession().getAttribute("caipiaodianshenqing");
		System.out.println("action"+caipiaodianshenqing);
		String path = request.getSession().getServletContext().getRealPath("/admin/images/tx");// 上传到指定目录
		//Map<String, String> map = Upload.upload(request, 5 * 1024 * 1024, path);
		//需要的数据：faren,shenfenzheng,sfzFrontImg,sfzBackImg,yingyeID,yingyeName,yingyeImg,arId,address,jingdu,weidu,isTicai,isFucai
		String faren = request.getParameter("faren");
		String shenfenzheng = request.getParameter("shenfenzheng");  //map.get("shenfenzheng"); 
		String sfzFrontImg = request.getParameter("sfzFrontImg");
		String sfzBackImg = request.getParameter("sfzBackImg");
		String yingyeID = request.getParameter("yingyeID");
		String yingyeName = request.getParameter("yingyeName");
		String yingyeImg =request.getParameter("yingyeImg");
		Integer arId = Integer.parseInt(request.getParameter("arId"));//前端查询出省市区，根据结果返回对应的arId
		String address = request.getParameter("address");
		caipiaodianCenterService.shopConfirmation(caipiaodianshenqing, faren,shenfenzheng,sfzFrontImg,sfzBackImg,yingyeID,yingyeName,yingyeImg,arId,address);
		return "yes";
	}
	
/////////////////////////////////彩票店的信息记录////////////////////////////////////////////////////////////////
	
	/**
	 * 彩票店充值记录
	 */
	@RequestMapping(params="p=chongzhijilu")
	@ResponseBody
	public String getChongzhijilu(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianCenterService.getChongzhijilu(caipiaodian.getId(), page, size);
		return json;
	}
	
	/**
	 * 去提现，进入提现页面
	 */
	@RequestMapping(params="p=gotoTixian")
	@ResponseBody
	public String gotoTixian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String json = caipiaodianCenterService.gotoTixian(caipiaodian.getId());
		return json;
	}
	
	/**
	 * 提现操作
	 * 发起提现申请，新增一条彩票店提现申请记录，等待后台审核
	 * 从彩票店积分中扣除可用积分
	 */
	@RequestMapping(params="p=doTixian")
	@ResponseBody
	public String doTixian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String txMoney = request.getParameter("txMoney");
		String json = caipiaodianCenterService.doTixian(caipiaodian, Double.parseDouble(txMoney));
		return json;//"yes"申请成功，  "no"申请额度大于可提现额度
	}
	
	/**
	 * 提现记录
	 */
	@RequestMapping(params="p=tixian")
	@ResponseBody
	public String getTixianjilu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianCenterService.getTixianjilu(caipiaodian.getId(), size, page);
		return json;
	}
	
	/**
	 * 中奖记录：只显示中奖的
	 */
	@RequestMapping(params="p=zhongjiang")
	@ResponseBody
	public String getZhongjiangjilu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianCenterService.getZhongjiangjilu(caipiaodian.getId(), size, page);
		return json;
	}
}
