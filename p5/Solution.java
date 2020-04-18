package p5;

import java.util.Scanner;

public class Solution {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int count = 0;
		int midOfThree = Integer.MAX_VALUE;
		int maxOfThree = Integer.MAX_VALUE;
		int minOfThree = Integer.MAX_VALUE;

		for (int index = q.length - 1; index >= 0; index--) {
			if (q[index] - index > 3) {
				System.out.println("Too chaotic");
				return;
			} else {
				// means current value has passed at least 3 values -> wrong
				if (q[index] > maxOfThree) {
					System.out.println("Too chaotic");
					return;
				} else if (q[index] > midOfThree) { // means -> current value has bribed 2 ppl
					count = count + 2;
				} else if (q[index] > minOfThree) { // means-> current value has bribed 1 person.
					count = count + 1;
				}

				// Now adjust minThree values comparing, taking the current vlaue to account
				if (q[index] < minOfThree) {
					maxOfThree = midOfThree;
					midOfThree = minOfThree;
					minOfThree = q[index];
				} else if (q[index] < midOfThree) {
					maxOfThree = midOfThree;
					midOfThree = q[index];
				} else if (q[index] < maxOfThree) {
					maxOfThree = q[index];
				}
			}
		}
		System.out.println(count);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
