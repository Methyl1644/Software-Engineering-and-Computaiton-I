# Lab05 练习 2 — 栈应用

## 考察内容

- 栈的基本操作：`push`、`pop`、`peek`
- 使用 `LinkedList` 作为栈（`push` 压入链表头部，`pop` 弹出链表头部）
- 字符串反转（利用栈的 LIFO 特性）
- 括号匹配算法
- 进制转换（十进制转二进制）

## 题目说明

实现工具类 `StackOps`，提供 3 个 `public static` 方法，练习使用栈解决经典问题。

### 方法签名

```java
public static String reverseString(String str)
public static boolean isBalanced(String expr)
public static String decimalToBinary(int n)
```

### 各方法说明

| 方法 | 功能 | 注意点 |
|------|------|--------|
| `reverseString` | 使用栈反转字符串 | 将每个字符 push 入栈，再逐个 pop 拼接 |
| `isBalanced` | 判断括号是否匹配，支持 `()`、`[]`、`{}` | 遇到左括号压栈，遇到右括号检查栈顶 |
| `decimalToBinary` | 将非负整数转为二进制字符串 | 反复除 2 取余 push 入栈，再 pop 拼接；0 返回 `"0"` |

#### `reverseString` 说明

利用栈**后进先出（LIFO）**的特性：先将字符串中的字符依次压入栈，再依次弹出，得到的顺序恰好是原字符串的反转。空字符串直接返回空字符串。

#### `isBalanced` 说明

经典的括号匹配算法：
1. 遍历字符串，遇到左括号 `(`、`[`、`{` 压入栈。
2. 遇到右括号时，找到对应的左括号，检查栈是否为空以及栈顶是否匹配。
3. 遍历结束后，栈为空说明所有括号都已匹配。
4. 忽略非括号字符。

#### `decimalToBinary` 说明

十进制转二进制的经典算法：
1. 反复将 `n % 2`（余数）压入栈，然后 `n = n / 2`。
2. 循环结束后，依次弹出栈中元素拼接，即为二进制表示。
3. 栈保证了低位先入、高位后入，弹出时高位先出，顺序正确。

## 完型填空说明

本练习共有 **6 个填空**，需要将占位代码替换为正确实现。

| 编号 | 所在方法 | 需填写内容 |
|------|---------|-----------|
| 填空1 | `reverseString` | 将 `stack.push(' ')` 中的 `' '` 替换为正确的字符 |
| 填空2 | `reverseString` | 将 `sb.append(' ')` 中的 `' '` 替换为从栈中弹出元素的表达式 |
| 填空3 | `isBalanced` | 将 `stack.push(' ')` 中的 `' '` 替换为应该压入栈的字符 |
| 填空4 | `isBalanced` | 将 `false` 替换为"栈为空 或 弹出的栈顶不等于 match"的条件 |
| 填空5 | `decimalToBinary` | 将 `stack.push(0)` 中的 `0` 替换为 n 除以 2 的余数 |
| 填空6 | `decimalToBinary` | 将 `sb.append(0)` 中的 `0` 替换为从栈中弹出元素的表达式 |

> **提示**：填空4 需要同时判断两个条件（用 `||` 连接），并且 `pop()` 会弹出栈顶元素，
> 所以在比较的同时就完成了弹出操作。

## 提示

### LinkedList 栈操作 API 速查

| 方法 | 说明 |
|------|------|
| `stack.push(e)` | 将元素压入栈顶（链表头部） |
| `stack.pop()` | 弹出并返回栈顶元素 |
| `stack.peek()` | 查看栈顶元素但不弹出 |
| `stack.isEmpty()` | 判断栈是否为空 |

### 栈的工作原理

栈是**后进先出（LIFO, Last In First Out）**的数据结构：

```
push(A) → [A]
push(B) → [B, A]
push(C) → [C, B, A]
pop()   → 返回 C，栈变为 [B, A]
pop()   → 返回 B，栈变为 [A]
```

## 提交方式

在 `02-stack-ops` 目录下执行：

```bash
# 编译并运行所有测试
mvn clean test

# 只运行公开测试
mvn test -Dtest=StackOpsTest

# 只运行隐藏测试
mvn test -Dtest=PrivateStackOpsTest
```

## 示例运行

```
reverseString("hello")    → "olleh"
reverseString("")          → ""
isBalanced("([])")         → true
isBalanced("([)]")         → false
isBalanced("hello")        → true
decimalToBinary(10)        → "1010"
decimalToBinary(0)         → "0"
decimalToBinary(255)       → "11111111"
```
