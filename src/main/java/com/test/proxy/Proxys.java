package com.test.proxy;


import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class Proxys {

	private ICompute targetModel;
	
	public Proxys(ICompute model){
		targetModel = model;
	}

	public ICompute getProModel(){
		ICompute p;
		
		ClassLoader loader = targetModel.getClass().getClassLoader();
		
		Class[] methods = new Class[]{Compute.class};
		
		InvocationHandler handler = new InvocationHandler() {
			

			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("AAAAAAAAAAAAAAAAA");
				return 100;
			}
		};
		
		ICompute s = (ICompute)Proxy.newProxyInstance(loader, methods, handler);
		return s; 
		
	}
	
	
}
