/**
 * Lab02 练习 1 — 成绩等级判断器
 *
 * 考察内容：if / else if / else 分支语句、逻辑运算符、比较运算符
 *
 * 说明：
 *   本文件为完型填空题，代码骨架已给出，请将标有"填空N"的 false / 0.0
 *   替换为正确的表达式，使所有测试通过。
 *   不允许修改方法签名（方法名、参数、返回类型）。
 */
public class GradeClassifier {

    /**
     * 根据分数返回成绩等级。
     *
     * 评级规则：
     *   90 ~ 100  →  "优秀"
     *   75 ~  89  →  "良好"
     *   60 ~  74  →  "及格"
     *    0 ~  59  →  "不及格"
     *   其他       →  "无效分数"（score < 0 或 score > 100）
     *
     * @param score 学生成绩（整数）
     * @return 对应的等级字符串
     */
    public static String classify(int score) {

        // 填空1：将 false 替换为判断"分数无效"的条件
        //        分数无效 = 小于 0 或 大于 100
        //        提示：用 || 连接两个比较表达式
        if (score > 100 || score < 0) {
            return "无效分数";
        }

        // 填空2~4：按顺序判断等级，条件应从"最严格"到"最宽松"
        //          若顺序写反（先判断 >= 60），高分也会落入低等级！

        // 填空2：将 false 替换为"优秀"的判断条件（score >= 90）
        if (score >= 90) {
            return "优秀";

        // 填空3：将 false 替换为"良好"的判断条件（score >= 75）
        } else if (score >= 75) {
            return "良好";

        // 填空4：将 false 替换为"及格"的判断条件（score >= 60）
        } else if (score >= 60) {
            return "及格";

        } else {
            return "不及格";
        }
    }

    /**
     * 判断是否通过（60分及以上为通过，且分数须在有效范围内）。
     *
     * 规则：
     *   score >= 0  &&  score <= 100  &&  score >= 60  →  true
     *   否则  →  false
     *
     * @param score 学生成绩（整数）
     * @return 有效分数且 >= 60 时返回 true，否则返回 false
     */
    public static boolean isPassed(int score) {
        // 填空5：将 false 替换为完整的布尔表达式
        //        条件1：分数 >= 0（有效下界）
        //        条件2：分数 <= 100（有效上界）
        //        条件3：分数 >= 60（通过线）
        //        三个条件用 && 连接
        return score >= 0 && score <= 100 && score >= 60; /* 填空5 */
    }

    /**
     * 将分数换算为 GPA 点数。
     *
     * 换算规则（按十位数分档）：
     *   90 ~ 100  →  4.0
     *   80 ~  89  →  3.0
     *   70 ~  79  →  2.0
     *   60 ~  69  →  1.0
     *    0 ~  59  →  0.0
     *   无效分数   →  -1.0
     *
     * @param score 学生成绩（整数）
     * @return GPA 点数（double 类型）
     */
    public static double toGPA(int score) {
        // 无效分数直接返回 -1.0（已给出，勿修改）
        if (score < 0 || score > 100) {
            return -1.0;
        }

        // 填空6a~6d：将各分支中的 0.0 替换为正确的 GPA 值
        //            提示：对照上方换算规则表
        if (score >= 90) {
            return 4.0; /* 填空6a：应为 4.0 */
        } else if (score >= 80) {
            return 3.0; /* 填空6b：应为 3.0 */
        } else if (score >= 70) {
            return 2.0; /* 填空6c：应为 2.0 */
        } else if (score >= 60) {
            return 1.0; /* 填空6d：应为 1.0 */
        } else {
            return 0.0; // 59 分及以下，GPA = 0.0（勿修改）
        }
    }

    /**
     * 可在此处手动测试，运行 main 方法查看输出。
     * 所有输出是否与注释一致，即为填写正确的标志。
     */
    public static void main(String[] args) {
        System.out.println("114514");
        System.out.println(classify(95));    // 预期：优秀
        System.out.println(classify(82));    // 预期：良好
        System.out.println(classify(67));    // 预期：及格
        System.out.println(classify(45));    // 预期：不及格
        System.out.println(classify(-1));    // 预期：无效分数
        System.out.println(classify(101));   // 预期：无效分数
        System.out.println("---");
        System.out.println(isPassed(60));    // 预期：true
        System.out.println(isPassed(59));    // 预期：false
        System.out.println(isPassed(-1));    // 预期：false
        System.out.println("---");
        System.out.println(toGPA(95));       // 预期：4.0
        System.out.println(toGPA(85));       // 预期：3.0
        System.out.println(toGPA(72));       // 预期：2.0
        System.out.println(toGPA(61));       // 预期：1.0
        System.out.println(toGPA(50));       // 预期：0.0
        System.out.println(toGPA(-5));       // 预期：-1.0
    }
}
