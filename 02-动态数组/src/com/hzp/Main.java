/** 
 * Project Name:02-动态数组 
 * File Name:Main.java 
 * Package Name:com.hzp 
 * Date:2019年12月29日下午9:01:09 
 * Copyright (c) 2019, 952646089@qq.com All Rights Reserved. 
 * 
*/
package com.hzp;

/**
 * ClassName:Main <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月29日 下午9:01:09 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(99);
		list.add(88);
		list.add(77);
		list.add(66);
		
		
		list.set(3, 80);
		
		Asserts.test(list.get(3)==80);
		System.out.println(list.get(3));
	}

}
