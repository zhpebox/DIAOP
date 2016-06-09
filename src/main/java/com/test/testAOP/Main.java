package com.test.testAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//1. 创建Spring的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aspactj.xml");
		
		//2. 从IOC容器中获取bean的实例
		IAlgor a = (IAlgor) ctx.getBean("algorImpl");
		
		//3. 使用bean
		int result = a.add(4, 5);
		System.out.println(result);
		
		float result1 = a.sub(6, 5);
		System.out.println(result1);
	}
}
