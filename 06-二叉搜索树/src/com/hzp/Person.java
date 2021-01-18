package com.hzp;

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(int age) {
		this.age = age;
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	/**
	 * 年龄age大的大
	 * Title: compareTo
	 * Description: TODO 这种方法比较逻辑会固定下来，不利于多种比较逻辑
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person e) {
//		if (age > e.age) return 1;
//		if (age < e.age) return -1;
//		return 0;
		return age - e.age;
	}
	
	@Override
	public String toString() {
		return age + "_" + name;
	}
	
}
