package p3;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {

		Long[] arr1 = new Long[] { 1l, 2l, 2l, 4l };
		Long[] arr2 = new Long[] { 1l, 3l, 9l, 9l, 27l, 81l };
		Long[] arr3 = new Long[] { 1l, 5l, 5l, 25l, 125l };

		Assert.assertTrue(Solution.countTriplets(Arrays.asList(arr1), 2) == 2);
		Assert.assertTrue(Solution.countTriplets(Arrays.asList(arr2), 3) == 6);
		Assert.assertTrue(Solution.countTriplets(Arrays.asList(arr3), 5) == 4);

	}

}
