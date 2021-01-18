/** 
 * Project Name:00-leetcode 
 * File Name:_004_寻找两个正序数组的中位数.java 
 * Package Name:com.hzp.algorithm 
 * Date:2020年7月9日下午4:27:34 
 * Copyright (c) 2020, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * ClassName:_004_寻找两个正序数组的中位数 <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2020年7月9日 下午4:27:34 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class _0004_寻找两个正序数组的中位数 {

	/*
	 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
	 * 
	 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	 * 
	 * 你可以假设 nums1 和 nums2 不会同时为空。
	 * 
	 *  
	 * 
	 * 示例 1:
	 * 
	 * nums1 = [1, 3] nums2 = [2]
	 * 
	 * 则中位数是 2.0 示例 2:
	 * 
	 * nums1 = [1, 2] nums2 = [3, 4]
	 * 
	 * 则中位数是 (2 + 3)/2 = 2.5
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.printf(createFileName("S00007"));
		String mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE").format(new Date());
		System.out.printf(mFormat);
	}
	
//	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//	    }
	
	  public static String createFileName(String shipNoS) {
	        long currentTimeMillis = System.currentTimeMillis();
	        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	        String date = df.format(currentTimeMillis);
	        return shipNoS + "_" + date + "_" + currentTimeMillis + ".jpg";
	    }

}
