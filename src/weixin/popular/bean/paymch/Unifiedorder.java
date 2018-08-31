package weixin.popular.bean.paymch;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import weixin.popular.bean.AdaptorCDATA;

import com.util.MD5Util;

/**
 * 统一支付请求参数
 * 
 * @author Yi
 * 
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unifiedorder {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}

	@XmlElement
	private String appid;

	@XmlElement
	private String mch_id;

	@XmlElement
	private String device_info;

	@XmlElement
	private String nonce_str;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String sign;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String body;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String attach;

	@XmlElement
	private String out_trade_no;

	@XmlElement
	private String total_fee;

	@XmlElement
	private String spbill_create_ip;

	@XmlElement
	private String time_start;

	@XmlElement
	private String time_expire;

	@XmlElement
	private String goods_tag;

	@XmlElement
	private String notify_url;

	@XmlElement
	private String trade_type;

	@XmlElement
	private String openid;

	@XmlElement
	private String product_id;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/*
	 * appid: "wx0411fa6a39d61297", noncestr: "oUn3BJl37NhyEPgf", package:
	 * "Sign=WXPay", partnerid: "1230636401", prepayid:
	 * "wx20151203182611a03572a62d0054237692", timestamp: "1449138371", sign:
	 * "313966BE242897F2A82090190630A2D0" (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toStoStringtring() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"appid\":\"");
		sb.append(appid);
		sb.append("\",\"noncestr\":\"").append(nonce_str).append("\",");
		sb.append("\"package\":\"Sign=WXPay\",");
		sb.append("\"partnerid\":\"").append(mch_id).append("\",");
		sb.append("\"prepayid\":\"").append(prepayid).append("\",");
		String t = new String(System.currentTimeMillis()+"").substring(0,10);//new Date().getTime();
		sb.append("\"timestamp\":\"").append(t)
				.append("\",");

		String s = "appid=" + appid + "&noncestr=" + nonce_str
				+ "&package=Sign=WXPay" + "&partnerid=" + mch_id + "&prepayid="
				+ prepayid + "&timestamp=" + t + "&key="
				+ "kkjll19606181606867999KEKE196061";
        
		System.out.println(s);
		String newSign = new String(Hex.encodeHex(DigestUtils.md5(s)));

		// {"appid":"wx0411fa6a39d61297","noncestr":"glTe0aYJZx3Vmrv6","package":"Sign=WXPay","partnerid":"1230636401","prepayid":"wx2016040417591214b7295f010726393993","timestamp":1459763952,"sign":"B9D74731BD3DB4D7C86A93D54595757A"}
		sb.append("\"sign\":\"").append(newSign.toUpperCase()).append("\"}");
        System.out.println(sb+"@");
		return sb.toString().trim();
	}

	private String prepayid;

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

}
