package com.tg.hello;

public class HelloDao {

	public int addTwoNumber(int a, int b) {

		return a + b;
	}

	public int subTwoNumber(int a, int b) {
		
		int result = a - b;
		
		return result;      //아무것도 구현하지않고, 기본형식으로 만든것 TDD 방식
	}
}
