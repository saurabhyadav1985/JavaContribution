
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		assertThat(Solution.maxSubsetSum(new int[] { -2, 1, 3, -4, 5 })).isEqualTo(8);
		assertThat(Solution.maxSubsetSum(new int[] { 3, 7, 4, 6, 5 })).isEqualTo(13);
		assertThat(Solution.maxSubsetSum(new int[] { 3, 5, -7, 8, 10 })).isEqualTo(15);
	}
}
