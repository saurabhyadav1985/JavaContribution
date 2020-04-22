import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		assertThat(Solution.abbreviation("daBcd", "ABC")).isEqualTo("YES");
	}

}
