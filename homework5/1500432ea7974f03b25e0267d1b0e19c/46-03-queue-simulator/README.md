# Lab05 练习 3 — 队列模拟器

## 考察内容

- 使用 `LinkedList` 作为队列（`Queue` 接口）
- 队列的 `offer`/`poll`/`peek` 操作
- 用队列模拟环形结构（击鼓传花、约瑟夫环）
- 用队列进行层序（BFS）生成

## 题目说明

实现工具类 `QueueSimulator`，提供 3 个 `public static` 方法。本练习的核心思路是：**用队列的"先进先出"特性模拟环形和层序遍历过程**。

### 方法签名

```java
public static String hotPotato(ArrayList<String> names, int num)
public static ArrayList<Integer> josephus(int n, int k)
public static ArrayList<Integer> generateSequence(int n)
```

### 各方法说明

| 方法 | 功能 | 关键操作 |
|------|------|----------|
| `hotPotato` | 击鼓传花，返回最后幸存者 | offer/poll 模拟环形传递 |
| `josephus` | 约瑟夫环，返回出列顺序 | offer/poll 模拟报数淘汰 |
| `generateSequence` | 生成二叉树层序序列 | offer/poll 模拟 BFS |

### hotPotato 详解

击鼓传花：所有人站成一圈（用队列模拟），每轮将队首的人移到队尾（传花），传到第 num 次时队首的人淘汰。重复直到剩最后一人。

"移到队尾"的操作 = `queue.offer(queue.poll())`：先从队首取出，再放到队尾。

```
names = ["A", "B", "C", "D", "E"], num = 3

初始队列: [A, B, C, D, E]
第1轮: A->队尾, B->队尾, C淘汰 -> [D, E, A, B]
第2轮: D->队尾, E->队尾, A淘汰 -> [B, D, E]
第3轮: B->队尾, D->队尾, E淘汰 -> [B, D]
第4轮: B->队尾, D->队尾, B淘汰 -> [D]
返回 "D"
```

### josephus 详解

约瑟夫环：n 个人（编号 1~n）围成一圈，从 1 开始报数，每数到 k 的人出列。返回出列顺序。

与击鼓传花非常类似，区别在于：
- 初始队列放入编号 1~n
- 每次淘汰的人加入结果列表
- 循环直到队列为空（所有人都出列）

```
josephus(5, 2):
初始: [1, 2, 3, 4, 5]
1->队尾, 2出列 -> [3, 4, 5, 1], 出列序列: [2]
3->队尾, 4出列 -> [5, 1, 3], 出列序列: [2, 4]
5->队尾, 1出列 -> [3, 5], 出列序列: [2, 4, 1]
3->队尾, 5出列 -> [3], 出列序列: [2, 4, 1, 5]
3出列 -> [], 出列序列: [2, 4, 1, 5, 3]
返回 [2, 4, 1, 5, 3]
```

### generateSequence 详解

利用队列生成二叉树的层序编号序列。完全二叉树中，编号为 x 的节点的左子节点编号为 2*x，右子节点编号为 2*x+1。

算法：
1. 将 1 放入队列
2. 取出队首元素 x，加入结果列表
3. 将 2*x 和 2*x+1 放入队尾
4. 重复步骤 2-3，直到结果列表有 n 个元素

```
generateSequence(7):
队列: [1]
取出1, 放入2,3 -> 队列: [2, 3], 结果: [1]
取出2, 放入4,5 -> 队列: [3, 4, 5], 结果: [1, 2]
取出3, 放入6,7 -> 队列: [4, 5, 6, 7], 结果: [1, 2, 3]
取出4 -> 结果: [1, 2, 3, 4]
取出5 -> 结果: [1, 2, 3, 4, 5]
取出6 -> 结果: [1, 2, 3, 4, 5, 6]
取出7 -> 结果: [1, 2, 3, 4, 5, 6, 7]
返回 [1, 2, 3, 4, 5, 6, 7]
```

## 完型填空说明

本练习共有 **7 个填空**（填空7 分为 7a 和 7b 两个子填空），需要将占位代码替换为正确实现。

| 编号 | 所在方法 | 需填写内容 |
|------|---------|-----------|
| 填空1 | `hotPotato` | 将 `queue.offer(null)` 中的 `null` 替换为正确的参与者姓名 |
| 填空2 | `hotPotato` | 将 `queue.offer(null)` 中的 `null` 替换为"从队首取出并放到队尾"的表达式 |
| 填空3 | `hotPotato` | 在 `;` 处填入将队首元素移出队列的语句 |
| 填空4 | `josephus` | 将 `queue.offer(0)` 中的 `0` 替换为正确的编号 |
| 填空5 | `josephus` | 将 `queue.offer(0)` 中的 `0` 替换为"从队首取出并放到队尾"的表达式 |
| 填空6 | `josephus` | 将 `result.add(0)` 中的 `0` 替换为从队首取出元素的表达式 |
| 填空7a | `generateSequence` | 将 `queue.offer(0)` 中的 `0` 替换为 current 的左子节点编号 |
| 填空7b | `generateSequence` | 将 `queue.offer(0)` 中的 `0` 替换为 current 的右子节点编号 |

> **提示**：队列的核心操作只有三个：`offer`（入队）、`poll`（出队并返回）、`peek`（查看队首但不移除）。
> "从队首移到队尾"= `queue.offer(queue.poll())`。

## 提示

### Queue 常用 API 速查

| 方法 | 说明 |
|------|------|
| `queue.offer(e)` | 将元素 e 加入队尾 |
| `queue.poll()` | 取出并移除队首元素（队空返回 null） |
| `queue.peek()` | 查看队首元素但不移除（队空返回 null） |
| `queue.size()` | 返回队列中的元素个数 |
| `queue.isEmpty()` | 判断队列是否为空 |

### 关键思路

- **队列模拟环形**：将队首元素取出放到队尾（`offer(poll())`），相当于"跳过"这个人，让下一个人成为队首。
- **hotPotato 与 josephus 的区别**：hotPotato 淘汰后丢弃，josephus 淘汰后记录到结果列表。
- **generateSequence 的 BFS 思想**：与二叉树的层序遍历完全一致——处理当前节点，将其子节点入队。

## 提交方式

在 `03-queue-simulator` 目录下执行：

```bash
# 编译并运行所有测试
mvn clean test

# 只运行公开测试
mvn test -Dtest=QueueSimulatorTest

# 只运行隐藏测试
mvn test -Dtest=PrivateQueueSimulatorTest
```

## 示例运行

```
hotPotato([A,B,C,D,E], 3)  → "D"
josephus(5, 2)              → [2, 4, 1, 5, 3]
generateSequence(7)         → [1, 2, 3, 4, 5, 6, 7]
```
