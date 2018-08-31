package weixin.popular.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import weixin.popular.bean.pay.PayFeedback;
import weixin.popular.bean.pay.PayNativeInput;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.pay.PayWarn;

public class SignatureUtil {

	public static void main(String[] args) {
		String url = "http://mp.weixin.qq.com";
		String jsapi_ticket= "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg";
		String noncestr="Wm3WZYTPz0wzccnW";
		String  timestamp = "1414587457";
		String sign = signatureJSSDK(url, jsapi_ticket, noncestr, timestamp);
		System.out.println(sign);
		
		
		
	}
	
	 public static String create_nonce_str() {
	        return UUID.randomUUID().toString();
	    }

	    public static String create_timestamp() {
	        return Long.toString(System.currentTimeMillis() / 1000);
	    }
	
	public static String signatureJSSDK(String jsapi_ticket,String nonceStr,String timestamp,String url)
	{
		Map map = new HashMap();
		
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("noncestr", nonceStr);
		map.put("timestamp", timestamp);
		map.put("url", url);
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap, false, false);
		MessageDigest crypt = null;
		try {
			crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String signature = byteToHex(crypt.digest());
		return signature;
	}
	
	private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

	/**
	 * 生成 package 字符串
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generatePackage(Map<String, String> map,
			String paternerKey) {
		String sign = generateSign(map, paternerKey);
		Map<String, String> tmap = MapUtil.order(map);
		String s2 = MapUtil.mapJoin(tmap, false, true);
		return s2 + "&sign=" + sign;
	}

	/**
	 * 生成sign MD5 加密 toUpperCase
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generateSign(Map<String, String> map,
			String paternerKey) {
		Map<String, String> tmap = MapUtil.order(map);
		if (tmap.containsKey("sign")) {
			tmap.remove("sign");
		}
		String str = MapUtil.mapJoin(tmap, false, false);

		//String key = MD5Util.getMD5(str + "&key=" + paternerKey)
		//		.toUpperCase();
		//String key = DigestUtils.md5Hex((str + "&key=" + paternerKey).getBytes())
		//.toUpperCase();
		String key =new String(Hex.encodeHex(DigestUtils.md5(str + "&key=" + paternerKey)));
		return key;
	}
	
	
	/**
	 * 生成sign MD5 加密 toUpperCase
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generateSignNoKEY(Map<String, String> map,
			String paternerKey) {
		Map<String, String> tmap = MapUtil.order(map);
		if (tmap.containsKey("sign")) {
			tmap.remove("sign");
		}
		String str = MapUtil.mapJoin(tmap, false, false);

		//String key = MD5Util.getMD5(str + "&key=" + paternerKey)
		//		.toUpperCase();
		//String key = DigestUtils.md5Hex((str + "&key=" + paternerKey).getBytes())
		//.toUpperCase();
		String key =new String(Hex.encodeHex(DigestUtils.md5(str)));
		return key;
	}

	/**
	 * 生成 paySign
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generatePaySign(Map<String, String> map,
			String paySignKey) {
		if (paySignKey != null) {
			map.put("appkey", paySignKey);
		}
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap, true, false);
		return DigestUtils.shaHex(str).toUpperCase();
	}

	/**
	 * 生成 paySign
	 * 
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generatePaySign(Map<String, String> map) {
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap, true, false);
		return DigestUtils.md5Hex(str).toUpperCase();
	}

	/**
	 * 生成事件消息接收签名
	 * 
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String generateEventMessageSignature(String token,
			String timestamp, String nonce) {
		String[] array = new String[] { token, timestamp, nonce };
		Arrays.sort(array);
		String s = StringUtils.arrayToDelimitedString(array, "");
		return DigestUtils.shaHex(s);
	}

	/**
	 * 验证 pay feedback appSignature 签名
	 * 
	 * @param payFeedback
	 * @param paySignKey
	 *            公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayFeedback payFeedback,
			String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payFeedback, "msgtype",
				"appsignature", "signmethod", "feedbackid", "transid",
				"reason", "solution", "extinfo", "picInfo");
		return payFeedback.getAppsignature().equals(
				generatePaySign(map, paySignKey));
	}

	/**
	 * 验证 pay native appSignature 签名
	 * 
	 * @param payNativeInput
	 * @param paySignKey
	 *            公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayNativeInput payNativeInput,
			String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNativeInput,
				"appsignature", "signmethod");
		return payNativeInput.getAppsignature().equals(
				generatePaySign(map, paySignKey));
	}

	/**
	 * 验证 pay notify appSignature 签名
	 * 
	 * @param payNotify
	 * @param paySignKey
	 *            公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayNotify payNotify,
			String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNotify,
				"appsignature", "sign");
		return payNotify.getSign().equals(generateSign(map, paySignKey));
	}

	/**
	 * 验证 pay warn appSignature 签名
	 * 
	 * @param payWarn
	 * @param paySignKey
	 *            公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayWarn payWarn,
			String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payWarn, "appsignature",
				"signmethod");
		return payWarn.getAppsignature().equals(
				generatePaySign(map, paySignKey));
	}

}
