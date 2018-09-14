package com.action.app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.action.weixin.WeixinConfig;
import com.alipay.config.AlipayConfig;
import com.alipay.util.AliPayUtil;
import com.pojo.Caipiaodian;
import com.pojo.Users;
import com.service.app.AppChongzhiTixianService;
import com.service.app.AppRechargePayService;
import com.util.JsonFilter;
import com.util.URLManager;

@Controller
@RequestMapping("/rechargepay.do")
public class AppRechargePayAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AppRechargePayService rechargePayService;
	@Autowired
	private AppChongzhiTixianService chongzhiTixianService;
	
	/**
	 * 用户充值
	 * 微信支付
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "p=userWxPay")
	public String userWxPay() {
		String orderId = UUID.randomUUID().toString().replaceAll("-", "");
		String notifyUrl = URLManager.getServerURL(request)+"/wexinUserChongzhiPay.do";
		String money = request.getParameter("total");
		String title = "积分充值";

		Users users = (Users) request.getSession().getAttribute(
				"users");
		if (users != null) {
			String json = rechargePayService.payByWxpay(notifyUrl, request,
					orderId);
			chongzhiTixianService.addUserChongzhi(users, Double
					.parseDouble(money), orderId, 2);
			return json;
		}
		return "false";
	}

	/**
	 * 用户充值
	 * 支付宝支付
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "p=userAliPay")
	public String userAliPay() {
		String orderId = UUID.randomUUID().toString().replaceAll("-", "");
		String notifyUrl = URLManager.getServerURL(request)+"/aliPayByUserChonzhiNotify.do";//客户付款后,支付宝回调的页面
		String money = request.getParameter("total");
		String title = "积分充值";

		Users users = (Users) request.getSession().getAttribute(
				"users");
		if (users != null) {
			String json = AliPayUtil.createPayString(orderId, money, notifyUrl,
					title);
			chongzhiTixianService.addUserChongzhi(users, Double
					.parseDouble(money), orderId, 1);
			return json;
		}
		return "false";
	}
	
	/**
	 * 彩票店充值
	 * 微信支付
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "p=cpdWxPay")
	public String wxpay() {
		String orderId = UUID.randomUUID().toString().replaceAll("-", "");
		String notifyUrl = URLManager.getServerURL(request)+"/wexinCpdChongzhiPay.do";
		String money = request.getParameter("total");
		String title = "积分充值";

		Caipiaodian caipiaodian = (Caipiaodian) request.getSession().getAttribute(
				"caipiaodian");
		if (caipiaodian != null) {
			String json = rechargePayService.payByWxpay(notifyUrl, request,
					orderId);
			chongzhiTixianService.addCpdChongzhi(caipiaodian, Double
					.parseDouble(money), orderId, 2);
			return json;
		}
		return "false";
	}

	/**
	 * 彩票店充值
	 * 支付宝支付
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "p=cpdAliPay")
	public String alipay() {
		String orderId = UUID.randomUUID().toString().replaceAll("-", "");
		String notifyUrl = URLManager.getServerURL(request)+"/aliPayByCpdChonzhiNotify.do";//客户付款后,支付宝调用的页面
		String money = request.getParameter("total");
		String title = "积分充值";

		Caipiaodian caipiaodian = (Caipiaodian) request.getSession().getAttribute(
				"caipiaodian");
		if (caipiaodian != null) {
			String json = AliPayUtil.createPayString(orderId, money, notifyUrl,
					title);
			chongzhiTixianService.addCpdChongzhi(caipiaodian, Double
					.parseDouble(money), orderId, 1);
			return json;
		}
		return "false";
	}
	

	// 创建订单号
	@ResponseBody
	@RequestMapping(params = "p=getOrderid")
	public String getOrderid() {
		String orderId = UUID.randomUUID().toString().replace("-", "");
		return orderId;
	}

	@ResponseBody
	@RequestMapping(params = "p=chongzhiStatus")
	public String chongzhiStatus() {
		WeixinConfig wx = new WeixinConfig();
		AlipayConfig alipay = new AlipayConfig();
		Map map = new HashMap();
		map.put("wxstatus", wx.getStatus());
		map.put("alipayStatus", alipay.getStatus());
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj = new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}
}
