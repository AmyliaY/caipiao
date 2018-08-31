package weixin.popular.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.popular.api.PayMchAPI;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.SnsToken;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.MapUtil;
import weixin.popular.util.PayUtil;
import weixin.popular.util.SignatureUtil;

/**
 * 生成WEB JS 支付请求json
 * @author LiYi
 * 
 * 1.网页
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6a1e70a87f9fb08e&redirect_uri=http%3A%2F%2Fiptv2.vicp.net%2Fweixin%2FpaySend.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect

 * 2.-->paySend.do(取code,取openid)-->pay_example.jsp(支付界面)
 * 
 * 3.PayNotifyServlet.java 写后台数据库
 *  payNotify.do
 *
 */
public class PayJsServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String appid="wx6a1e70a87f9fb08e";
    	String secret="b1994c2675bb3a752ea740212f9a692e";
    	String mch_id = "1231794002"; //商户号
    	String payKey = "b1994c2675bb3a752ea740212f9a692a";
    	
    	/*
    	String redirectUrl = "http://iptv2.vicp.net/weixin/paySend.do";
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+URLEncoder.encode(redirectUrl,"utf-8")+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		System.out.println(url);
		*/
    	
    	
    	String code = request.getParameter("code");
    	SnsToken snsToken = new SnsAPI().oauth2AccessToken(appid, secret, code);
    	String openId = snsToken.getOpenid();
    	
    	Unifiedorder unifiedorder = new Unifiedorder();
    	unifiedorder.setAppid(appid);
    	unifiedorder.setBody(new String("手机2".getBytes(),"iso8859-1"));
    	unifiedorder.setDevice_info("1314520");
    	unifiedorder.setGoods_tag("iphone6");
    	unifiedorder.setMch_id(mch_id);
    	unifiedorder.setNonce_str(UUID.randomUUID().toString().replaceAll("-", ""));
    	unifiedorder.setNotify_url("http://iptv2.vicp.net/weixin/payNotify.do");//通知地址
    	unifiedorder.setOpenid(openId);
    	unifiedorder.setOut_trade_no(new Date().getTime()+""); //外部订单号
    	//unifiedorder.setProduct_id("131452");//产品号（二维码时有用)
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	unifiedorder.setTime_expire(sdf.format(new Date(System.currentTimeMillis()+24*3600*1000)));
    	unifiedorder.setTime_start(sdf.format(new Date()));
    	unifiedorder.setSpbill_create_ip(request.getLocalAddr());//客户端ip
    	unifiedorder.setTotal_fee("1"); //订单总金额，分
        unifiedorder.setAttach(java.net.URLEncoder.encode("手机","utf-8"));
    	unifiedorder.setTrade_type("JSAPI");
    	//System.out.println(MapUtil.objectToMap(unifiedorder,"sign"));
    	
    	String sign = SignatureUtil.generateSign(MapUtil.objectToMap(unifiedorder,"sign"), payKey);
    	//System.out.println("sign!!!!:"+sign);
    	unifiedorder.setSign(sign);
    	UnifiedorderResult unifiedorderResult = new PayMchAPI().payUnifiedorder(unifiedorder);
    	String pid  = unifiedorderResult.getPrepay_id();
		String json = PayUtil.generatePayJsRequestJson(null,appid,pid, payKey);
		//将json 传到jsp 页面
		request.setAttribute("json", json);
		System.out.println(json);
    	request.getRequestDispatcher("/pay_example.jsp").forward(request, response);
    
		
	}


}
