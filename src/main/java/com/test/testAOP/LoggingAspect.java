package com.test.testAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把此类sheng声明一个切面，放到IOC容器，在声明为切面
@Aspect
@Component
public class LoggingAspect {
	
	//该方法为一个前置通知
	@Before("execution(public * *(..))")
	public void beforeMethod(){
		System.out.println("Thie method begain");
	}
}
