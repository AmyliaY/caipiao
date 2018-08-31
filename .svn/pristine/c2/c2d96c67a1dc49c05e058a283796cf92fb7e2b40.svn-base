package com.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

public class MD5Util {

	public static void main(String[] args) {
		String pwd = (MD5Util.getMD5("123456"));
		System.out.println(pwd);
		
		
	}

	private static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}
	
	public static String base64Decode(String src)
	{
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] b = null;
		try {
			b = base64Decoder.decodeBuffer(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = new String(b);
		return result;
	}

	public static String jiemi(String src, String key) {

		// String Password = MD5.md5_24(pwd);
		// String Password = ;
		String Algorithm = "DESede";
		
		byte PassBytes[] = key.getBytes();
		byte KeyBytes[] = new byte[PassBytes.length];
		for (int i = 0; i < PassBytes.length; i++) {
//			if (i < PassBytes.length)
				KeyBytes[i] = PassBytes[i];
//			else
//				KeyBytes[i] = 0x30;
		}
		// 还原
		byte[] b = hexStringToBytes(src);
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		SecretKey DesKey = new SecretKeySpec(KeyBytes, Algorithm);

		try {
			Cipher C = Cipher.getInstance(Algorithm);
			C.init(Cipher.DECRYPT_MODE, DesKey);
			byte Encrypt[] = C.doFinal(b);

			return new String(Encrypt);
		} catch (Exception e) {

		}

		return null;

	}
	
	

	// 字符串加密
	public static String getMD5(String source) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messageDigest.update(source.getBytes());
		byte[] b = messageDigest.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(byteHEX(b[i]));
		}

		// sb.setCharAt(sb.length()-1, (char)(sb.charAt(sb.length()-1)+1));
		return sb.toString();
	}

	public static byte[] hexStringToBytes(String hexString) {

		if (hexString == null || hexString.equals("")) {

			return null;

		}

		hexString = hexString.toUpperCase();

		int length = hexString.length() / 2;

		char[] hexChars = hexString.toCharArray();

		byte[] d = new byte[length];

		for (int i = 0; i < length; i++) {

			int pos = i * 2;

			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

		}

		return d;
	}

	private static byte charToByte(char c) {

		return (byte) "0123456789ABCDEF".indexOf(c);
	}

}
