package com.action.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Shoujiduanxiaoxi;
import com.pojo.Users;
import com.service.app.AppPersonCenterService;
import com.service.app.AppRegisterService;
import com.util.MD5Util;
import com.util.SmsUtil;

/**
* @author 全恒
*/

@Controller
@RequestMapping("/personalDetails.do")
public class AppPersonCenterAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AppPersonCenterService personCenterService;
	@Autowired
	private AppRegisterService registerService;
	
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
		List list=personCenterService.findMemberMobile(mobile);
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
		personCenterService.changePwd(mobile,MD5Util.getMD5(MD5Util.getMD5(newPwd+"shuitu")+"shuitu"));
		return "yes";
	}
	
	/**
	 * 分页查询订单记录/订单详情记录（所有）
	 */
	@RequestMapping(params="p=orders")
	@ResponseBody
	public String getOrders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = personCenterService.getOrders(users, page, size);
		return json;
	}
	
	/**
	 * 根据订单id，查出订单详情
	 */
	@RequestMapping(params="p=orderById")
	@ResponseBody
	public String getOrderById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String orderid = request.getParameter("orderid");
		String json = personCenterService.getOrderById(orderid);
		return json;
	}
	
	/**
	 * 用户充值记录
	 */
	@RequestMapping(params="p=chongzhijilu")
	@ResponseBody
	public String getChongzhijilu(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = personCenterService.getChongzhijilu(users.getId(), page, size);
		return json;
	}
	
	/**
	 * 去提现，进入提现页面
	 */
	@RequestMapping(params="p=gotoTixian")
	@ResponseBody
	public String gotoTixian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String json = personCenterService.gotoTixian(users.getId());
		return json;
	}
	
	/**
	 * 提现操作
	 * 发起提现申请，新增一条用户提现申请记录，等待后台审核
	 * 从用户积分中扣除可用积分
	 */
	@RequestMapping(params="p=doTixian")
	@ResponseBody
	public String doTixian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String txMoney = request.getParameter("txMoney");
		String json = personCenterService.doTixian(users, Double.parseDouble(txMoney));
		return json;//"yes"申请成功，  "no"申请额度大于可提现额度
	}
	
	
	/**
	 * 提现记录
	 */
	@RequestMapping(params="p=tixian")
	@ResponseBody
	public String getTixianjilu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = personCenterService.getTixianjilu(users.getId(), size, page);
		return json;
	}
	
	/**
	 * 中奖记录：只显示中奖的
	 */
	@RequestMapping(params="p=zhongjiang")
	@ResponseBody
	public String getZhongjiangjilu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = personCenterService.getZhongjiangjilu(users.getId(), size, page);
		return json;
	}
	
	/**
	 * 我收藏的彩票店
	 */
	@RequestMapping(params="p=collections")
	@ResponseBody
	public String getCollections(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = personCenterService.getCollections(users.getId(), size, page);
		return json;
	}
	
	/**
	 * 根据彩票店id收藏彩票店
	 */
	@RequestMapping(params="p=collectById")
	@ResponseBody
	public String collectById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String cpdId = request.getParameter("cpdId");
		personCenterService.collectById(users.getId(), cpdId);
		return "yes";
	}
	
	/**
	 * 根据彩票店id取消收藏
	 */
	@RequestMapping(params="p=removeCollectById")
	@ResponseBody
	public String removeCollectById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String cpdId = request.getParameter("cpdId");
		personCenterService.removeCollectById(users.getId(), cpdId);
		return "yes";
	}
}
