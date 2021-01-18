/** 
 * Project Name:01-复杂度 
 * File Name:TimeTools.java 
 * Package Name:com.hzp 
 * Date:2019年12月29日下午7:39:14 
 * Copyright (c) 2019, 952646089@qq.com All Rights Reserved. 
 * 
*/ 
package com.hzp;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * ClassName:TimeTools <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年12月29日 下午7:39:14 <br/> 
 * @author   Administrator 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class TimeTools {
	private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public interface Task {
		void execute();
	}
	
	public static void test(String title, Task task) {
		if (task == null) return;
		title = (title == null) ? "" : ("【" + title + "】");
		System.out.println(title);
		System.out.println("开始：" + fmt.format(new Date()));
		long begin = System.currentTimeMillis();
		task.execute();
		long end = System.currentTimeMillis();
		System.out.println("结束：" + fmt.format(new Date()));
		double delta = (end - begin) / 1000.0;
		System.out.println("耗时：" + delta + "秒");
		System.out.println("-------------------------------------");
	}
}
