
/*
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset. 
 * https://www.hackerrank.com/challenges/max-array-sum
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {

		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("Input : " + arrList);	
		
		int exc = 0;
		int inc = 0;
		int maxSum =0;
		
		for(int index : arr) {
			inc = exc + index;
			if (max(exc, inc) > maxSum) {
				maxSum = max(exc, inc);
			}
			
			exc = inc;
		}
		return maxSum;
	}
	
	

	private static int max(int exc, int inc) {
		if(exc > inc) {
			return exc;
		}
		else {
			return inc;
		}
	}



	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = maxSubsetSum(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
