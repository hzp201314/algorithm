/** 
 * Project Name:02-动态数组 
 * File Name:Asserts.java 
 * Package Name:com.hzp 
 * Date:2019年12月29日下午9:03:09 
 * Copyright (c) 2019, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp;

/** 
 * ClassName:Asserts <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年12月29日 下午9:03:09 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class Asserts {
	public static void test(boolean value) {
		try {
			if (!value) throw new Exception("测试未通过");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
