/** 
 * Project Name:00-leetcode 
 * File Name:_001_两数之和.java 
 * Package Name:com.hzp.algorithm 
 * Date:2020年7月9日下午2:39:04 
 * Copyright (c) 2020, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp.algorithm;

import java.util.HashMap;
import java.util.Map;

/** 
 * ClassName:_001_两数之和 <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2020年7月9日 下午2:39:04 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class _0001_两数之和 {
	
	/*
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的**数组下标**。
	 * 
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	 * 
	 *  
	 * 
	 * 示例:
	 * 
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target=9;
		int[] result = twoSum(nums,target);
		System.out.println(result[0]+"---"+result[1]);
	}
	
	/*
	 * 复杂度分析：
	 * 
	 * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1 ) 的时间。
	 * 
	 * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n个元素。
	 */
	 public static int[] twoSum(int[] nums, int target) {
		 Map<Integer, Integer> map=new HashMap<>();
		 for (int i = 0; i < nums.length; i++) {
			int otherNum=target-nums[i];
			if(map.containsKey(otherNum)) {
				return new int[] {map.get(otherNum),i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
