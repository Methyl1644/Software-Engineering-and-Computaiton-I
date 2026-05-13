import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 双端队列应用 — 使用 ArrayDeque/LinkedList 作为双端队列的练习。
 *
 * Deque（Double-Ended Queue）支持从两端添加和删除元素。
 * ArrayDeque 提供了 addFirst/addLast/pollFirst/pollLast/peekFirst/peekLast 等方法。
 * 它既可以当栈用（push/pop），也可以当队列用（offer/poll）。
 */
public class DequeApps {

    // ==================== isPalindrome ====================

    /**
     * 使用双端队列判断字符串是否为回文。
     * 忽略大小写，只考虑字母和数字字符。
     *
     * 思路：将有效字符（转小写后）加入双端队列，
     * 然后从两端同时取出字符比较，若全部相等则为回文。
     *
     * 示例：isPalindrome("racecar")          → true
     *       isPalindrome("A man a plan a canal Panama")  → true
     *       isPalindrome("hello")             → false
     *       isPalindrome("")                  → true
     *
     * @param str 输入字符串
     * @return 是否为回文
     */
    public static boolean isPalindrome(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) list.add(c);
            else if (Character.isUpperCase(c)) list.add(Character.toLowerCase(c));
            else if (Character.isDigit(c)) list.add(c);
        }

        for (int i = 0; i < list.size();i++){
            if (list.get(i) != list.get(list.size() - 1 - i)) return false;
        }
        return true;
    }

    // ==================== reverseFirstK ====================

    /**
     * 反转队列的前 k 个元素，其余元素顺序不变。
     * 会修改原队列。
     *
     * 思路：
     * 1. 将前 k 个元素依次从队首取出，压入临时栈
     * 2. 将栈中元素依次弹出，放回队尾
     * 3. 将队列中剩余的 (size - k) 个元素依次从队首移到队尾
     *
     * 示例：reverseFirstK([1,2,3,4,5], 3) → 队列变为 [3,2,1,4,5]
     *       reverseFirstK([10,20,30], 2)   → 队列变为 [20,10,30]
     *
     * @param queue 目标队列
     * @param k     要反转的前 k 个元素
     */
    public static void reverseFirstK(LinkedList<Integer> queue, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // // 步骤1：将前 k 个元素取出压入栈
        for (int i = 0; i < k; i++) {
            stack.push(queue.removeFirst()); // 填空4：将 0 替换为从队首取出元素的表达式
        }
        // // 步骤2：将栈中元素弹出放回队尾（顺序已反转）
        while (!stack.isEmpty()) {
            queue.offer(stack.poll()); // 填空5：将 0 替换为从栈中弹出元素的表达式
        }
        // // 步骤3：将剩余的 (size - k) 个元素从队首移到队尾
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.offer(queue.removeFirst()); // 填空6：将 0 替换为从队首取出并放到队尾的表达式
        }
    }

    // ==================== sortedInsert ====================

    /**
     * 向已按升序排列的双端队列中插入一个新值，保持有序。
     * 队首为最小值，队尾为最大值。
     *
     * 思路：从队尾开始，将所有大于 value 的元素暂时移到临时栈中，
     * 然后将 value 放入队尾，再将临时栈中的元素放回队尾。
     *
     * 示例：sortedInsert([1, 3, 5], 4) → deque 变为 [1, 3, 4, 5]
     *       sortedInsert([2, 4], 1)    → deque 变为 [1, 2, 4]
     *       sortedInsert([2, 4], 9)    → deque 变为 [2, 4, 9]
     *
     * @param deque 已排序的双端队列
     * @param value 要插入的值
     */
    public static void sortedInsert(ArrayDeque<Integer> deque, int value) {
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        // // 将队尾所有大于 value 的元素移到临时栈
        while (!deque.isEmpty() && (deque.peekLast() > value) /* 填空7：将 deque.isEmpty() 替换为"队列不为空 且 队尾元素大于 value"的条件 */) {
            temp.push(deque.pollLast());
        }
        // // 将 value 放入队尾
        deque.addLast(value); // 填空8：将 0 替换为要插入的值
        // // 将临时栈中的元素放回队尾
        while (!temp.isEmpty()) {
            deque.addLast(temp.pop());
        }
    }

    // ==================== main ====================

    public static void main(String[] args) {
        // isPalindrome
        System.out.println("isPalindrome(\"racecar\") = " + isPalindrome("racecar"));
        System.out.println("isPalindrome(\"hello\") = " + isPalindrome("hello"));

        // reverseFirstK
        LinkedList<Integer> queue = new LinkedList<>();
        for (int x : new int[]{1, 2, 3, 4, 5}) queue.offer(x);
        reverseFirstK(queue, 3);
        System.out.println("reverseFirstK([1,2,3,4,5], 3) = " + queue);

        // sortedInsert
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1); deque.addLast(3); deque.addLast(5);
        sortedInsert(deque, 4);
        System.out.println("sortedInsert([1,3,5], 4) = " + deque);
    }
}
