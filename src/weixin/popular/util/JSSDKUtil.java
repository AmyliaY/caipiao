package weixin.popular.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;

import com.action.weixin.WeixinConfig;
import com.listener.WeixinGetAccessTokenListen;
import com.util.IPUtil;

public class JSSDKUtil {

	public static String setPayParam(HttpServletRequest request,
			String notifyUrl, String money, String orderId, String openId) {
		String appid = WeixinConfig.APPID;
		String mch_id = WeixinConfig.MCH_ID; // 商户号
		String payKey = WeixinConfig.PAY_KEY; // 支付key
		String ip = IPUtil.getIpAddr(request);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timeStart = sdf.format(date);
		String timeExpire = sdf.format(new Date(
				date.getTime() + 24L * 3600 * 1000));

		// String timeStart= "20160416105006";
		// String timeExpire = "20160417105006";

		String oneString = SignatureUtil.create_nonce_str().replaceAll("-", "");
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setBody("支付");// 商品描述
		unifiedorder.setDevice_info("shuiguo");
		unifiedorder.setGoods_tag("shuiguo");
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(oneString);
		unifiedorder.setNotify_url(notifyUrl);// 通知地址
		unifiedorder.setOut_trade_no(orderId); // 外部订单号
		unifiedorder.setProduct_id("131452");// 产品号（二维码时有用)

		unifiedorder.setTime_expire(timeExpire);
		unifiedorder.setTime_start(timeStart);
		unifiedorder.setSpbill_create_ip(ip);// 客户端ip
		String money2 = Float.parseFloat(money) * 100 + "";
		int index = money2.indexOf(".");
		if (index > -1)
			money2 = money2.substring(0, index);
		unifiedorder.setTotal_fee(money2); // 订单总金额，分 money
		unifiedorder.setAttach("WWW");
		unifiedorder.setTrade_type("JSAPI");
		unifiedorder.setOpenid(openId); // open, jsapi必须的

		String sign = SignatureUtil.generateSign(MapUtil.objectToMap(
				unifiedorder, "sign"), payKey);
		// System.out.println(sign);
		unifiedorder.setSign(sign);

		UnifiedorderResult unifiedorderResult = new PayMchAPI()
				.payUnifiedorder(unifiedorder);
		String prePayId = unifiedorderResult.getPrepay_id();

		String json = PayUtil.generatePayJsRequestJson(null, appid, prePayId,
				payKey);
		request.setAttribute("json", json);
		System.out.println("Prepayid:"+unifiedorder.getPrepayid());
		return json;
		
	}

	public static void setJsSdkParam(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		String paramString = request.getQueryString();

		if (paramString != null && paramString.trim().length() > 0)
			url = url + "?" + paramString;

		/* try {
			url = URLEncoder.encode(url,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		String jsapi_ticket = WeixinGetAccessTokenListen.jsTicket;
		String nonceStr = SignatureUtil.create_nonce_str();
		String timestamp = SignatureUtil.create_timestamp();
		String signature = SignatureUtil.signatureJSSDK( jsapi_ticket, nonceStr,
				timestamp,url);

		request.setAttribute("appId", WeixinConfig.APPID);
		request.setAttribute("url", url);
		request.setAttribute("jsapi_ticket", jsapi_ticket);
		request.setAttribute("nonceStr", nonceStr);
		request.setAttribute("timestamp", timestamp);
		request.setAttribute("signature", signature);
	}

}
