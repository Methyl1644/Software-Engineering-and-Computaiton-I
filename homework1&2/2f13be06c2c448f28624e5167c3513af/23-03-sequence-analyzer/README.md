# Lab02 练习 3 — 数列分析（进阶循环）

## 难度说明

本题在练习 1、2 的基础上进一步提升：
- **多变量状态**：while 循环中维护多个变量同步更新
- **嵌套循环**：外层遍历候选数，内层验证素数性质
- **跨迭代状态追踪**：for 循环中记录"当前连续段"长度并更新最大值

## 考察内容

- `while` 循环中多个状态变量的协同更新
- 嵌套 `for` 循环 + `break` 提前终止内层
- `for` 循环中跨迭代的状态变量（当前段 vs 历史最大值）
- 布尔标志变量（`boolean prime`）的使用

## 方法说明

### `fibonacci(int n)` — 第 n 个斐波那契数

斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, ...（fib(0)=0, fib(1)=1）

用 **while 循环 + 两个变量滚动更新** 实现（不使用递归）。

```
fibonacci(0)   →  0
fibonacci(1)   →  1
fibonacci(5)   →  5
fibonacci(10)  →  55
```

### `sumPrimes(int limit)` — 质数之和

计算 2 到 limit（含）中所有质数之和，使用**嵌套 for 循环**判断每个数是否为质数。

```
sumPrimes(10)  →  17   (2+3+5+7)
sumPrimes(2)   →  2
sumPrimes(1)   →  0
```

### `longestRun(int[] arr)` — 最长连续相同段

找出数组中连续相同值的最长段的长度。

```
longestRun([1, 1, 2, 2, 2, 1])  →  3   ([2,2,2])
longestRun([1, 2, 3])           →  1   (每段长度为 1)
longestRun([4, 4, 4, 4])        →  4
longestRun([])                  →  0
```

## 完型填空说明

| 编号 | 所在方法 | 要填写的内容 |
|------|---------|------------|
| 填空1 | `fibonacci` | while 循环条件（`step < n`） |
| 填空2a | `fibonacci` | 下一个斐波那契值（`prev + curr`） |
| 填空2b | `fibonacci` | 将 `next` 赋给 `curr` |
| 填空3 | `sumPrimes` | 内层循环的终止条件（`i * i <= n`） |
| 填空4 | `sumPrimes` | 质数时将 n 累加到 sum |
| 填空5 | `longestRun` | 当前元素与前一个相同的条件 |
| 填空6 | `longestRun` | 更新最大连续段长度的条件 |

> **提示 — fibonacci 双变量滚动**：
> 维护 `prev`（前一个）和 `curr`（当前）两个变量，
> 每轮更新：`next = prev + curr`，然后 `prev = curr`，`curr = next`。
> 不能同时赋值，顺序很关键。

> **提示 — sumPrimes 内层循环**：
> 判断 `n` 是否为质数只需检查到 `√n`，即 `i * i <= n`。
> 找到因子后立即 `break`，减少无效计算。

## 提交与测试

```bash
mvn test
mvn test -Dtest=SequenceAnalyzerTest   # 仅明测试
```
