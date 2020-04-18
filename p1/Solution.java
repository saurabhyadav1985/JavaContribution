package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the twoStrings function below.
	static String twoStrings1(String s1, String s2) {
		for (char c1 : s1.toCharArray()) {
			if (s2.contains(Character.toString(c1))) {
				return "YES";
			}
		}
		return "NO";
	}

	static String twoStrings(String s1, String s2) {
		System.out.println(s1);
		System.out.println(s2);
		
		List<Character> charList1 = new ArrayList<>(26);
		List<Character> charList2 = new ArrayList<>(26);
		
		for(int i =0; i < s1.length(); i++ ) {
			if (!charList1.contains(s1.charAt(i))) {
				charList1.add(s1.charAt(i));
			}
		}
		
		for(int i =0; i < s2.length(); i++ ) {
			if (!charList2.contains(s2.charAt(i))) {
				charList2.add(s2.charAt(i));
			}
		}
		
		for (Character ch : charList1) {
			if(charList2.contains(ch)) {
				return "YES";
			}
		}
		
		return "NO";
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
