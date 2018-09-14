package com.action.weixin;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.XMLConverUtil;

import com.service.app.AppChongzhiTixianService;

/**
 * 微信端微信支付-充值
 * @author lgh-pc
 */
@Controller("wexinChongzhiPay")
@RequestMapping("/wexinCpdChongzhiPay.dos")
public class WeixinChongzhiPayAction {

	@Autowired
	private AppChongzhiTixianService chongzhiTixianService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 微信支付回调函数
	 * 
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
				double money = 0.0;
				if (payNotify.getTotal_fee() != null) {
					money = Double.parseDouble(payNotify.getTotal_fee()) / 100;
				}
				// 这里支付成功后修改订单状态
				boolean f = chongzhiTixianService.changeCpdChongzhi(trade_no, money);
				return "success";
			}
		} else {
			return "error";
		}
	}
}
