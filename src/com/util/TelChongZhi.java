package com.util;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.util.MD5Util;
 

 
public class  TelChongZhi {  
// HttpClient请求的相关设置，可以不用配置，用默认的参数，这里设置连接和超时时长(毫秒)
public static RequestConfig config = RequestConfig.custom()
.setConnectTimeout(30000).setSocketTimeout(30000).build();
public static final String key ="aa5d21cbfa1d8e83655e1b87428a4433";//申请的接口Appkey
public static final String openId="JH0d3acaf69db89b9a402d4191cc5bf098";//在个人中心查询  
public static final String telCheckUrl = "http://op.juhe.cn/ofpay/mobile/telcheck?cardnum=*&phoneno=!&key="+key;
public static final String telQueryUrl="http://op.juhe.cn/ofpay/mobile/telquery?cardnum=*&phoneno=!&key="+key;
public static final String onlineUrl="http://op.juhe.cn/ofpay/mobile/onlineorder?key="+key+"&phoneno=!&cardnum=*&orderid=@&sign=$";
public static final String yueUrl="http://op.juhe.cn/ofpay/mobile/yue?key="+key+"&timestamp=%&sign=$";
public static final String orderstaUrl="http://op.juhe.cn/ofpay/mobile/ordersta?key="+key+"&orderid=!";
public static final String orderListUrl="http://op.juhe.cn/ofpay/mobile/orderlist?key="+key;
//---------------------------------------------------------------------------------------------------------------------------------------------




/**
* 1.检测手机号码是否能充值接口
* @param phone 手机号码
* @param cardnum 充值金额,目前可选：5、10、20、30、50、100、300
* @return 返回错码，0为允许充
值的手机号码及金额，其他为不可以或其他错误
* @throws Exception 
*/ 
public static int telCheck(String phone,int cardnum) throws Exception{
int error_code=0;
String result = get(telCheckUrl.replace("*", cardnum+"").replace("!", phone),0);
error_code =JSONObject.fromObject(result).getInt("error_code");
 return error_code;
  } 


/**
* 2.根据手机号和面值查询商品信息
* @param phone 手机号码
* @param cardnum 充值金额,目前可选：5、10、20、30、50、100、300
* @return String类型结果
* @throws Exception
*/
public static String telQuery(String phone,int cardnum) throws Exception{
String result = get(telQueryUrl.replace("*", cardnum+"").replace("!", phone),0);
return result;
}
/**
* 3.依据用户提供的请求为指定手机直接充值
* @param phone 手机号码
* @param cardnum 充值金额,目前可选：5、10、20、30、50、100、300
* @param orderid 商家订单号，8-32位字母数字组合，自定义
* @return 返回String结果 
* @throws Exception 
*/
public static String onlineOrder(String phone,int cardnum,String orderid) throws Exception{
String result = null; 
//Md5Util工具类
String sign = MD5Util.getMD5(openId+key+phone+cardnum+orderid);

result = get(onlineUrl.replace("*", cardnum+"").replace("!", phone).replace("@", orderid).replace("$", sign),0);
return result;
}
/**
* 4.查询账户余额
* @return
* @throws Exception 
*/
public static String yuE() throws Exception{
String timestamp = System.currentTimeMillis()/1000+"";
String sign =  MD5Util.getMD5(openId+key+timestamp);
String result =get(yueUrl.replace("%", timestamp).replace("$", sign),0);
return result;  
}
/** 
* 5.订单状态查询 
* @param orderid 商家订单号
* @return 订单结果
* @throws Exception
*/
public static String orderSta(String orderid) throws Exception{
return get(orderstaUrl.replace("1", orderid), 0);
}
/**
* 6.历史订单列表
* @return
* @throws Exception
*/
public static String orderList() throws Exception{
return get(orderListUrl,0);
}
/**工具类方法
* get 网络请求
* @param url 接收请求的网址
* @param tts 重试
* @return String类型 返回网络请求数据 
* @throws Exception 网络异常
*/
  public static String get(String url,int tts) throws Exception{
 if(tts>3){//重试3次
 return null;
 }
 CloseableHttpClient httpClient = HttpClients.createDefault();
 CloseableHttpResponse response = null;
 String result = null;
try {
HttpGet httpGet = new HttpGet(url);
httpGet.setConfig(config);
response = httpClient.execute(httpGet);
HttpEntity resEntity = response.getEntity();
if (resEntity != null) {
result = ConvertStreamToString(resEntity.getContent(), "UTF-8");
}
EntityUtils.consume(resEntity);
return result;
}catch(IOException e){
return get(url, tts++);
}finally {
response.close(); 
httpClient.close();
}
// 得到的是JSON类型的数据需要第三方解析JSON的jar包来解析
  }
  /**工具类方法
   * 此方法是把传进的字节流转化为相应的字符串并返回，此方法一般在网络请求中用到
   * @param is 输入流
   * @param charset 字符格式
   * @return String 类型 
   * @throws Exception
   */
  public static String ConvertStreamToString(InputStream is, String charset)
  throws Exception {
  StringBuilder sb = new StringBuilder();
  InputStreamReader inputStreamReader = new InputStreamReader(is,
  charset);
   BufferedReader reader = new BufferedReader(inputStreamReader) ;
  String line = null;
  while ((line = reader.readLine()) != null) {
  sb.append(line).append("\r\n");   
     } 
     return sb.toString(); 
  }
}