# Lab05 练习 4 — 双端队列应用

## 考察内容

- **Deque 双端操作**：addFirst/addLast/pollFirst/pollLast/peekFirst/peekLast
- **回文检测算法**：利用双端队列从两端同时比较
- **队列前 k 个元素反转**：栈 + 队列组合使用
- **有序插入**：在已排序的双端队列中插入新值并保持有序

## 题目说明

实现 `DequeApps` 类中的三个静态方法，涵盖双端队列的典型应用场景。

### 方法签名

```java
public static boolean isPalindrome(String str)
public static void reverseFirstK(LinkedList<Integer> queue, int k)
public static void sortedInsert(ArrayDeque<Integer> deque, int value)
```

### 各方法说明

| 方法 | 功能 | 注意点 |
|------|------|--------|
| `isPalindrome` | 判断字符串是否为回文 | 忽略大小写，只考虑字母和数字 |
| `reverseFirstK` | 反转队列的前 k 个元素 | 修改原队列，其余元素顺序不变 |
| `sortedInsert` | 向有序双端队列插入新值 | 保持升序排列 |

#### 1. `isPalindrome(String str)`

使用双端队列判断字符串是否为回文。忽略大小写，只考虑字母和数字字符。

将有效字符（转小写后）加入双端队列，然后从两端同时取出字符比较，若全部相等则为回文。

```
isPalindrome("racecar")                        → true
isPalindrome("A man a plan a canal Panama")     → true
isPalindrome("hello")                           → false
isPalindrome("")                                → true
```

#### 2. `reverseFirstK(LinkedList<Integer> queue, int k)`

反转队列的前 k 个元素，其余元素顺序不变。会修改原队列。

思路：
1. 将前 k 个元素依次从队首取出，压入临时栈
2. 将栈中元素依次弹出，放回队尾
3. 将队列中剩余的 (size - k) 个元素依次从队首移到队尾

```
reverseFirstK([1,2,3,4,5], 3)  → 队列变为 [3,2,1,4,5]
reverseFirstK([10,20,30], 2)   → 队列变为 [20,10,30]
```

#### 3. `sortedInsert(ArrayDeque<Integer> deque, int value)`

向已按升序排列的双端队列中插入一个新值，保持有序。队首为最小值，队尾为最大值。

从队尾开始，将所有大于 value 的元素暂时移到临时栈中，然后将 value 放入队尾，再将临时栈中的元素放回队尾。

```
sortedInsert([1, 3, 5], 4)  → deque 变为 [1, 3, 4, 5]
sortedInsert([2, 4], 1)     → deque 变为 [1, 2, 4]
sortedInsert([2, 4], 9)     → deque 变为 [2, 4, 9]
```

## 完型填空说明

代码框架已给出，你需要将标记为 `填空N` 的位置替换为正确的表达式。

| 编号 | 所在方法 | 需填写内容 |
|------|---------|-----------|
| 填空1 | `isPalindrome` | addLast 参数：将 `' '` 替换为应加入队列的字符 |
| 填空2 | `isPalindrome` | pollFirst：将 `' '` 替换为从队首取出字符的表达式 |
| 填空3 | `isPalindrome` | pollLast：将 `' '` 替换为从队尾取出字符的表达式 |
| 填空4 | `reverseFirstK` | push 参数：将 `0` 替换为从队首取出元素的表达式 |
| 填空5 | `reverseFirstK` | offer 参数：将 `0` 替换为从栈中弹出元素的表达式 |
| 填空6 | `reverseFirstK` | offer 参数：将 `0` 替换为从队首取出并放到队尾的表达式 |
| 填空7 | `sortedInsert` | while 条件：将 `deque.isEmpty()` 替换为"队列不为空 且 队尾元素大于 value"的条件 |
| 填空8 | `sortedInsert` | addLast 参数：将 `0` 替换为要插入的值 |

> **关键思路**：理解 Deque 的两端操作语义，以及如何用 ArrayDeque 同时充当栈和队列。

## 提交方式

在项目根目录下运行：

```bash
mvn test
```

所有测试通过即为完成。

## 示例运行

```
isPalindrome("racecar") = true
isPalindrome("hello") = false
reverseFirstK([1,2,3,4,5], 3) = [3, 2, 1, 4, 5]
sortedInsert([1,3,5], 4) = [1, 3, 4, 5]
```
