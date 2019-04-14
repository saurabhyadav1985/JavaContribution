package com.practice.solutions;

public class Solution {

	public static void main(String[] args) {

		for (int i = 1; i<=100; i++) {
			System.out.println(func(i));
		}
	}

	private static String func(int i) {
		
		if (i%15 ==0) return "FizzBuzz";
		if (i%5 == 0) return "Fizz";
		if (i%5 == 0) return "Buzz";
		return "" + i;
	}
}
