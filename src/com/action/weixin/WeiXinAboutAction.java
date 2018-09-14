package com.action.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.listener.WeixinGetAccessTokenListen;
import com.util.URLManager;
import com.weixin.util.ParseXmlUtil;

import weixin.popular.api.OpenIdAPI;
import weixin.popular.bean.AccessToken;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.JSSDKUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

/**
 * 关于爱购
 * @author lgh
 */
@Controller
@RequestMapping("/weixinAbout.do")
public class WeiXinAboutAction {

	@Autowired
	private HttpServletRequest request;

	public static void main(String[] args) {
		String str = "<xml><appid><![CDATA[wx225617f3db0beec0]]></appid><attach><![CDATA[WWW]]></attach><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1264112801]]></mch_id><nonce_str><![CDATA[142b954d54be4812a5e2f43c085ffd1c]]></nonce_str><openid><![CDATA[oEaMPwVxbFq4IfHf9ZfPBSdCrkYo]]></openid><out_trade_no><![CDATA[sunjob201704160002]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[C3153E0C4AF339B6FE0A052088079260]]></sign><time_end><![CDATA[20160417002008]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4001602001201604174916499824]]></transaction_id></xml>";
		PayNotify payNotify = XMLConverUtil.convertToObject(PayNotify.class,
				str);
		// 签名判断略...
		String sign = payNotify.getSign();
		System.out.println("main()");
		System.out.println(sign);
		Map<String, String> map = MapUtil.objectToMap(payNotify,
				"appsignature", "sign");
		String sign2 = SignatureUtil.generateSign(map, WeixinConfig.PAY_KEY);
		System.out.println(sign2);
	
	}

	/**
	 * <xml><appid><![CDATA[wx225617f3db0beec0]]></appid>
	 * <attach><![CDATA[WWW]]></attach> <bank_type><![CDATA[CFT]]></bank_type>
	 * <cash_fee><![CDATA[1]]></cash_fee> <fee_type><![CDATA[CNY]]></fee_type>
	 * <is_subscribe><![CDATA[Y]]></is_subscribe>
	 * <mch_id><![CDATA[1264112801]]></mch_id>
	 * <nonce_str><![CDATA[142b954d54be4812a5e2f43c085ffd1c]]></nonce_str>
	 * <openid><![CDATA[oEaMPwVxbFq4IfHf9ZfPBSdCrkYo]]></openid>
	 * <out_trade_no><![CDATA[sunjob201704160002]]></out_trade_no>
	 * <result_code><![CDATA[SUCCESS]]></result_code>
	 * <return_code><![CDATA[SUCCESS]]></return_code>
	 * <sign><![CDATA[C3153E0C4AF339B6FE0A052088079260]]></sign>
	 * <time_end><![CDATA[20160417002008]]></time_end> <total_fee>1</total_fee>
	 * <trade_type><![CDATA[JSAPI]]></trade_type>
	 * <transaction_id><![CDATA[4001602001201604174916499824]]></transaction_id>
	 * </xml>
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping
	public String payNotify(HttpServletResponse response) throws IOException {
		InputStream is = request.getInputStream();
		byte[] b = new byte[1024];
		int size = is.read(b);
		String str = new String(b, 0, size);
		System.out.println("封装的xml："+str);
		// 获取请求数据
		PayNotify payNotify = XMLConverUtil.convertToObject(PayNotify.class,
				str);
		// 签名判断略...
		String sign = payNotify.getSign();
		boolean f = SignatureUtil.validateAppSignature(payNotify,
				WeixinConfig.PAY_KEY);
		System.out.println("签名判断："+f);
		if (true)
			return null;
		// 支付成功
		if ("SUCCESS".equals(payNotify.getResult_code())
				&& "SUCCESS".equals(payNotify.getReturn_code())) {
			String trade_no = payNotify.getOut_trade_no();
			response.getOutputStream().write("success".getBytes());
		} else {
			response.getOutputStream().write("error".getBytes());
		}
		return null;
	}

	@RequestMapping(params = "p=toPay")
	public String toPay(HttpServletResponse response) {
		// 1.得openId
		String id = request.getParameter("id");
		String money = request.getParameter("money");
		String openId = (String) request.getSession().getAttribute("openId");
		// 2.去支付
		String notifyUrl = "http://iptv2.vicp.net/jiayouzhan/weixinAbout.do";
		String json = JSSDKUtil.setPayParam(request, notifyUrl, money, id,
				openId);
		// 4.调用微信支付
		return "/pay_example.jsp";
	}

	@RequestMapping(params = "method=aboutbcm")
	public String showAbout(HttpServletResponse response) {
		// ------------------获取客户的微信号 :@author lgh ------------------//
		String code = request.getParameter("code");
		String appid = WeixinConfig.APPID;
		String secret = WeixinConfig.APPSECRET;
		AccessToken accessToken = new OpenIdAPI()
				.getOpenId(appid, secret, code);
		String weixinhao = accessToken.getOpenid();
		// System.out.println("客户微信号------------"+weixinhao);
		// --------------- end 获取客户的微信号----------------//
		System.out.println("微信号:" + weixinhao);
		return "/index.jsp";
	}

	@RequestMapping(params = "method=testClick")
	public String testClick(HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ------------------获取客户的微信号 :@author lgh ------------------//
		String code = request.getParameter("code");
		String appid = WeixinConfig.APPID;
		String secret = WeixinConfig.APPSECRET;
		AccessToken accessToken = new OpenIdAPI()
				.getOpenId(appid, secret, code);
		String weixinhao = accessToken.getOpenid();
		System.out.println("微信号:" + weixinhao); // 有的时候，要验证是否新用户，就要录入手机号码
		// 如果要使用jssdk
		JSSDKUtil.setJsSdkParam(request);
		request.getSession().setAttribute("openId", accessToken.getOpenid());
		return "/weixin_share.jsp";
	}
}
