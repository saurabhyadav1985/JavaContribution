package com.practice.solutions;

interface FuncItf{
	abstract void print(String str);
}

public class LambdaExample {

	public static void main(String[] args) {
		FuncItf funcItf = (str) -> System.out.println("Printing " + str);
		funcItf.print("Saurabh");
	}
}
