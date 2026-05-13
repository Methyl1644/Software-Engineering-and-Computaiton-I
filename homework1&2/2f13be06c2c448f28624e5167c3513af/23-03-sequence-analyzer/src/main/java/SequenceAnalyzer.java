/**
 * Lab02 练习 3 — 数列分析（进阶循环）
 *
 * 难度提升：
 *   - while 循环中多变量协同更新
 *   - 嵌套 for 循环 + break 提前终止
 *   - 跨迭代状态追踪（当前段 vs 历史最大）
 *
 * 请将标有"填空N"的占位符替换为正确的表达式或语句，不允许修改方法签名。
 */
public class SequenceAnalyzer {

    /**
     * 计算第 n 个斐波那契数（从 0 开始计数）。
     *
     * 斐波那契数列：fib(0)=0, fib(1)=1, fib(n)=fib(n-1)+fib(n-2)
     *   0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
     *
     * 要求：使用 while 循环 + 两个滚动变量实现，不使用递归。
     *
     * 示例：
     *   fibonacci(0)   →  0
     *   fibonacci(1)   →  1
     *   fibonacci(5)   →  5
     *   fibonacci(10)  →  55
     *
     * @param n 第 n 个（n >= 0）
     * @return 第 n 个斐波那契数
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int prev = 0;   // fib(0)
        int curr = 1;   // fib(1)
        int step = 1;   // 当前已算到第 step 个

        // 填空1：将 false 替换为 while 循环的终止条件
        //        含义：还没有算到第 n 个，继续循环
        //        提示：step < n
        while (step < n) {

            // 填空2a：将 0 替换为下一个斐波那契数的计算表达式
            //         提示：next = prev + curr
            int next = prev + curr; /* 填空2a */

            prev = curr;

            // 填空2b：将 0 替换为正确的赋值（让 curr 成为刚算出的 next）
            //         提示：curr = next
            curr = next; /* 填空2b */

            step++;
        }

        return curr;
    }

    /**
     * 计算 2 到 limit（含）中所有质数之和。
     *
     * 质数：只能被 1 和自身整除的大于 1 的整数。
     *
     * 要求：外层 for 枚举候选数，内层 for 验证是否为质数（检查到 √n），
     *       用布尔变量 prime 标记，找到因子后立即 break。
     *
     * 示例：
     *   sumPrimes(10)  →  17   (2+3+5+7)
     *   sumPrimes(2)   →  2
     *   sumPrimes(1)   →  0
     *
     * @param limit 上界（含）
     * @return 所有质数之和
     */
    public static int sumPrimes(int limit) {
        int sum = 0;

        for (int n = 2; n <= limit; n++) {
            boolean prime = true;   // 先假设 n 是质数

            // 填空3：将 false 替换为内层循环的终止条件
            //        只需检查到 √n，即 i*i <= n（避免浮点数）
            //        提示：i * i <= n
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    prime = false;   // 找到因子，n 不是质数
                    break;           // 不必继续检查，提前退出内层循环
                }
            }

            // 填空4：将空语句替换为"如果 prime 为 true，将 n 加入 sum"的语句
            //        提示：if (prime) sum += n;
            if(prime){
                sum += n;
            }/* 填空4 */
        }

        return sum;
    }

    /**
     * 找出数组中"连续相同值"的最长段的长度。
     *
     * 思路：用 curLen 记录当前连续段的长度，maxLen 记录历史最大值。
     *       遍历时，若当前元素与前一个相同则 curLen++，否则重置 curLen=1。
     *       每次更新 curLen 后，检查是否超过 maxLen。
     *
     * 示例：
     *   longestRun([1, 1, 2, 2, 2, 1])  →  3
     *   longestRun([1, 2, 3])           →  1
     *   longestRun([4, 4, 4, 4])        →  4
     *   longestRun([])                  →  0
     *
     * @param arr 整数数组
     * @return 最长连续相同段的长度，空数组返回 0
     */
    public static int longestRun(int[] arr) {
        if (arr.length == 0) return 0;

        int maxLen = 1;   // 至少有 1 个元素，最长段至少为 1
        int curLen = 1;   // 从第一个元素开始，当前段长度为 1

        for (int i = 1; i < arr.length; i++) {

            // 填空5：将 false 替换为"当前元素与前一个相同"的条件
            //        提示：arr[i] == arr[i - 1]
            if (arr[i] == arr[i - 1]) {
                curLen++;   // 延续当前连续段
            } else {
                curLen = 1; // 当前段断开，重新从 1 开始计数
            }

            // 填空6：将 false 替换为"curLen 超过了 maxLen"的条件
            //        若满足则更新 maxLen = curLen
            //        提示：curLen > maxLen
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }

        return maxLen;
    }

    /**
     * 手动测试入口，运行后对照注释中的预期值。
     */
    public static void main(String[] args) {
        System.out.println(fibonacci(0));    // 预期：0
        System.out.println(fibonacci(1));    // 预期：1
        System.out.println(fibonacci(5));    // 预期：5
        System.out.println(fibonacci(10));   // 预期：55
        System.out.println("---");
        System.out.println(sumPrimes(10));   // 预期：17
        System.out.println(sumPrimes(2));    // 预期：2
        System.out.println(sumPrimes(1));    // 预期：0
        System.out.println("---");
        System.out.println(longestRun(new int[]{1, 1, 2, 2, 2, 1}));  // 预期：3
        System.out.println(longestRun(new int[]{1, 2, 3}));            // 预期：1
        System.out.println(longestRun(new int[]{4, 4, 4, 4}));         // 预期：4
        System.out.println(longestRun(new int[]{}));                    // 预期：0
    }
}
