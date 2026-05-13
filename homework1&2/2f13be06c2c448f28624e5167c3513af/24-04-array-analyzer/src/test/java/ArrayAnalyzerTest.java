import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * 明测试用例 — ArrayAnalyzer
 */
public class ArrayAnalyzerTest {

    // -----------------------------------------------------------------------
    // countAboveAverage()
    // -----------------------------------------------------------------------

    @Test
    public void testCountAboveAvg_典型() {
        // avg = (1+2+3+4+5)/5 = 3.0，4 和 5 大于 3.0
        assertEquals(2, ArrayAnalyzer.countAboveAverage(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testCountAboveAvg_全相同() {
        // avg = 5.0，无元素严格大于 5.0
        assertEquals(0, ArrayAnalyzer.countAboveAverage(new int[]{5, 5, 5}));
    }

    @Test
    public void testCountAboveAvg_空数组() {
        assertEquals(0, ArrayAnalyzer.countAboveAverage(new int[]{}));
    }

    @Test
    public void testCountAboveAvg_单元素() {
        // avg = 7.0，无元素严格大于 7.0
        assertEquals(0, ArrayAnalyzer.countAboveAverage(new int[]{7}));
    }

    // -----------------------------------------------------------------------
    // twoSum()
    // -----------------------------------------------------------------------

    @Test
    public void testTwoSum_存在() {
        assertTrue(ArrayAnalyzer.twoSum(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    public void testTwoSum_不存在() {
        assertFalse(ArrayAnalyzer.twoSum(new int[]{1, 2, 3}, 7));
    }

    @Test
    public void testTwoSum_重复元素配对() {
        assertTrue(ArrayAnalyzer.twoSum(new int[]{1, 1}, 2));
    }

    @Test
    public void testTwoSum_单元素不可配对() {
        assertFalse(ArrayAnalyzer.twoSum(new int[]{5}, 5));
    }

    // -----------------------------------------------------------------------
    // countRuns()
    // -----------------------------------------------------------------------

    @Test
    public void testCountRuns_混合段() {
        assertEquals(3, ArrayAnalyzer.countRuns(new int[]{1, 1, 2, 2, 3}));
    }

    @Test
    public void testCountRuns_全不同() {
        assertEquals(3, ArrayAnalyzer.countRuns(new int[]{1, 2, 3}));
    }

    @Test
    public void testCountRuns_全相同() {
        assertEquals(1, ArrayAnalyzer.countRuns(new int[]{4, 4, 4}));
    }

    @Test
    public void testCountRuns_空数组() {
        assertEquals(0, ArrayAnalyzer.countRuns(new int[]{}));
    }

    @Test
    public void testCountRuns_单元素() {
        assertEquals(1, ArrayAnalyzer.countRuns(new int[]{7}));
    }
}
