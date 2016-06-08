package com.test.util;

public class TestAoper {

	public static void main(String[] args) {
		AopInterface e = new AopInterfaceImpl();
		AopInterface x = new AopProxyer(e).getModel();
		
		x.add(3, 5);
	}
}
