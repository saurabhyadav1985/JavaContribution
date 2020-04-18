import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

	/*
	 * Complete the 'zeros' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts INTEGER n
	 * as parameter.
	 */

	public static int zeros(int n) {
		int fact = factorial(n);
		int countOfZeroes = 0;
		while (fact % 10 == 0) {
			countOfZeroes++;
			fact = fact / 10;
		}
		
		return countOfZeroes;
	}

	private static int factorial(int n) {

		if (n <= 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}

}

public class Solution1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.zeros(n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
