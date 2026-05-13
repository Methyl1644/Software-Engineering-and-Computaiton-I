/**
 * Lab02 练习 4 — 数组进阶分析
 *
 * 难度提升：
 *   - 两遍扫描：先求均值，再统计
 *   - 双重 for 循环枚举所有元素对
 *   - 游程计数：跨迭代维护"上一个值"状态
 *
 * 请将标有"填空N"的占位符替换为正确的表达式或语句，不允许修改方法签名。
 */
public class ArrayAnalyzer {

    /**
     * 统计数组中严格大于平均值的元素个数。
     *
     * 思路（两遍扫描）：
     *   第一遍：用 for-each 累加所有元素，计算平均值（double 类型）。
     *   第二遍：再次遍历，统计 x > avg 的元素个数。
     *
     * 示例：
     *   countAboveAverage([1, 2, 3, 4, 5])  →  2   (avg=3.0，4 和 5 大于 3.0)
     *   countAboveAverage([5, 5, 5])        →  0   (avg=5.0，无元素严格大于 5.0)
     *   countAboveAverage([])               →  0
     *
     * @param arr 整数数组
     * @return 严格大于平均值的元素个数
     */
    public static int countAboveAverage(int[] arr) {
        if (arr.length == 0) return 0;

        // 第一遍：计算总和
        double sum = 0;
        for (int x : arr) {
            sum += x;
            // 填空1：将空语句替换为累加语句
            //        提示：sum += x
            ; /* 填空1 */
        }

        // 填空2：将 0.0 替换为计算平均值的表达式
        //        提示：sum / arr.length
        double avg = sum / arr.length; /* 填空2 */

        // 第二遍：统计大于均值的元素个数
        int count = 0;
        for (int x : arr) {
            // 填空3：将 false 替换为"x 严格大于 avg"的条件
            //        注意：等于 avg 的元素不计入（严格大于）
            //        提示：x > avg
            if (x > avg) {
                count++;
            }
        }

        return count;
    }

    /**
     * 判断数组中是否存在两个不同位置的元素之和等于 target。
     *
     * 思路（双重循环枚举）：
     *   外层 i 从 0 到 length-1，内层 j 从 i+1 到 length-1，
     *   枚举所有满足 i < j 的元素对，检查 arr[i]+arr[j] 是否等于 target。
     *
     * 示例：
     *   twoSum([1, 2, 3, 4], 5)   →  true    (1+4=5 或 2+3=5)
     *   twoSum([1, 2, 3], 7)      →  false
     *   twoSum([1, 1], 2)         →  true    (arr[0]+arr[1]=1+1=2)
     *   twoSum([5], 5)            →  false   (只有一个元素)
     *
     * @param arr    整数数组
     * @param target 目标和
     * @return 存在满足条件的元素对时返回 true，否则返回 false
     */
    public static boolean twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {

            // 填空4：将 0 替换为内层循环的正确起点
            //        提示：从 i+1 开始，确保 j > i（每对只枚举一次，且不用同一元素两次）
            for (int j = i + 1 /* 填空4 */; j < arr.length; j++) {

                // 填空5：将 false 替换为"arr[i] 和 arr[j] 之和等于 target"的条件
                //        提示：arr[i] + arr[j] == target
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 统计数组中"游程"（连续相同值段）的数量。
     *
     * 游程：连续相同值构成一段。每当相邻两个元素值不同时，游程数量加一。
     *
     * 思路：初始化 runs=1（第一段），从下标 1 开始遍历，
     *       若 arr[i] != arr[i-1]，说明发生了一次切换，runs++。
     *
     * 示例：
     *   countRuns([1, 1, 2, 2, 3])  →  3
     *   countRuns([1, 2, 3])        →  3
     *   countRuns([4, 4, 4])        →  1
     *   countRuns([])               →  0
     *   countRuns([7])              →  1
     *
     * @param arr 整数数组
     * @return 游程数量（空数组返回 0）
     */
    public static int countRuns(int[] arr) {
        if (arr.length == 0) return 0;

        int runs = 1;   // 非空数组至少有 1 段

        for (int i = 1; i < arr.length; i++) {
            // 填空6：将 false 替换为"当前元素与前一个不同"的条件
            //        若不同，说明进入了新的一段，runs++
            //        提示：arr[i] != arr[i - 1]
            if (arr[i] != arr[i - 1]) {
                runs++;
            }
        }

        return runs;
    }

    /**
     * 手动测试入口。
     */
    public static void main(String[] args) {
        System.out.println(countAboveAverage(new int[]{1, 2, 3, 4, 5}));  // 预期：2
        System.out.println(countAboveAverage(new int[]{5, 5, 5}));         // 预期：0
        System.out.println(countAboveAverage(new int[]{}));                 // 预期：0
        System.out.println("---");
        System.out.println(twoSum(new int[]{1, 2, 3, 4}, 5));  // 预期：true
        System.out.println(twoSum(new int[]{1, 2, 3}, 7));     // 预期：false
        System.out.println(twoSum(new int[]{1, 1}, 2));         // 预期：true
        System.out.println(twoSum(new int[]{5}, 5));            // 预期：false
        System.out.println("---");
        System.out.println(countRuns(new int[]{1, 1, 2, 2, 3}));  // 预期：3
        System.out.println(countRuns(new int[]{1, 2, 3}));         // 预期：3
        System.out.println(countRuns(new int[]{4, 4, 4}));         // 预期：1
        System.out.println(countRuns(new int[]{}));                 // 预期：0
    }
}
