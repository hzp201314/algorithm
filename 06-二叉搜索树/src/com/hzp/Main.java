package com.hzp;

import java.util.Comparator;

import com.hzp.BinarySearchTree.Visitor;
import com.hzp.file.Files;
import com.hzp.printer.BinaryTreeInfo;
import com.hzp.printer.BinaryTrees;

/**
 * 
 * @ClassName: Main 
 * @Description: TODO
 * @author codehan
 * @date 2019年12月17日 下午11:47:21 
 *
 */
@SuppressWarnings("unused")
public class Main {

	/**
	 * 
	 * @ClassName: PersonComparator 
	 * @Description: 比较器 
	 * @author codehan
	 * @date 2019年12月17日 下午11:41:50 
	 *
	 */
	private static class PersonComparator implements Comparator<Person> {
		
		/**
		 * 
		 * Title: compare
		 * Description: 年龄大的比较大
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}

	/**
	 * 
	 * @ClassName: PersonComparator2 
	 * @Description: 比较器
	 * @author codehan
	 * @date 2019年12月17日 下午11:48:01 
	 *
	 */
	private static class PersonComparator2 implements Comparator<Person> {
		/**
		 * 
		 * Title: compare
		 * Description:年龄小的比较大
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}

	/**
	 * 
	 * @Title: test1  
	 * @Description: 构建一个新的二叉搜索树，并打印  
	 * @author codehan  
	 * @date 2019年12月18日 上午12:18:28 
	 * @param 
	 * @return void
	 * @throws
	 */
	static void test1() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}

		BinaryTrees.println(bst);
	}

	/**
	 * 
	 * @Title: test2  
	 * @Description: 构建一个新的二叉搜索树，并打印  ,
	 * 通过强制实现  Comparable接口的compareTo方法比较大小之后构造二叉搜索树；
	 * 通过实现匿名内部类的Comparator的compare方法比较大小之后构造二叉搜索树。
	 * @author codehan  
	 * @date 2019年12月18日 上午12:19:15 
	 * @param 
	 * @return void
	 * @throws
	 */
	static void test2() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		//年龄小的在左边
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}

		BinaryTrees.println(bst1);

		//年龄小的在右边
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}
		BinaryTrees.println(bst2);
	}

	static void test3() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 40; i++) {
			bst.add((int) (Math.random() * 100));
		}

		String str = BinaryTrees.printString(bst);
		str += "\n";
		Files.writeToFile("F:/1.txt", str, true);

		// BinaryTrees.println(bst);
	}

	static void test4() {
		BinaryTrees.println(new BinaryTreeInfo() {

			@Override
			public Object string(Object node) {
				return node.toString() + "_";
			}

			@Override
			public Object root() {
				return "A";
			}

			@Override
			public Object right(Object node) {
				if (node.equals("A"))
					return "C";
				if (node.equals("C"))
					return "E";
				return null;
			}

			@Override
			public Object left(Object node) {
				if (node.equals("A"))
					return "B";
				if (node.equals("C"))
					return "D";
				return null;
			}
		});

		// test3();

		/*
		 * Java鐨勫尶鍚嶇被锛岀被浼间簬iOS涓殑Block銆丣S涓殑闂寘锛坒unction锛�
		 */

//		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return 0;
//			}
//		});
//		bst1.add(new Person(12));
//		bst1.add(new Person(15));
//		
//		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
//

//		BinarySearchTree<Car> bst4 = new BinarySearchTree<>(new Car);
//		
//		
//		java.util.Comparator<Integer> iComparator;
	}

	static void test5() {
		BinarySearchTree<Person> bst = new BinarySearchTree<>();
		bst.add(new Person(10, "jack"));
		bst.add(new Person(12, "rose"));
		bst.add(new Person(6, "jim"));

		bst.add(new Person(10, "michael"));

		BinaryTrees.println(bst);
	}

	static void test6() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}

//		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		for (int i = 0; i < 10; i++) {
//			bst.add((int)(Math.random() * 100));
//		}
		BinaryTrees.println(bst);
		System.out.println(bst.isComplete());

		// bst.levelOrderTraversal();

		/*
		 * 7 4 9 2 5
		 */

//		bst.levelOrder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + element + "_ ");
//			}
//		});

//		bst.inorder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + (element + 3) + "_ ");
//			}
//		});

		// System.out.println(bst.height());
	}

	static void test7() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}

		BinaryTrees.println(bst);

		bst.remove(7);

		BinaryTrees.println(bst);
	}

	static void test8() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		System.out.println(bst.isComplete());
	}

	static void test9() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 1 };

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);

		bst.preorder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 2 ? true : false;
			}
		});
		System.out.println();

		bst.inorder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		System.out.println();

		bst.postorder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		System.out.println();

		bst.levelOrder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 9 ? true : false;
			}
		});
		System.out.println();
	}

	public static void main(String[] args) {
		test2();
//		demo1();
//		demo2();
	}

	
	private static void demo2() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };
		BinarySearchTree2<Person> bst1 = new BinarySearchTree2<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}

		BinaryTrees.println(bst1);

//		BinarySearchTree2<Person> bst2 = new BinarySearchTree2<>(new Comparator<Person>() {
//			public int compare(Person o1, Person o2) {
//				return o2.getAge() - o1.getAge();
//			}
//		});
//		for (int i = 0; i < data.length; i++) {
//			bst2.add(new Person(data[i]));
//		}
//		BinaryTrees.println(bst2);
		
	}

	/**
	 * 
	 */
	private static void demo1() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1 };
		BinarySearchTree2<Integer> bst = new BinarySearchTree2<Integer>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
	}
}
