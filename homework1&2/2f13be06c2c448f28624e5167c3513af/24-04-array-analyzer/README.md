# Lab02 练习 4 — 数组进阶分析

## 难度说明

本题综合运用循环与分支，模拟真实的数据处理场景：
- **两遍扫描**：第一遍计算统计量，第二遍基于统计量做判断
- **嵌套循环**：枚举所有元素对，O(n²) 复杂度
- **游程编码（RLE）**：统计连续段的切换次数，跨迭代维护状态

## 考察内容

- 循环的两遍扫描模式（先算均值，再比较）
- 双重 `for` 循环枚举元素对
- 内层循环起点的设计（`j = i + 1` 避免重复）
- 状态变量跨迭代维护（`prevVal`、`runs` 计数器）

## 方法说明

### `countAboveAverage(int[] arr)` — 高于均值的元素个数

两遍扫描：第一遍求平均值，第二遍统计严格大于平均值的元素个数。

```
countAboveAverage([1, 2, 3, 4, 5])  →  2   (avg=3.0，4 和 5 大于 3)
countAboveAverage([5, 5, 5])        →  0   (avg=5.0，无元素严格大于 5)
countAboveAverage([])               →  0
```

### `twoSum(int[] arr, int target)` — 存在两个数之和等于目标值

用双重 `for` 循环枚举所有不同下标的元素对（`i < j`），
判断是否存在 `arr[i] + arr[j] == target`。

```
twoSum([1, 2, 3, 4], 5)   →  true    (1+4=5 或 2+3=5)
twoSum([1, 2, 3], 7)      →  false
twoSum([1, 1], 2)         →  true    (arr[0]+arr[1]=2)
twoSum([5], 5)            →  false   (只有一个元素，无法配对)
```

### `countRuns(int[] arr)` — 统计值发生变化的次数

统计相邻元素不同的次数 + 1（即"游程"数量，每次值改变 runs 加一）。

```
countRuns([1, 1, 2, 2, 3])  →  3   (1→1不变，1→2变，2→2不变，2→3变，共2次变化+1=3段)
countRuns([1, 2, 3])        →  3   (每个元素各自一段)
countRuns([4, 4, 4])        →  1   (全部相同，1段)
countRuns([])               →  0
countRuns([7])              →  1
```

## 完型填空说明

| 编号 | 所在方法 | 要填写的内容 |
|------|---------|------------|
| 填空1 | `countAboveAverage` | 累加语句（`sum += x`） |
| 填空2 | `countAboveAverage` | 计算平均值（`sum / arr.length`） |
| 填空3 | `countAboveAverage` | 大于均值的判断条件（`x > avg`） |
| 填空4 | `twoSum` | 内层循环起点（`i + 1`，避免重复配对） |
| 填空5 | `twoSum` | 两数之和等于 target 的条件 |
| 填空6 | `countRuns` | 相邻元素不同的判断条件 |

> **提示 — twoSum 内层从 i+1 开始**：
> 若内层从 0 开始，`(i=0,j=1)` 和 `(i=1,j=0)` 会重复枚举同一对；
> 从 `i+1` 开始确保每对只枚举一次，同时避免 `i == j`（用同一个元素两次）。

> **提示 — countRuns 的初始值**：
> 数组非空时至少有 1 段，因此 `runs` 初始化为 1，
> 每检测到相邻不同就 `runs++`。

## 提交与测试

```bash
mvn test
mvn test -Dtest=ArrayAnalyzerTest   # 仅明测试
```
