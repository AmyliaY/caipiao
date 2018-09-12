package com.action.app;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.util.AlipayNotify;
import com.service.app.AppChongzhiTixianService;

/**
 * 支付宝购买商品回调
 * @author lgh
 *
 */
@Controller
@RequestMapping("/aliPayByCpdChonzhiNotify.do")
public class AliPayByCpdChonzhiNotifyAction {
	
	@Autowired
	private AppChongzhiTixianService chongzhiTixianService;
	
	@RequestMapping
	@ResponseBody
	public String callbakc(HttpServletRequest request) throws UnsupportedEncodingException
	{
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();

		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		params.remove("p");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no")
				.getBytes("ISO-8859-1"), "UTF-8");
		//支付宝交易号	
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		// 金额
		String total_fee = new String(request.getParameter("total_fee")
				.getBytes("ISO-8859-1"), "UTF-8");

		// 交易状态
		String trade_status = new String(request.getParameter("trade_status")
				.getBytes("ISO-8859-1"), "UTF-8");

		// 异步通知ID
		String notify_id = request.getParameter("notify_id");

		// sign
		String sign = request.getParameter("sign");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		if (notify_id != "" && notify_id != null) {// //判断接受的post通知中有无notify_id，如果有则是异步通知。
			if (AlipayNotify.verifyResponse(notify_id).equals("true")) {//这里需要关闭电脑的防火墙
				if (true)// 使用支付宝公钥验签 AlipayNotify.getSignVeryfyMD5(params, sign)
				{
					if (trade_status.equals("TRADE_SUCCESS")) {
						
						// 判断该笔订单是否在商户网站中已经做过处理
						// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						// 如果有做过处理，不执行商户的业务程序
						// 注意：
						// 付款完成后，支付宝系统发送该交易状态通知
						// 请务必判断请求时的out_trade_no、total_fee、seller_id与通知时获取的out_trade_no、total_fee、seller_id为一致的
						//appCrowdfundingservice.updateCrowdlog(out_trade_no,
						//		total_fee);
						//boolean f = appOrderService.alipayEditOrder(out_trade_no, Double.parseDouble(total_fee), 0.0);
						boolean f = chongzhiTixianService.changeCpdChongzhi(out_trade_no, Double.parseDouble(total_fee));
					}
					return "success";// 请不要修改或删除

				} else// 验证签名失败
				{
					System.out.println("签名失败");
					return "sign fail";
				}
			}
			return "response fail";
		} else {
			return "no notify message";
		}
	}
}
