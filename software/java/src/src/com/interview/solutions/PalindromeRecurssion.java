package com.interview.solutions;

public class PalindromeRecurssion {

	public static void main(String[] args) {
		System.out.println(reverse(1, 0));
	}
	
	static int reverse(int number, int temp) {
		if(number == 0) {
			return temp;
		}
		temp = (temp*10) + number%10;
		
		return reverse(number/10, temp) ;
	}
}
