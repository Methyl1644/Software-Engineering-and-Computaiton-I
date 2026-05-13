import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 公开测试用例 — StackOps
 */
public class StackOpsTest {

    // --- reverseString ---

    @Test
    public void testReverseString_普通字符串() {
        assertEquals("olleh", StackOps.reverseString("hello"));
    }

    @Test
    public void testReverseString_单字符() {
        assertEquals("a", StackOps.reverseString("a"));
    }

    @Test
    public void testReverseString_空字符串() {
        assertEquals("", StackOps.reverseString(""));
    }

    @Test
    public void testReverseString_回文() {
        assertEquals("abcba", StackOps.reverseString("abcba"));
    }

    @Test
    public void testReverseString_含空格() {
        assertEquals("dlrow olleh", StackOps.reverseString("hello world"));
    }

    // --- isBalanced ---

    @Test
    public void testIsBalanced_简单匹配() {
        assertTrue(StackOps.isBalanced("()"));
    }

    @Test
    public void testIsBalanced_嵌套匹配() {
        assertTrue(StackOps.isBalanced("([])"));
    }

    @Test
    public void testIsBalanced_多种括号() {
        assertTrue(StackOps.isBalanced("{[()]}"));
    }

    @Test
    public void testIsBalanced_交叉不匹配() {
        assertFalse(StackOps.isBalanced("([)]"));
    }

    @Test
    public void testIsBalanced_缺少右括号() {
        assertFalse(StackOps.isBalanced("(("));
    }

    @Test
    public void testIsBalanced_缺少左括号() {
        assertFalse(StackOps.isBalanced(")"));
    }

    @Test
    public void testIsBalanced_无括号() {
        assertTrue(StackOps.isBalanced("hello"));
    }

    // --- decimalToBinary ---

    @Test
    public void testDecimalToBinary_零() {
        assertEquals("0", StackOps.decimalToBinary(0));
    }

    @Test
    public void testDecimalToBinary_一() {
        assertEquals("1", StackOps.decimalToBinary(1));
    }

    @Test
    public void testDecimalToBinary_十() {
        assertEquals("1010", StackOps.decimalToBinary(10));
    }

    @Test
    public void testDecimalToBinary_二的幂() {
        assertEquals("10000", StackOps.decimalToBinary(16));
    }
}
