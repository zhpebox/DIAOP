package com.test.testAOP;

import org.springframework.stereotype.Component;

@Component
public class AlgorImpl implements IAlgor {

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public float sub(float i, float j) {
		return i - j;
	}

}
