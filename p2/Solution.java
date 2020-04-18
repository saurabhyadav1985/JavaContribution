/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example
, the list of all anagrammatic pairs is at positions

respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in

.

sherlockAndAnagrams has the following parameter(s):

    s: a string .

Input Format

The first line contains an integer
, the number of queries.
Each of the next lines contains a string

to analyze.

Constraints



String contains only lowercase letters

ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd

Sample Output 0

4
0


 */

package p2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		Map<String, Integer> map = new LinkedHashMap<>();
		int count = 0; 
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char[] keys = s.substring(i, j + 1).toCharArray();
				Arrays.sort(keys);
				String sortedKey = String.valueOf(keys);
				int val = map.getOrDefault(sortedKey, 0);
				count = count+val;
				map.put(sortedKey, ++val);
			}
		}
		System.out.println(map);
		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
