# Lab05 练习 1 — 链表工具箱

## 考察内容

- **LinkedList 基础操作**：使用 addLast、get、add(index) 等方法
- **链表遍历**：使用 for 循环和 Iterator 访问链表元素
- **Iterator 安全删除**：使用 Iterator 的 remove() 方法避免 ConcurrentModificationException
- **有序插入**：在已排序链表中找到正确位置插入元素
- **链表反转**：通过下标计算实现倒序访问

## 题目说明

实现 `LinkedListTools` 类中的五个方法，涵盖 `LinkedList` 的构建、转换、有序插入、删除和反转操作。

### 方法签名

```java
public static LinkedList<Integer> buildList(int[] arr)
public static int[] toArray(LinkedList<Integer> list)
public static void insertSorted(LinkedList<Integer> sortedList, int value)
public static int removeAllOccurrences(LinkedList<Integer> list, int value)
public static LinkedList<Integer> reverseList(LinkedList<Integer> list)
```

### 各方法说明

| 方法 | 功能 | 注意点 |
|------|------|--------|
| `buildList` | 将 int 数组转为 LinkedList | 使用 addLast 逐个添加 |
| `toArray` | 将 LinkedList 转为 int 数组 | 使用 get(i) 取值 |
| `insertSorted` | 在已排序链表中插入元素 | 保持升序，修改原链表 |
| `removeAllOccurrences` | 删除所有等于 value 的元素 | 使用 Iterator，返回删除个数 |
| `reverseList` | 返回反转后的新链表 | 不修改原链表 |

#### 1. `buildList(int[] arr)`

将 int 数组中的元素逐个添加到 LinkedList 中并返回。

```
buildList({1, 2, 3}) → [1, 2, 3]
buildList({})        → []
buildList({42})      → [42]
```

#### 2. `toArray(LinkedList<Integer> list)`

将 LinkedList 中的元素转为 int 数组并返回。

```
toArray([4, 5, 6]) → {4, 5, 6}
toArray([99])      → {99}
toArray([])        → {}
```

#### 3. `insertSorted(LinkedList<Integer> sortedList, int value)`

在已按升序排列的链表中插入 value，使链表仍然有序。会修改原链表。

```
insertSorted([1, 3, 5], 4) → 链表变为 [1, 3, 4, 5]
insertSorted([2, 4], 1)    → 链表变为 [1, 2, 4]
insertSorted([2, 4], 9)    → 链表变为 [2, 4, 9]
insertSorted([], 5)        → 链表变为 [5]
```

#### 4. `removeAllOccurrences(LinkedList<Integer> list, int value)`

删除链表中所有等于 value 的元素，返回删除的个数。使用 Iterator 的 remove() 方法安全删除。

```
removeAllOccurrences([3, 1, 3, 2], 3) → 2, 链表变为 [1, 2]
removeAllOccurrences([1, 2, 3], 9)    → 0, 链表不变
removeAllOccurrences([7, 7, 7], 7)    → 3, 链表变为 []
```

#### 5. `reverseList(LinkedList<Integer> list)`

返回一个新的 LinkedList，元素顺序与原链表相反。**不修改原链表**。

```
reverseList([1, 2, 3]) → [3, 2, 1]
reverseList([42])      → [42]
reverseList([])        → []
```

## 完型填空说明

代码框架已给出，你需要将标记为 `填空N` 的位置替换为正确的表达式。

| 编号 | 所在方法 | 需填写内容 |
|------|---------|-----------|
| 填空1 | `buildList` | 将 `0` 替换为正确的数组元素访问 |
| 填空2 | `toArray` | 将 `0` 替换为从链表中取值的表达式 |
| 填空3 | `insertSorted` | 将 `false` 替换为判断当前元素 >= value 的条件 |
| 填空4 | `removeAllOccurrences` | 将 `false` 替换为判断迭代器当前元素等于 value 的条件 |
| 填空5 | `reverseList` | 将 `null` 替换为从原链表中倒序取元素的表达式 |

> **关键思路**：填空1、2、5 涉及如何通过下标正确访问数组或链表元素；填空3 需要理解有序插入的条件判断；填空4 需要掌握 Iterator 的 next() 和 equals() 用法。

## 提交方式

在项目根目录下运行：

```bash
mvn test
```

所有测试通过即为完成。

## 示例运行

```
buildList({1,2,3}) = [1, 2, 3]
toArray([1,2,3]) = {1, 2, 3}
insertSorted([1,3,5], 4) → [1, 3, 4, 5]
removeAllOccurrences([3,1,3,2,3], 3) = 3, list=[1, 2]
reverseList([1,2,3,4]) = [4, 3, 2, 1]
```
