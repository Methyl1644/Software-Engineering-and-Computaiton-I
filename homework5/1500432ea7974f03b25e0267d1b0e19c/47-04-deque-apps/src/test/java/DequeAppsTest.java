import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class DequeAppsTest {

    private LinkedList<Integer> queueOf(Integer... vals) {
        return new LinkedList<>(Arrays.asList(vals));
    }

    private ArrayDeque<Integer> dequeOf(Integer... vals) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int v : vals) d.addLast(v);
        return d;
    }

    // --- isPalindrome ---

    @Test
    public void testIsPalindrome_简单回文() {
        assertTrue(DequeApps.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome_非回文() {
        assertFalse(DequeApps.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindrome_忽略大小写() {
        assertTrue(DequeApps.isPalindrome("Racecar"));
    }

    @Test
    public void testIsPalindrome_忽略空格和标点() {
        assertTrue(DequeApps.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testIsPalindrome_空字符串() {
        assertTrue(DequeApps.isPalindrome(""));
    }

    @Test
    public void testIsPalindrome_单字符() {
        assertTrue(DequeApps.isPalindrome("a"));
    }

    @Test
    public void testIsPalindrome_含数字() {
        assertTrue(DequeApps.isPalindrome("12321"));
    }

    // --- reverseFirstK ---

    @Test
    public void testReverseFirstK_反转前3个() {
        LinkedList<Integer> q = queueOf(1, 2, 3, 4, 5);
        DequeApps.reverseFirstK(q, 3);
        assertEquals(queueOf(3, 2, 1, 4, 5), q);
    }

    @Test
    public void testReverseFirstK_反转前2个() {
        LinkedList<Integer> q = queueOf(10, 20, 30);
        DequeApps.reverseFirstK(q, 2);
        assertEquals(queueOf(20, 10, 30), q);
    }

    @Test
    public void testReverseFirstK_反转全部() {
        LinkedList<Integer> q = queueOf(1, 2, 3);
        DequeApps.reverseFirstK(q, 3);
        assertEquals(queueOf(3, 2, 1), q);
    }

    @Test
    public void testReverseFirstK_反转1个() {
        LinkedList<Integer> q = queueOf(1, 2, 3);
        DequeApps.reverseFirstK(q, 1);
        assertEquals(queueOf(1, 2, 3), q);
    }

    // --- sortedInsert ---

    @Test
    public void testSortedInsert_插入中间() {
        ArrayDeque<Integer> d = dequeOf(1, 3, 5);
        DequeApps.sortedInsert(d, 4);
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, d.toArray(new Integer[0]));
    }

    @Test
    public void testSortedInsert_插入头部() {
        ArrayDeque<Integer> d = dequeOf(2, 4);
        DequeApps.sortedInsert(d, 1);
        assertArrayEquals(new Integer[]{1, 2, 4}, d.toArray(new Integer[0]));
    }

    @Test
    public void testSortedInsert_插入尾部() {
        ArrayDeque<Integer> d = dequeOf(2, 4);
        DequeApps.sortedInsert(d, 9);
        assertArrayEquals(new Integer[]{2, 4, 9}, d.toArray(new Integer[0]));
    }

    @Test
    public void testSortedInsert_空队列() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        DequeApps.sortedInsert(d, 5);
        assertArrayEquals(new Integer[]{5}, d.toArray(new Integer[0]));
    }

    @Test
    public void testSortedInsert_插入重复值() {
        ArrayDeque<Integer> d = dequeOf(1, 3, 5);
        DequeApps.sortedInsert(d, 3);
        assertArrayEquals(new Integer[]{1, 3, 3, 5}, d.toArray(new Integer[0]));
    }

    @Test
    public void testSortedInsert_单元素队列() {
        ArrayDeque<Integer> d = dequeOf(5);
        DequeApps.sortedInsert(d, 3);
        assertArrayEquals(new Integer[]{3, 5}, d.toArray(new Integer[0]));
    }
}
