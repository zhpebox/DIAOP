package com.test.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopProxyer {

	AopInterface target;
	
	public AopProxyer(AopInterface temp){
		this.target = temp;
	}
	
	public AopInterface getModel(){
		AopInterface pro;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象的类型，即其中的方法
		Class[] interfaces = new Class[]{AopInterface.class};
		
		//当调用代理对象其中的方法是，执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("调用了方法");
				
				Object result  = method.invoke(target, args);
				
				System.out.println(result);
				return result;
			}
		};
		
		AopInterface s = (AopInterface)Proxy.newProxyInstance(loader, interfaces, h);
		
		return s;
	}
}
