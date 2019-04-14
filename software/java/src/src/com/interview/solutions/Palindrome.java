package com.interview.solutions;

public class Palindrome {

	public static void main(String[] args) {
		String str = args[0];
		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();
		System.out.println("String: " + str + ", Reverse: " + reverse + ", isPallindrome: " + str.equals(reverse));
	}		
}
