/** 
 * Project Name:00-leetcode 
 * File Name:_002_两数相加.java 
 * Package Name:com.hzp.algorithm 
 * Date:2020年7月9日下午2:52:52 
 * Copyright (c) 2020, 952646089@qq.com All Rights Reserved. 
 * 
*/
package com.hzp.algorithm;

/**
 * ClassName:_002_两数相加 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月9日 下午2:52:52 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class _0002_两数相加 {
	/*
	 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	 * 
	 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	 * 
	 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 
	 * 示例：
	 * 
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next = new ListNode(4);

		ListNode resultListNode = addTwoNumbers(l1, l2);

		while (resultListNode != null) {
			System.out.print(resultListNode.val + "->");
			if (resultListNode != null)
				resultListNode = resultListNode.next;
		}
	}
	
	/*
	 * 复杂度分析
	 * 
	 * 时间复杂度：O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复max(m,n) 次。
	 * 
	 * 空间复杂度：O(max(m,n))， 新列表的长度最多为 max(m,n)+1
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 初始化返回链表的预先指针。该指针的下一个节点指向真正的头结点head
		ListNode pre = new ListNode(0);
		// 将当前结点初始化为返回链表的预先指针结点
		ListNode currNode = pre;
		// 将进位 carry初始化为 0
		int carry = 0;
		// 遍历列表 l1 和 l2 直至到达它们的尾端
		while (l1 != null || l2 != null) {
			// 将 x 设为结点 l1 的值。如果已经到达 l1 的末尾，则将其值设置为 0
			int x = (l1 != null) ? l1.val : 0;
			// 将 y 设为结点 l2 的值。如果已经到达 l2的末尾，则将其值设置为 0
			int y = (l2 != null) ? l2.val : 0;

			// 设定 sum
			int sum = x + y + carry;
			// 更新进位的值carry
			carry = sum / 10;
			sum = sum % 10;
			// 创建一个数值为 sum%10 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点
			currNode.next = new ListNode(sum);

			currNode = currNode.next;
			// 将 l1 和 l2 前进到下一个结点
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		// 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
		if (carry == 1) {
			currNode.next = new ListNode(carry);
		}

		// 返回链表的下一个结点
		return pre.next;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
