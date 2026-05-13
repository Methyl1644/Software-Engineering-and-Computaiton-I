import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 队列模拟器 -- 使用 LinkedList 作为队列的应用练习。
 *
 * LinkedList 实现了 Queue 接口，提供 offer/poll/peek 方法。
 * offer 将元素加入队尾，poll 取出队首元素，peek 查看队首元素。
 */
public class QueueSimulator {

    // ==================== hotPotato ====================

    /**
     * 击鼓传花游戏。
     *
     * 规则：所有人站成一圈（用队列模拟），从队首开始传花，
     * 每传一次将队首的人移到队尾，传到第 num 次时队首的人淘汰出局。
     * 重复此过程直到只剩一人，返回此人的名字。
     *
     * 示例：hotPotato(["A","B","C","D","E"], 3)
     *       第1轮：A->队尾, B->队尾, C淘汰 -> 剩[D,E,A,B]
     *       第2轮：D->队尾, E->队尾, A淘汰 -> 剩[B,D,E]
     *       第3轮：B->队尾, D->队尾, E淘汰 -> 剩[B,D]
     *       第4轮：B->队尾, D->队尾, B淘汰 -> 剩[D]
     *       返回 "D"
     *
     * @param names 参与者名单
     * @param num   每轮传递次数
     * @return 最后剩下的人的名字
     */
    public static String hotPotato(ArrayList<String> names, int num) {
        LinkedList<String> queue = new LinkedList<>();
        for(int i = 0;i < names.size();i++){
            queue.offer(names.get(i));
        }
        while(queue.size() > 1){
            for(int i = 0;i < num - 1;i++){
                queue.offer(queue.get(0));
                queue.poll();
            }
            queue.poll();
        }
        // // 将所有人加入队列
        // for (int i = 0; i < names.size(); i++) {
        //     queue.offer(null); // 填空1：将 null 替换为正确的参与者姓名
        // }
        // // 不断淘汰，直到只剩一人
        // while (queue.size() > 1) {
        //     // 前 num-1 个人从队首移到队尾
        //     for (int i = 0; i < num - 1; i++) {
        //         queue.offer(null); // 填空2：将 null 替换为"从队首取出并放到队尾"的表达式
        //     }
        //     // 第 num 个人淘汰
        //     ; // 填空3：在此处填入将队首元素移出队列的语句
        // }
        return queue.peek();
    }

    // ==================== josephus ====================

    /**
     * 约瑟夫环问题。
     *
     * n 个人（编号 1 到 n）围成一圈，从编号 1 开始报数，
     * 每数到 k 的人出列。返回出列顺序。
     *
     * 示例：josephus(5, 2)
     *       初始：[1,2,3,4,5]
     *       1->队尾, 2出列 -> [3,4,5,1], 出列[2]
     *       3->队尾, 4出列 -> [5,1,3], 出列[2,4]
     *       5->队尾, 1出列 -> [3,5], 出列[2,4,1]
     *       3->队尾, 5出列 -> [3], 出列[2,4,1,5]
     *       3出列 -> [], 出列[2,4,1,5,3]
     *       返回 [2, 4, 1, 5, 3]
     *
     * @param n 总人数
     * @param k 每轮数到 k 淘汰
     * @return 出列顺序
     */
    public static ArrayList<Integer> josephus(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            for(int i = 0;i < k - 1;i++){
                queue.offer(queue.get(0));
                queue.poll();
            }
            result.add(queue.poll());
        }
        // // 编号 1 到 n 入队
        // for (int i = 1; i <= n; i++) {
        //     queue.offer(0); // 填空4：将 0 替换为正确的编号
        // }
        // while (!queue.isEmpty()) {
        //     // 前 k-1 个人从队首移到队尾
        //     for (int i = 0; i < k - 1; i++) {
        //         queue.offer(0); // 填空5：将 0 替换为"从队首取出并放到队尾"的表达式
        //     }
        //     // 第 k 个人出列
        //     result.add(0); // 填空6：将 0 替换为从队首取出元素的表达式
        // }
        return result;
    }

    // ==================== generateSequence ====================

    /**
     * 使用队列生成二叉树的层序序列。
     *
     * 从 1 开始，每次取出队首元素 x，将 2*x 和 2*x+1 放入队尾。
     * 将取出的元素依次加入结果列表，直到结果列表有 n 个元素。
     *
     * 示例：generateSequence(7) -> [1, 2, 3, 4, 5, 6, 7]
     *       generateSequence(4) -> [1, 2, 3, 4]
     *
     * @param n 需要生成的元素个数
     * @return 生成的序列
     */
    public static ArrayList<Integer> generateSequence(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n <= 0) return result;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(result.size() < n){
            int current = queue.poll();
            result.add(current);
            if (result.size() < n) {
                queue.offer(2 * current); // 填空7a：将 0 替换为 current 的左子节点编号（2 * current）
                queue.offer(2 * current + 1); // 填空7b：将 0 替换为 current 的右子节点编号（2 * current + 1）
            }
        }
        // LinkedList<Integer> queue = new LinkedList<>();
        // queue.offer(1);
        // while (result.size() < n) {
        //     int current = queue.poll();
        //     result.add(current);
        //     if (result.size() < n) {
        //         queue.offer(0); // 填空7a：将 0 替换为 current 的左子节点编号（2 * current）
        //         queue.offer(0); // 填空7b：将 0 替换为 current 的右子节点编号（2 * current + 1）
        //     }
        // }
        return result;
    }

    // ==================== main ====================

    public static void main(String[] args) {
        // hotPotato
        ArrayList<String> names = new ArrayList<>();
        names.add("A"); names.add("B"); names.add("C"); names.add("D"); names.add("E");
        System.out.println("hotPotato([A,B,C,D,E], 3) = " + hotPotato(names, 3));

        // josephus
        System.out.println("josephus(5, 2) = " + josephus(5, 2));

        // generateSequence
        System.out.println("generateSequence(7) = " + generateSequence(7));
    }
}
