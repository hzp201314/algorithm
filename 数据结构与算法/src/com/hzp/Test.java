/** 
 * Project Name:数据结构与算法 
 * File Name:Test.java 
 * Package Name:com.hzp 
 * Date:2020年6月15日上午10:52:04 
 * Copyright (c) 2020, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

/** 
 * ClassName:Test <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2020年6月15日 上午10:52:04 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class Test {
	
	public static void main(String[] args) {
		//桶名称
		String bucket="obs-b824";
		//Access Key Id
		String SecretAccessKeyID="BUERNJLNMZODKTDQNC5W";
		String method="GET";
		String contentMd5="";
		String contentType="text/plain";
		String date="";
		//对象存储自定义的字段，以“x-amz-”作为前辍的消息头，如:“x-amz-date，x-amz-acl”。
		String canonicalizedOBSHeaders="";
		//表示HTTP请求所指定的对象存储资源，构造方式如下：<桶名+对象名>+[子资源]+[查询字符串]
		String object="ObjectName";
		String canonicalizedResource="/"+bucket+"/"+object;
		
		//构造日期
		SimpleDateFormat sdf3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z",Locale.US);
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
        date = sdf3.format(new Date());
//		Date dNow = new Date( );
//		date=dNow.toString();
		System.out.println("------date--------");
		System.out.println(date);
		
		
		
		//生成StringToSgin
		String StringToSgin=getStringToSgin(method,contentMd5,contentType,date,canonicalizedOBSHeaders,canonicalizedResource);
		
		//HMAC-SHA1加密
		String hmacSha = hmacSha1(StringToSgin, SecretAccessKeyID);
		
		//生成签名Signature
		String Signature=null;
		try {
		 Signature=Base64.getEncoder().encodeToString(hmacSha.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------StringToSgin--------");
		System.out.println(StringToSgin);
		System.out.println("------HMACSha--------");
		System.out.println(hmacSha);
		System.out.println("------Signature--------");
		System.out.println(Signature);
		
	}
	
	/**
	 * 
	 * @Title: getStringToSgin  
	 * @Description: TODO  
	 * @author codehan  
	 * @date 2020年6月15日 下午12:18:51 
	 * @param @param method
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getStringToSgin(String method,String contentMd5,String contentType,String date, String canonicalizedOBSHeaders,String canonicalizedResource ) {
//		StringToSign = HTTP-Verb + "\n" + Content-MD5 + "\n" + Content-Type + "\n" + Date + "\n" + CanonicalizedOBSHeaders + CanonicalizedResource。
//		x-amz-date:Tue, 15 Oct 2015 07:20:09GMT\n
		String StringToSign = method + "\n" 			//HTTP-Verb + "\n"
							+ contentMd5 + "\n" 		//Content-MD5 + "\n"
							+ contentType + "\n" 		//Content-Type + "\n"
							+ date + "\n" 				//Date + "\n"
							+ canonicalizedOBSHeaders 	//CanonicalizedOBSHeaders 
							+ canonicalizedResource;	//CanonicalizedResource
		
	
		return StringToSign;
	}
	
	/**
	 * 
	 * @Title: hmacSha1  
	 * @Description: TODO  
	 * @author codehan  
	 * @date 2020年6月15日 下午12:18:18 
	 * @param @param value
	 * @param @param key
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String hmacSha1(String value, String key) {
	    try {
	        // Get an hmac_sha1 key from the raw key bytes
	        byte[] keyBytes = key.getBytes();           
	        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

	        // Get an hmac_sha1 Mac instance and initialize with the signing key
	        Mac mac = Mac.getInstance("HmacSHA1");
	        mac.init(signingKey);

	        // Compute the hmac on input data bytes
	        byte[] rawHmac = mac.doFinal(value.getBytes());
	        
	        return byte2hex(rawHmac);

	        // Convert raw bytes to Hex
//	        byte[] hexBytes = new Hex().encode(rawHmac);

	        //  Covert array of Hex bytes to a String
//	        return new String(rawHmac, "UTF-8");
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	//二行制转字符串  
	public static String byte2hex(byte[] b) {
	    StringBuilder hs = new StringBuilder();
	    String stmp;
	    for (int n = 0; b!=null && n < b.length; n++) {
	        stmp = Integer.toHexString(b[n] & 0XFF);
	        if (stmp.length() == 1)
	            hs.append('0');
	        hs.append(stmp);
	    }
	    return hs.toString().toUpperCase();
	}
	
	
	/**
	 * 
	 * @Title: crypt  
	 * @Description: TODO  
	 * @author codehan  
	 * @date 2020年6月15日 下午2:03:25 
	 * @param @param str
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}



}
