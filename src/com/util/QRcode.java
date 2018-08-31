package com.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class QRcode {
	
	public static void main(String[] args) throws HttpException, IOException {
		String url  = "https://accpbet.sporttery.cn/?m=bet&c=szcBet&d=offline&vId=1600000&cmsWhere=400000&g_token=1280994680&useCookie=1";
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("Cookie", "deviceVer=samsung_SM-G9350_7.0; iswx=2; ckStr=MTAwMDAwMDAwODgzNTYwNjNGNDgxMjY1Q0IwQTM0MDdGOUNFRUEyRUE2RDc1Njg; vId=1600000; token=c58645705ccebf014f2f843e95881298d5c263ad; uuid=352709084004316; cms_where=400000; province=43; lskey=MTAwMDAwMDAwODgzNTYwNjNGNDgxMjY1Q0IwQTM0MDdGOUNFRUEyRUE2RDc1Njg; screenRes=1080-1920; appVersion=1600000; vest=ticai; agentId=110001; accountNo=1000000008835606; manufacturer=samsung; channel=400000; sdkVer=24; logicVID=1600000; interfaceVersion=1; platform=1; browserBrand=; user-agent-key=4ed92dce-9c09-5554-8b3c-d4dfe43109a5; appType=ticai_android; brand=SM-G9350; cmsWhere=400000; uid=1000000008835606; deviceVersion=24; seckey=ba21615d90bc0a6e5e73c3fd7288a229");
		method.addRequestHeader("user-agent-key", "4ed92dce-9c09-5554-8b3c-d4dfe43109a5");
		method.addRequestHeader("appType", "ticai_android");
		method.addRequestHeader("brand", "SM-G9350");
		method.addRequestHeader("cmsWhere", "400000");
		method.addRequestHeader("uid", "1000000008835606");
		method.addRequestHeader("deviceVersion", "24");
		method.addRequestHeader("referer", "https://accpbet.sporttery.cn/");
		method.addRequestHeader("Accept-Encoding", "gzip,deflate");
		method.addRequestHeader("hseckey", "8b5d590d8eb3f718235f2853a5479cee");
		method.addRequestHeader("platform", "1");
		method.addRequestHeader("interfaceVersion", "1");
		method.addRequestHeader("logicVID", "1600000");
		method.addRequestHeader("sdkVer", "24");
		method.addRequestHeader("channel", "400000");
		method.addRequestHeader("accountNo", "1000000008835606");
		method.addRequestHeader("agentId", "110001");
		method.addRequestHeader("vest", "ticai");
		method.addRequestHeader("appVersion", "1600000");
		method.addRequestHeader("screenRes", "1080-1920");
		method.addRequestHeader("lskey", "MTAwMDAwMDAwODgzNTYwNjNGNDgxMjY1Q0IwQTM0MDdGOUNFRUEyRUE2RDc1Njg");
		method.addRequestHeader("province", "43");
		method.addRequestHeader("cms_where", "400000");
		method.addRequestHeader("uuid", "352709084004316");
		method.addRequestHeader("token", "c58645705ccebf014f2f843e95881298d5c263ad");
		method.addRequestHeader("vId", "1600000");
		method.addRequestHeader("ckStr", "MTAwMDAwMDAwODgzNTYwNjNGNDgxMjY1Q0IwQTM0MDdGOUNFRUEyRUE2RDc1Njg");
		method.addRequestHeader("iswx", "2");
		method.addRequestHeader("seckey", "9b31eac6409c30cb9cb9c65b5972300d");
		method.addRequestHeader("Host", "accpbet.sporttery.cn");
		method.addRequestHeader("Connection", "Keep-Alive");
		method.addRequestHeader("Content-Length", "447");
		method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		method.addRequestHeader("", "");
		method.addRequestHeader("", "");
		
		NameValuePair nameValuePair1 = new NameValuePair("total_money","1000");
		NameValuePair nameValuePair2 = new NameValuePair("cms_where","400000");
		NameValuePair nameValuePair3 = new NameValuePair("codes","07,12,13,23,28|07,08#1");
		NameValuePair nameValuePair4 = new NameValuePair("qihao","18075");
		NameValuePair nameValuePair5 = new NameValuePair("loty","85");
		NameValuePair nameValuePair6 = new NameValuePair("project_desc","[85] 期号：18075");
		NameValuePair nameValuePair7 = new NameValuePair("qihao_id","18075");
		NameValuePair nameValuePair8 = new NameValuePair("process_act","0");
		NameValuePair nameValuePair9 = new NameValuePair("project_title","[85] Android下单");
		NameValuePair nameValuePair10 = new NameValuePair("beishu","5");
		NameValuePair nameValuePair11= new NameValuePair("channel","ad_ticai");
		NameValuePair nameValuePair12 = new NameValuePair("zhuijia","0");
		NameValuePair nameValuePair13 = new NameValuePair("longitude","113.115117");
		NameValuePair nameValuePair14 = new NameValuePair("danma","");
		NameValuePair nameValuePair15 = new NameValuePair("zhushu","1");
		NameValuePair nameValuePair16 = new NameValuePair("select","1");
		NameValuePair nameValuePair17 = new NameValuePair("platform","1");
		NameValuePair nameValuePair18 = new NameValuePair("key_val","7925859261530112181115");
		NameValuePair nameValuePair19= new NameValuePair("balance","0");
		NameValuePair nameValuePair20 = new NameValuePair("opentype","0");
		NameValuePair nameValuePair21 = new NameValuePair("play_id","1");
		NameValuePair nameValuePair22 = new NameValuePair("latitude","27.836066");
		NameValuePair nameValuePair23 = new NameValuePair("payPsw","");
		NameValuePair nameValuePair24 = new NameValuePair("selType","10");
		NameValuePair nameValuePair25 = new NameValuePair("v_id","1600000");
		NameValuePair nameValuePair26 = new NameValuePair("","");
		NameValuePair nameValuePair27 = new NameValuePair("","");
		NameValuePair nameValuePair28 = new NameValuePair("","");
		NameValuePair nameValuePair29 = new NameValuePair("","");
		NameValuePair nameValuePair30 = new NameValuePair("","");
		
		NameValuePair[] parametersBody = new NameValuePair[]{nameValuePair1,nameValuePair2,nameValuePair3,nameValuePair4,nameValuePair5,nameValuePair6,nameValuePair7,nameValuePair8,nameValuePair9,nameValuePair10,nameValuePair11,nameValuePair12,nameValuePair13,nameValuePair14,nameValuePair15,nameValuePair16,nameValuePair17,nameValuePair18,nameValuePair19,nameValuePair20,nameValuePair21,nameValuePair22,nameValuePair23,nameValuePair24,nameValuePair25,nameValuePair26,nameValuePair27,nameValuePair28,nameValuePair29,nameValuePair30}; 
		
		method.setRequestBody(parametersBody);
		

		//method.setRequestBody("total_money=1000&province=43&cms_where=400000&codes=07%2C12%2C13%2C23%2C28%7C07%2C08%231&qihao=18075&loty=85&project_desc=%5B85%5D+%E6%9C%9F%E5%8F%B7%EF%BC%9A18075&qihao_id=18075&process_act=0&project_title=%5B85%5D+Android%E4%B8%8B%E5%8D%95&beishu=5&channel=ad_ticai&zhuijia=0&longitude=113.115117&danma=&zhushu=1&select=1&platform=1&key_val=7925859261530112181115&balance=0&ope"ntype=0&play_id=1&latitude=27.836066&payPsw=&selType=10&v_id=1600000");
		 //method.setRequestBody("total_money=1000&province=43&cms_where=400000&codes=07%2C12%2C13%2C23%2C28%7C07%2C08%231&qihao=18075&loty=85&project_desc=%5B85%5D+%E6%9C%9F%E5%8F%B7%EF%BC%9A18075&qihao_id=18075&process_act=0&project_title=%5B85%5D+Android%E4%B8%8B%E5%8D%95&beishu=5&channel=ad_ticai&zhuijia=0&longitude=113.115117&danma=&zhushu=1&select=1&platform=1&key_val=7925859261530112181115&balance=0&opentype=0&play_id=1&latitude=27.836066&payPsw=&selType=10&v_id=1600000".getBytes());
		
		int ret = client.executeMethod(method);
		if (ret==200)
		{
			String response = method.getResponseBodyAsString();
			System.out.println(response);
		}
		
	}

}
