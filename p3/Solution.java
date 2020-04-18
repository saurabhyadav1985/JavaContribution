package p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		long count = 0;

		Map<Long, Long> leftMap = new HashMap<>();
		Map<Long, Long> rightMap = new HashMap<>();

		for (long num : arr) {
			if (!rightMap.containsKey(num)) {
				rightMap.put(num, 1L);
			} else {
				Long occ = rightMap.get(num);
				rightMap.put(num, occ + 1L);
			}
		}

		for (Long num : arr) {
			long lhs = 0, leftCount = 0, rightCount = 0;
			long rhs = num * r;
			if (num % r == 0) {
				lhs = num / r;
			}

			long occurence = rightMap.get(num);
			rightMap.put(num, occurence - 1);

			if (rightMap.containsKey(rhs)) {
				rightCount = rightMap.get(rhs);
			}
			if (leftMap.containsKey(lhs)) {
				leftCount = leftMap.get(lhs);
			}

			count += leftCount * rightCount;

			if (!leftMap.containsKey(num)) {
				leftMap.put(num, 1L);
			} else {
				Long occ = leftMap.get(num);
				leftMap.put(num, occ + 1L);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Long> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr.add(arrItem);
		}

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
