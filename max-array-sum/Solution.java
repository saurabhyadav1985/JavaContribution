
/*
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset. 
 * https://www.hackerrank.com/challenges/max-array-sum
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {

		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("Input : " + arrList);	
		
		int maxSum = 0;
		Map<Integer, List<Integer>> adjancency = new HashMap<>();

		for (int index = 0; index < arr.length; index++) {
			List<Integer> list = new ArrayList<Integer>();
			if (index != 0) {
				list.add(arr[index - 1]);
			}
			if (index != arr.length - 1) {
				list.add(arr[index + 1]);
			}
			adjancency.put(arr[index], list);
		}

		System.out.println("Adjacency map : " + adjancency);
		
		Map<Integer, List<Integer>> nonAdjacencyMap = new HashMap<Integer, List<Integer>>();
		adjancency.entrySet().stream().forEach(entry -> {
			List<Integer> cloned = new ArrayList<>(arrList);
			cloned.remove(entry.getKey());
			cloned.removeAll(entry.getValue());
			nonAdjacencyMap.put(entry.getKey(), cloned);
		});
		System.out.println("Non Adjacency data is below: " + nonAdjacencyMap);		
		
		return maxSum;
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
