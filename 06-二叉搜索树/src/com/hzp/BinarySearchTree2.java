package com.hzp;

import java.util.Comparator;

import com.hzp.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("unused")
public class BinarySearchTree2<E> implements BinaryTreeInfo{
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {

	}

	public void add(E element) {
		elementNotNullCheck(element);

		// 添加第一个节点 根节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}

		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {// 相等
				return;
			}
		}

		// 看看插入到父节点的哪个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;

	}

	public void remove(E element) {

	}

	public boolean contains(E element) {
		return false;
	}

	/**
	 * 检查元素是否为空null 为空就抛出异常
	 * 
	 * @param element
	 */
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

	/**
	 * 
	 * @Title: compare  
	 * @Description: 比较大小函数
	 * @author codehan  
	 * @date 2019年12月18日 上午12:02:41 
	 * @param @param e1
	 * @param @param e2
	 * @param @return
	 * @return int =0:e1=e2; >0:e1>e2; <0:e1<e2
	 * @throws
	 */
	private int compare(E e1, E e2) {
		if(comparator!=null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}

	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}

}
