package p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> map = new HashMap<>();

		for (String str : magazine) {
			Integer val = map.getOrDefault(str, 0) + 1;
			map.put(str, val);
		}

		for (String str : note) {
			if (!map.containsKey(str)) {
				System.out.println("No");
				return;
			} else {
				Integer val = map.get(str) - 1;
				if (val == -1) {
					System.out.println("No");
					return;
				}
				map.put(str, val);
			}
		}
		System.out.println("Yes");

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
