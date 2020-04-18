package p2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		Assert.assertTrue(Solution.sherlockAndAnagrams("abba") == 4);
		Assert.assertTrue(Solution.sherlockAndAnagrams("kkkk") == 10);
		Assert.assertTrue(Solution.sherlockAndAnagrams("ifailuhkqq") == 3);

	}

}
