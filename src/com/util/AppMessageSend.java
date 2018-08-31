package com.util;

import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.ITemplate;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

public class AppMessageSend {

	// 定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
	private static String appId = "K44jW59TFv9JQTtf5Afa51";
	private static String appKey = "U57daRf1bU6yhjBVTdimH3";
	private static String masterSecret = "LuyCBF5erL7Z0ueiPSDYa7";
	private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

	
	/**
	 * 
	 *  NotificationTemplate template = new NotificationTemplate();
		 template.setAppId(appId);
		 template.setAppkey(appKey);
		 template.setTransmissionType(1); //理解启动应用
		 
		 Style0 style = new Style0(); // 设置通知栏标题与内容 
		 style.setTitle("请输入通知栏标题"); 
		 style.setText("请输入通知栏内容"); // 配置通知栏图标
		 style.setLogo("icon.png"); // 配置通知栏网络图标
		 style.setLogoUrl(""); // 设置通知是否响铃，震动，或者可清除
		 style.setRing(true); style.setVibrate(true); style.setClearable(true); template.setStyle(style);
     
     发送链接消息 LinkTemplate template = new LinkTemplate();
	 * template.setAppId(appId); template.setAppkey(appKey);
	 * template.setTitle("欢迎使用个推!"); template.setText("这是一条推送消息~");
	 * template.setUrl("http://getui.com");
     
     发送透析消息: 语音提示
	 * TransmissionTemplate template = new TransmissionTemplate();
	 * template.setAppId(appId); template.setAppkey(appkey); //
	 * 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	 * template.setTransmissionType(2);
	 * template.setTransmissionContent("请输入需要透传的内容");
	 * @param template
	 * @param clientId
	 * @return
	 */
	public static String sendMessage(ITemplate template, String clientId) {
		IGtPush push = new IGtPush(url, appKey, masterSecret);
		SingleMessage message = new SingleMessage();
		message.setData(template);
		message.setOffline(true);
		message.setOfflineExpireTime(1000 * 600);
		Target target = new Target();
		target.setAppId(appId);
		target.setClientId(clientId);
		IPushResult ret = push.pushMessageToSingle(message, target);
		return (ret.getResponse().toString());
	}
	
	
	
	
	/**
	 * 发送多人消息
	 * @param template
	 * @param clientIds
	 * @return
	 * pushMessageToList
	 */
	public static String sendMessage(ITemplate template, List<String> clientIds)
	{
		
		IGtPush push = new IGtPush(url, appKey, masterSecret);
		ListMessage  message = new ListMessage ();
		message.setData(template);
		message.setOffline(true);
		message.setOfflineExpireTime(1000 * 600);
		List listTarget = new ArrayList();
		for (String c:clientIds)
		{
			Target target = new Target();
			target.setAppId(appId);
			target.setClientId(c);
			listTarget.add(target);
		}
		
		String contentId = push.getContentId(message);
		IPushResult ret = push.pushMessageToList(contentId, listTarget);
		return ret.getResponse().toString();
	}

	public static void main(String[] args) {
		  //TransmissionTemplate template = new TransmissionTemplate();
		 NotificationTemplate template = new NotificationTemplate();
		 template.setAppId(appId);
		 template.setAppkey(appKey);
		 template.setTransmissionType(1); //理解启动应用
		 template.setTransmissionContent("这样");
		 
		 Style0 style = new Style0(); // 设置通知栏标题与内容 
		 style.setTitle("水菟彩票通知！"); 
		 style.setText("您的订单已被水菟彩票店接收并处理！"); // 配置通知栏图标
		 style.setLogo("icon.png"); // 配置通知栏网络图标
		 style.setLogoUrl(""); // 设置通知是否响铃，震动，或者可清除
		 style.setRing(true); style.setVibrate(true); style.setClearable(true); 
		 
		 template.setStyle(style);
      
		
		String clientId = "7fda5cfca050c0c7ed41788496a4462a";
		List list = new ArrayList();
		list.add(clientId);
		String ret = AppMessageSend.sendMessage(template, list);
		System.out.println(ret);
	}
	
	/**
	 * @param appUrl 
	 * @param content 
	 * @param title 
	 * 
	 * @Title: AppMessageSend
	 * @author: Kk QQ:279697375
	 * @Description: 发送消息     
	 * @throws
	 */
	public static String sendManageList(final List<String> clientIds, final  String title, final  String content)
	{
		 new Thread(){public void run() {
			 
			 System.out.println("来了");
			 NotificationTemplate template = new NotificationTemplate();
//			 TransmissionTemplate template = new TransmissionTemplate();
			 template.setAppId(appId);
			 template.setAppkey(appKey);
			 template.setTransmissionType(1); //理解启动应用
			 template.setTransmissionContent(content);
			 
			 Style0 style = new Style0(); // 设置通知栏标题与内容 
			 style.setTitle(title); 
			 style.setText(content); // 配置通知栏图标
			 style.setLogo("icon.png"); // 配置通知栏网络图标
			 style.setLogoUrl(""); // 设置通知是否响铃，震动，或者可清除
			 style.setRing(true); style.setVibrate(true); style.setClearable(true); 
			 
			template.setStyle(style);
			IGtPush push = new IGtPush(url, appKey, masterSecret);
			ListMessage  message = new ListMessage ();
			message.setData(template);
			message.setOffline(true);
			message.setOfflineExpireTime(1000 * 600);
			List listTarget = new ArrayList();
			for (String c:clientIds)
			{
				Target target = new Target();
				target.setAppId(appId);
				target.setClientId(c);
				listTarget.add(target);
			}
			
			String contentId = push.getContentId(message);
			IPushResult ret = push.pushMessageToList(contentId, listTarget);
			//return ret.getResponse().toString();
		 };}.start();
		 
		 return "ok";
	}


}
