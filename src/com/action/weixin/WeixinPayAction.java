package com.action.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.JSSDKUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import com.util.StringUtil;
import com.util.T2DMa;
import com.util.URLManager;

@Controller
@RequestMapping("/weixinPay.do")
public class WeixinPayAction {
	
	public static void main(String[] args) {
		String appid = "wx6a1e70a87f9fb08e";
		String secret = "1f3b6cdbef6d3bcce4f55e2f027a4a52";
		String mch_id = "1231794002"; // 商户号
		String payKey = "b1994c2675bb3a752ea740212f9a692a"; // 支付key
		String notifyUrl = "http://iptv2.vicp.net/weixinPay.do"; // 异步通知地址http://iptv2.vicp.net/jht_1
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setBody("goods");// 商品描述
		//unifiedorder.setDevice_info("1234");
		unifiedorder.setGoods_tag("");
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replaceAll("-",
				""));
		unifiedorder.setNotify_url(notifyUrl);// 通知地址
		unifiedorder.setOut_trade_no(UUID.randomUUID().toString().replaceAll("-", "")); // 外部订单号
		unifiedorder.setProduct_id("131452");// 产品号（二维码时有用)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		unifiedorder.setTime_expire(sdf.format(new java.util.Date(System
				.currentTimeMillis() + 24 * 3600 * 1000)));
		unifiedorder.setTime_start(sdf.format(new Date()));
		unifiedorder.setSpbill_create_ip("192.168.0.1");// 客户端ip
		float money = 0.01F;
		String money2 = money * 100 + ""; //
		int index = money2.indexOf('.');
		if (index > -1) {
			money2 = money2.substring(0, index);
		}
		unifiedorder.setTotal_fee(money2); // 订单总金额，分 money
		unifiedorder.setAttach("");
		unifiedorder.setTrade_type("NATIVE");
		String sign = SignatureUtil.generateSign(MapUtil.objectToMap(
				unifiedorder, "sign"), payKey);
		unifiedorder.setSign(sign);
		UnifiedorderResult unifiedorderResult = new PayMchAPI()
				.payUnifiedorder(unifiedorder);
		String code_url = unifiedorderResult.getCode_url();
		System.out.println(code_url);
	}

	/**
	 * 微信扫码支付
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params = "p=toPay")
	public String toPay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id"); // 订单ID
		float money = Float.parseFloat(request.getParameter("money"));// 支付金额
		String name = "";
		String appid = WeixinConfig.APPID;// "wx94df44a32ee2fabc"
		String secret = WeixinConfig.APPSECRET;// "c7c8da0e239b43acde5007fe126dfefc"
		String mch_id = WeixinConfig.MCH_ID; // 商户号
		String payKey = WeixinConfig.PAY_KEY; // 支付key
		String notifyUrl = URLManager.getServerURL(request) + "/weixinPay.do"; // 异步通知地址http://iptv2.vicp.net/jht_1
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setBody(name);// 商品描述
		unifiedorder.setDevice_info("");
		unifiedorder.setGoods_tag("");
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replaceAll("-", ""));
		unifiedorder.setNotify_url(notifyUrl);// 通知地址
		unifiedorder.setOut_trade_no(id); // 外部订单号
		unifiedorder.setProduct_id("131452");// 产品号（二维码时有用)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		unifiedorder.setTime_expire(sdf.format(new java.util.Date(System
				.currentTimeMillis() + 24 * 3600 * 1000)));
		unifiedorder.setTime_start(sdf.format(new Date()));
		unifiedorder.setSpbill_create_ip(request.getLocalAddr());// 客户端ip
		String money2 = money * 100 + ""; //
		int index = money2.indexOf('.');
		if (index > -1) {
			money2 = money2.substring(0, index);
		}
		unifiedorder.setTotal_fee(money2); // 订单总金额，分 money
		unifiedorder.setAttach("");
		unifiedorder.setTrade_type("NATIVE");
		String sign = SignatureUtil.generateSign(MapUtil.objectToMap(
				unifiedorder, "sign"), payKey);
		unifiedorder.setSign(sign);
		UnifiedorderResult unifiedorderResult = new PayMchAPI().payUnifiedorder(unifiedorder);
		String code_url = unifiedorderResult.getCode_url();
		System.out.println(code_url);
		if (StringUtil.isNull(code_url)) {
			response.getWriter().print("微信支付参数配置错误，请联系系统管理员");
			return null;
		}
		String imgPath = request.getSession().getServletContext().getRealPath(
				"/tempImages/" + id + ".png"); // 二维码存放的图片路径，请修改成实际图片
		String encoderContent = code_url;
		T2DMa ma = new T2DMa();
		ma.encoderQRCode(encoderContent, imgPath, "png");
		request.setAttribute("weixianpay", id + ".png");
		request.setAttribute("id", id);
		request.setAttribute("money", money);
		return "/pay/weixinpay/pay.jsp";
	}

	/**
	 * 微信支付回调函数
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		InputStream is = request.getInputStream();
		byte[] b = new byte[1024];
		int size = is.read(b);
		String str = new String(b, 0, size);
		// 获取请求数据
		PayNotify payNotify = XMLConverUtil.convertToObject(PayNotify.class,
				str);
		// 签名判断略...
		System.out.println("##########come on#########");
		System.out.println(payNotify.getResult_code());
		System.out.println(payNotify.getReturn_code());
		System.out.println(payNotify.getOut_trade_no());
		System.out.println(payNotify.getTotal_fee());
		// 支付成功
		if ("SUCCESS".equals(payNotify.getResult_code())
				&& "SUCCESS".equals(payNotify.getReturn_code())) {
			String trade_no = payNotify.getOut_trade_no();
			{
				System.out.println("lailemei:微信支付");
				float money = 0.0f;
				if (payNotify.getTotal_fee() != null) {
					money = Float.parseFloat(payNotify.getTotal_fee()) / 100;
				}
				// 这里支付成功后修改订单状态
				response.getOutputStream().write("success".getBytes());
			}
		} else {
			response.getOutputStream().write("error".getBytes());
		}
		return null;
	}
}
