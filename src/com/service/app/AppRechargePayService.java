package com.service.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;


@Service
public class AppRechargePayService {
	
	public static void main(String[] args) {
		//appid=wxe61bb49c4161d3db&body=chongzhi&device_info=shuiguo&goods_tag=shuiguo&mch_id=1508459351&nonce_str=33b5b4fd6e284adeb583076613bb6a20&notify_url=http://www.sssnjt.com/&out_trade_no=9de65fbb570848398f9ef5fd2889d58b&product_id=shuiguo&spbill_create_ip=192.168.0.100&time_expire=20180626171847&time_start=20180625171847&total_fee=1&trade_type=APP
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		float money = Float.parseFloat("0.01");// 支付金额

		String name = "充值";

		String appid = "wxe61bb49c4161d3db";// "wxe61bb49c4161d3db"
		String mch_id ="1508459351"; // 商户号
		String payKey = "shennongguopinhui201862619871210"; // 支付key
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setBody(name);// 商品描述
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(SignatureUtil.create_nonce_str().replaceAll("-", ""));
		unifiedorder.setNotify_url("http://www.sssnjt.com/");// 通知地址
		unifiedorder.setOut_trade_no(id); // 外部订单号
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timeStart = sdf.format(date);
		String timeExpire = sdf.format(new Date(
				date.getTime() + 24L * 3600 * 1000));
		unifiedorder.setTime_expire(timeExpire);
		unifiedorder.setTime_start(timeStart);
		// 用户端实际ip
		unifiedorder.setSpbill_create_ip("192.168.0.100");
		String money2 = money * 100 + ""; //
		int index = money2.indexOf('.');
		if (index > -1) {
			money2 = money2.substring(0, index);
		}

		// money2="1";

		unifiedorder.setTotal_fee(money2);

		// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
		//unifiedorder.setAttach("");
		
		// 支付类型
		unifiedorder.setTrade_type("APP");
		
		String sign = SignatureUtil.generateSign(MapUtil.objectToMap(
				unifiedorder, "sign"),payKey);
		
		unifiedorder.setSign(sign);
		
		UnifiedorderResult unifiedorderResult = new PayMchAPI()
		.payUnifiedorder(unifiedorder);
		
		String return_code=unifiedorderResult.getReturn_msg();
		System.out.println(return_code);
	}

	public static String payByWxpay(String notifyUrl,HttpServletRequest request, String orderId) {
		String id = orderId;
		float money = Float.parseFloat("0.01");// 支付金额

		String name = "充值";

//		String appid = WeixinConfig.APPID;// "wx94df44a32ee2fabc"
//		String mch_id = WeixinConfig.MCH_ID; // 商户号
//		String payKey = WeixinConfig.PAY_KEY; // 支付key
		String appid = "wxe61bb49c4161d3db";// "wxe61bb49c4161d3db"
		String mch_id ="1508459351"; // 商户号
		String payKey = "shennongguopinhui201862619871210"; // 支付key

		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setBody(name);// 商品描述
		//unifiedorder.setDevice_info("");
		//unifiedorder.setGoods_tag("");
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString()
				.replaceAll("-", ""));
		unifiedorder.setNotify_url(notifyUrl);// 通知地址
		unifiedorder.setOut_trade_no(id); // 外部订单号

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		unifiedorder.setTime_expire(sdf.format(new java.util.Date(System
				.currentTimeMillis() + 24 * 3600 * 1000)));
		unifiedorder.setTime_start(sdf.format(new Date()));
		// 用户端实际ip
		unifiedorder.setSpbill_create_ip(request.getLocalAddr());
		String money2 = money * 100 + ""; //
		int index = money2.indexOf('.');
		if (index > -1) {
			money2 = money2.substring(0, index);
		}

		// money2="1";

		unifiedorder.setTotal_fee(money2);

		// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
		//unifiedorder.setAttach("");
		
		// 支付类型
		unifiedorder.setTrade_type("APP");
		
		String sign = SignatureUtil.generateSign(MapUtil.objectToMap(
				unifiedorder, "sign"), payKey);
		unifiedorder.setSign(sign);
		
		UnifiedorderResult unifiedorderResult = new PayMchAPI()
		.payUnifiedorder(unifiedorder);
		
		String return_code=unifiedorderResult.getReturn_code();
		System.out.println(return_code);
		
		if("FAIL".equalsIgnoreCase(return_code)){
			String return_msg=unifiedorderResult.getReturn_msg();
			System.out.println("wo");
			System.out.println(return_msg);
			return "false";
		}
		
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		
		String prepay_id=unifiedorderResult.getPrepay_id();
		
		mch_id=unifiedorderResult.getMch_id();
		
		String noncestr=unifiedorderResult.getNonce_str();
		
		appid=unifiedorderResult.getAppid();
		
		//还需要重新生成 sign
		String s="appid="+appid+"&noncestr="+noncestr+"&package=Sign=WXPay"+"&partnerid="+
        	mch_id+"&prepayid="+prepay_id+"&timestamp="+timestamp+"&key=" +payKey;
		String newSign = new String(Hex.encodeHex(DigestUtils.md5(s))).toUpperCase();
		//{"appid":"wx0411fa6a39d61297","noncestr":"ZDcJqjcy3CBDVFD0","package":"Sign=WXPay","partnerid":"1230636401","prepayid":"wx26151426103818a8b5013ed32367493799","timestamp":1529997266,
		//"sign":"1B57E0A7672953BEE294E5FBD1F5BCAA"}
		StringBuffer json = new StringBuffer();
	    json.append("{\"appid\":\"");
	    json.append(appid);
	    json.append("\",\"noncestr\":\"");
	    json.append(noncestr);
	    json.append("\",\"package\":\"");
	    json.append("Sign=WXPay");
	    json.append("\",\"partnerid\":\"");
	    json.append(mch_id);
	    json.append("\",\"prepayid\":\"");
	    json.append(prepay_id);
	    json.append("\",\"timestamp\":\"");
	    json.append(timestamp);
	    json.append("\",\"sign\":\"");
	    json.append(newSign);
	    json.append("\"}");
		
		return json.toString();
	}
}
