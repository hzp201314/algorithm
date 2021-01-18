/** 
 * Project Name:00-leetcode 
 * File Name:_003_无重复字符的最长子串.java 
 * Package Name:com.hzp.algorithm 
 * Date:2020年7月9日下午3:25:55 
 * Copyright (c) 2020, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp.algorithm;

import java.util.HashMap;
import java.util.Map;

/** 
 * ClassName:_003_无重复字符的最长子串 <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2020年7月9日 下午3:25:55 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class _0003_无重复字符的最长子串 {
	
	/*
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 * 
	 * 示例 1:
	 * 
	 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
	 * 
	 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
	 * 
	 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串
	 * 的长度，"pwke" 是一个子序列，不是子串。
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-
	 * characters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("abcabcbb->"+lengthOfLongestSubstring("abcabcbb"));
		System.out.println("bbbbb->"+lengthOfLongestSubstring("bbbbb"));
		System.out.println("pwwkew->"+lengthOfLongestSubstring("pwwkew"));

	}
	
	/*
	 * 这道题主要用到思路是：滑动窗口
	 * 
	 * 什么是滑动窗口？
	 * 
	 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了
	 * abca，这时候不满足要求。所以，我们要移动这个队列！
	 * 
	 * 如何移动？
	 * 
	 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
	 * 
	 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解
	 * 
	 * 时间复杂度：O(n)
	 */
	 public static int lengthOfLongestSubstring(String s) {
		 if(s.length()==0)return 0;
		 Map<Character, Integer>map =new HashMap<Character, Integer>();
		 int max=0;
		 int left=0;
		 for (int i = 0; i < s.length(); i++) {
			 //是否已经存在相同字符
			 if(map.containsKey(s.charAt(i))) {
				 //比较左指针与当前索引的位置，取大数
				 left=Math.max(left, map.get(s.charAt(i))+1);
			 }
			 //字符和索引存入map中
			 map.put(s.charAt(i),i);
			 //判断最大长度
			 max=Math.max(max, i-left+1);
			
		}
		 return max;
	  }
}
