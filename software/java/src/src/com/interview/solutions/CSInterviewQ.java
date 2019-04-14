package com.interview.solutions;

public class CSInterviewQ {

	
	public static void main(String[] args) {
		int i = new CSInterviewQ().compute();
		System.out.println("Outpupt: " + i);
	}

	private int compute() {
		
		try {
			return 1;
		}
		catch(Exception e) {
			return 2;
		}
		finally {
			return 3;
		}
		
	}
	
	
}
