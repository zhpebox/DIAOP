package com.test.util;

public class TestAop {
	
	public static void main(String[] args) {
		AopInterface a = new AopInterfaceImpl();
		AopInterface b = new AopProxy(a).getLoggingModel();
		
		int result = b.add(3, 4);
	}
}
