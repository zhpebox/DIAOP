package org.test.testTDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 泛型依赖注入
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.add();
	}
}
