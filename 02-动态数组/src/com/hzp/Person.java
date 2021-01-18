/** 
 * Project Name:02-动态数组 
 * File Name:Person.java 
 * Package Name:com.hzp 
 * Date:2019年12月29日下午10:17:35 
 * Copyright (c) 2019, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp;

/** 
 * ClassName:Person <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年12月29日 下午10:17:35 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class Person {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	/**
	 * Title: finalize
	 * Description: 对象释放时候会调用
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		
		System.out.println("Person - finalize");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Person) {
			Person person  = (Person) obj;
			return this.age == person.age;
		}
		return false;
	}
}
