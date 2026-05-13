import java.util.LinkedList;

/**
 * 栈应用 — 使用 LinkedList 作为栈的练习。
 *
 * LinkedList 提供了 push/pop/peek 方法，可直接当作栈使用。
 * push 将元素压入栈顶（链表头部），pop 弹出栈顶元素。
 */
public class StackOps {

    // ==================== reverseString ====================

    /**
     * 使用栈反转字符串。
     *
     * 思路：将字符逐个 push 入栈，再逐个 pop 出来拼接。
     *
     * 示例：reverseString("hello") → "olleh"
     *       reverseString("a")     → "a"
     *       reverseString("")      → ""
     *
     * @param str 输入字符串
     * @return 反转后的字符串
     */
    public static String reverseString(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        // 将每个字符压入栈
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i)); // 填空1：将 ' ' 替换为正确的字符
        }
        // 逐个弹出拼接
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()); // 填空2：将 ' ' 替换为从栈中弹出元素的表达式
        }
        return sb.toString();
    }

    // ==================== isBalanced ====================

    /**
     * 判断字符串中的括号是否匹配。
     * 支持三种括号：()、[]、{}。
     * 忽略非括号字符。
     *
     * 思路：遇到左括号压栈，遇到右括号时检查栈顶是否为对应的左括号。
     *
     * 示例：isBalanced("([])")     → true
     *       isBalanced("([)]")     → false
     *       isBalanced("{{}}")      → true
     *       isBalanced("hello")    → true（无括号视为匹配）
     *       isBalanced("(")        → false
     *
     * @param expr 输入字符串
     * @return 括号是否完全匹配
     */
    public static boolean isBalanced(String expr) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // 填空3：将 ' ' 替换为应该压入栈的字符
            } else if (c == ')' || c == ']' || c == '}') {
                // 找到对应的左括号
                char match;
                if (c == ')') match = '(';
                else if (c == ']') match = '[';
                else match = '{';
                // 检查栈是否为空，或栈顶是否匹配
                if(stack.isEmpty() || (stack.pop() != match)/* 填空4：替换 false 为"栈为空 或 弹出的栈顶不等于 match"的条件 */) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // ==================== decimalToBinary ====================

    /**
     * 将非负整数转为二进制字符串表示。
     *
     * 思路：反复对 n 除以 2，将余数压入栈，最后逐个弹出拼接。
     * 特殊情况：n == 0 时直接返回 "0"。
     *
     * 示例：decimalToBinary(10)  → "1010"
     *       decimalToBinary(0)   → "0"
     *       decimalToBinary(1)   → "1"
     *       decimalToBinary(255) → "11111111"
     *
     * @param n 非负整数
     * @return 二进制字符串
     */
    public static String decimalToBinary(int n) {
        if (n == 0) return "0";

        LinkedList<Integer> stack = new LinkedList<>();
        while (n > 0) {
            stack.push(n % 2); // 填空5：将 0 替换为 n 除以 2 的余数
            n = n / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()); // 填空6：将 0 替换为从栈中弹出元素的表达式
        }
        return sb.toString();
    }

    // ==================== main ====================

    public static void main(String[] args) {
        System.out.println("reverseString(\"hello\") = " + reverseString("hello"));
        System.out.println("isBalanced(\"([])\") = " + isBalanced("([])"));
        System.out.println("isBalanced(\"([)]\") = " + isBalanced("([)]"));
        System.out.println("decimalToBinary(10) = " + decimalToBinary(10));
        System.out.println("decimalToBinary(255) = " + decimalToBinary(255));
    }
}
