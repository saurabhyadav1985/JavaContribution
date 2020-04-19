
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

		nonAdjacencyMap.entrySet().stream().map(entry -> prepareSubSets(entry, nonAdjacencyMap, adjancency, arr.length))
				.forEach(i->System.out.println(" "));

		System.out.println(solutions);
		
		for(Set<Integer> solution : solutions) {
			int sum =solution.stream().mapToInt(x-> x).sum();
			if(sum > maxSum) maxSum =sum;
		}

		return maxSum;
	}

	static List<Integer> alreadyProcess  = new ArrayList<Integer>();
	static List<Set<Integer>> solutions  = new ArrayList<>();
	static Set<Integer> prepareSubSets(Entry<Integer, List<Integer>> entry, Map<Integer, List<Integer>> nonAdjacencyMap,
			Map<Integer, List<Integer>> adjancency, int length) {
		Set<Integer> subset = new HashSet<Integer>();
		subset.add(entry.getKey());
		Set<Integer> dontAdd = new HashSet<Integer>();
		dontAdd.addAll(alreadyProcess);
		dontAdd.add(entry.getKey());
		dontAdd.addAll(adjancency.get(entry.getKey()));
		List<Integer> nonAdjacent = entry.getValue();
		for (Integer int1 : nonAdjacent) {

			if (!subset.contains(int1) && !dontAdd.contains(int1)) {

				dontAdd.add(int1);
				dontAdd.addAll(adjancency.get(int1));
				subset.add(int1);
				solutions.add(new HashSet<>(subset));
				for (Integer int2 : nonAdjacencyMap.get(int1)) {
					dontAdd.addAll(adjancency.get(int2));
					if (!subset.contains(int2) && !dontAdd.contains(int2)) {
						subset.add(int2);
						solutions.add(new HashSet<>(subset));
						if (subset.size() + dontAdd.size() == length) {
							for (Integer int3 : nonAdjacencyMap.get(int2)) {
								dontAdd.addAll(adjancency.get(int3));
								if (!subset.contains(int3) && !dontAdd.contains(int3)) {
									subset.add(int3);
									solutions.add(new HashSet<>(subset));
									break;
								}

							}
						}
					}
				}

			}
			if(subset.size() >1)
			System.out.println(subset);

			dontAdd.clear();
			subset.clear();
			dontAdd.add(entry.getKey());
			dontAdd.addAll(alreadyProcess);
			subset.add(entry.getKey());
			dontAdd.addAll(adjancency.get(entry.getKey()));
		}
		alreadyProcess.add(entry.getKey());
		return null;
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
