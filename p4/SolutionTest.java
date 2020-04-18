package p4;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {

		Solution.checkMagazine("two times three is not four".split(" ")
			,"two times two is four".split(" "));

		
	}

}
