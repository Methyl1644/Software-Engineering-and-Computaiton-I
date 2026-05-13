import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 明测试用例 — SequenceAnalyzer
 */
public class SequenceAnalyzerTest {

    // -----------------------------------------------------------------------
    // fibonacci()
    // -----------------------------------------------------------------------

    @Test
    public void testFib_零() {
        assertEquals(0, SequenceAnalyzer.fibonacci(0));
    }

    @Test
    public void testFib_一() {
        assertEquals(1, SequenceAnalyzer.fibonacci(1));
    }

    @Test
    public void testFib_五() {
        assertEquals(5, SequenceAnalyzer.fibonacci(5));
    }

    @Test
    public void testFib_十() {
        assertEquals(55, SequenceAnalyzer.fibonacci(10));
    }

    // -----------------------------------------------------------------------
    // sumPrimes()
    // -----------------------------------------------------------------------

    @Test
    public void testSumPrimes_10() {
        // 2+3+5+7 = 17
        assertEquals(17, SequenceAnalyzer.sumPrimes(10));
    }

    @Test
    public void testSumPrimes_仅2() {
        assertEquals(2, SequenceAnalyzer.sumPrimes(2));
    }

    @Test
    public void testSumPrimes_上界小于2() {
        assertEquals(0, SequenceAnalyzer.sumPrimes(1));
    }

    // -----------------------------------------------------------------------
    // longestRun()
    // -----------------------------------------------------------------------

    @Test
    public void testLongestRun_中间最长() {
        assertEquals(3, SequenceAnalyzer.longestRun(new int[]{1, 1, 2, 2, 2, 1}));
    }

    @Test
    public void testLongestRun_无连续() {
        assertEquals(1, SequenceAnalyzer.longestRun(new int[]{1, 2, 3}));
    }

    @Test
    public void testLongestRun_全相同() {
        assertEquals(4, SequenceAnalyzer.longestRun(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void testLongestRun_空数组() {
        assertEquals(0, SequenceAnalyzer.longestRun(new int[]{}));
    }
}
