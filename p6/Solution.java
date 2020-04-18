package p6;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

	// Complete the freqQuery function below.

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		List<Integer> result = new ArrayList<>();
		int n = Integer.parseInt(in.readLine());
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		HashMap<Long, Long> freq = new HashMap<Long, Long>();

		for (int i = 0; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(s.nextToken());
			final long b = Long.parseLong(s.nextToken());
			switch (a) {
			case 1:
				freq.computeIfPresent(map.get(b), (k, v) -> v == 1 ? freq.remove(map.get(b)) : v - 1);
				map.compute(b, (k, v) -> v == null ? 1 : v + 1);
				freq.compute(map.get(b), (k, v) -> v == null ? 1 : v + 1);
				break;
			case 2:
				freq.computeIfPresent(map.get(b), (k, v) -> v == 1 ? freq.remove(map.get(b)) : v - 1);
				map.computeIfPresent(b, (k, v) -> v == 1 ? map.remove(b) : v - 1);
				freq.compute(map.get(b), (k, v) -> v == null ? 1 : v + 1);
				break;
			case 3:
				result.add(freq.containsKey(b) ? 1 : 0);
				break;
			}
		}
		out.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		in.close();
		out.close();
	}
}
