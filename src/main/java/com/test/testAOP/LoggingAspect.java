package com.test.testAOP;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把此类sheng声明一个切面，放到IOC容器，在声明为切面
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 定义一个公用的切入点，表达式
	 * @param joinPoint
	 */
	@Pointcut("execution(public * *(..))")
	public void declareJoinPointExpression(){}
	
	//该方法为一个前置通知
//	@Before("execution(public * *(..))")
	@Order(1)
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begains with "+args);
	}
	
	//后置通知，不能获取执行结果
	@After("execution(public * *(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends with "+args);
	}
	
	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值
	 * @param joinPoint
	 * @param e
	 */
	@AfterReturning(value="execution(public * *(..))",returning = "result")
	public void afterResult(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" result with "+result);
	}
	
	//异常通知
	@AfterThrowing(value="execution(public * *(..))",throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" Exception with "+ex);
	}
	
	//环绕通知， 类似动态代理的全过程
//	@Around("execution(public * *(..))")
	public int aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		//执行目标方法
		try{
			//前置通知
			System.out.println("The method "+methodName + " begain with "+Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
		}catch(Throwable e){
			//异常通知
			System.out.println("The method occures exception "+e);
		}
		//后置通知
		System.out.println("end");
		
		System.out.println("round^");
		return 1000;
	}
}
