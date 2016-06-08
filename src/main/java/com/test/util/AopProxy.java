package com.test.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.ClassArrayEditor;

public class AopProxy {

	private AopInterface target;
	

	public AopProxy(AopInterface target) {
		this.target = target;
	}


	public AopInterface getLoggingModel(){
		AopInterface p ;
		
		ClassLoader loader = target.getClass().getClassLoader();
		
		Class[] interfaces = new Class[]{AopInterface.class};
		
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object p, Method method, Object[] args)
					throws Throwable {
				System.out.println("A");
				
				String methodName = method.getName();
				System.out.println(methodName+"   "+Arrays.asList(args));
				
				Object result  = method.invoke(target, args);

				System.out.println("end "+result);
				return 0;
			}
		};
		
		p = (AopInterface)Proxy.newProxyInstance(loader, interfaces, h);
		
		return p;
	}
	
}
