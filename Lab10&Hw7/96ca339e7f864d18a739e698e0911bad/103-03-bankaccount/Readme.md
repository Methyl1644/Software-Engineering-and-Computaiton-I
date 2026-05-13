# Lab10 练习 3 — 银行账户系统（BankAccount）

## 考察内容

- **继承层级**：基类 `Account` → 子类 `SavingsAccount` / `CheckingAccount`
- **方法覆盖（Override）vs 字段隐藏（Hiding）**：⭐ 本题最重要的考点
- **`super` 关键字**：调用父类构造方法
- **多态分派**：`Account` 引用调子类方法
- **`instanceof` 类型判断**

## 题目背景

### 银行模型

银行有两种：
- **中央银行（CentralBank）**：存款利率 **0.02**
- **商业银行（CommercialBank）**：存款利率 **0.035**（继承自 CentralBank，覆盖部分行为）

银行最多容纳 **10 个账户**，账户存于 `Account[10]` 数组中。

### 账户层级

```
Account (基类)               ：余额 + 存 / 取 / 查询
  ├── SavingsAccount         ：储蓄账户，可"加利息"
  └── CheckingAccount        ：透支账户，可在 [余额 + 透支额度] 范围内取款
```

| 账户类型 | 特殊能力 |
|:---|:---|
| `Account` | 存钱 `deposit` · 取钱 `withdraw` · 查询 `getBalance` |
| `SavingsAccount extends Account` | 多了 `addInterest()` 方法（按利率加复利） |
| `CheckingAccount extends Account` | 覆盖 `withdraw`，可透支到 `-overdraftLimit` |

## 类设计

### `Account.java`

```java
class Account {
    protected double balance;
    public Account(double balance);
    public void   deposit (double amount);     // 存钱
    public void   withdraw(double amount);     // 取钱（不允许超额）
    public double getBalance();
}
```

### `SavingsAccount.java`

```java
class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(double balance, double interestRate);
    public void addInterest();                  // balance += balance × interestRate
}
```

### `CheckingAccount.java`

```java
class CheckingAccount extends Account {
    private double overdraftLimit;              // 最大透支额度
    public CheckingAccount(double balance, double overdraftLimit);
    @Override
    public void withdraw(double amount);        // 允许透支到 -overdraftLimit
}
```

### `CentralBank.java`

```java
public class CentralBank {
    public double interestRate = 0.02;
    Account[] accounts = new Account[10];

    public int    addAccount(Account account);                  // 添加账户，返回 ID（满则 -1）
    public double calculateInterest(double amount);             // 按本行利率算利息
    public void   depositMoney(double amount, int accountID);
    public void   withdrawMoney(double amount, int accountID);
    public double getAccountBalance(int accountID);
}
```

### `CommercialBank.java`

```java
public class CommercialBank extends CentralBank {
    public double interestRate = 0.035;          // ★ 字段隐藏！

    @Override
    public double calculateInterest(double amount);   // 用 0.035 计算

    public void addInterest();                        // 给所有 SavingsAccount 加利息
}
```

## ⭐ 核心陷阱：字段隐藏（Field Hiding）

```java
CentralBank bank1 = new CommercialBank();
System.out.println(bank1.interestRate);             // 输出 0.02 而非 0.035 ！

bank1.calculateInterest(10000);                     // 输出 350 (CommercialBank 的方法)
```

| 元素 | 绑定方式 | 看的是？ |
|:---|:---|:---|
| **方法** | 运行时多态 | 实际对象类型（动态） |
| **字段** | 编译期绑定 | 引用声明类型（静态） |

> **铁律**：字段**不参与多态**！这是 Java 继承中最大的陷阱之一。

## 测试用例对照

| 测试 | 关键操作 | 预期 |
|:---|:---|:---:|
| `test1` | `centralBank.calculateInterest(10000)` | 350.0（多态：调到 CommercialBank.calculateInterest） |
| `test2` | `new CentralBank().calculateInterest(10000)` | 200.0 |
| `test3` | `new CommercialBank().calculateInterest(10000)` | 350.0 |
| `test4` | 综合：deposit 500 + withdraw 2000、addInterest、透支 -400 | 1500.0 / 535.0 / -400.0 |

### test4 关键计算

```
账户初始 1000
deposit(500)   → 1500
withdraw(2000) → 余额不够 → 仍 1500 ✓

SavingsAccount 初始 1000，利率 0.035
addInterest()  → 1000 × 1.035 = 1035
withdraw(500)  → 535 ✓

CheckingAccount 初始 1000，透支上限 500
withdraw(1400) → 1400 ≤ 1000 + 500 → 余额 -400 ✓
```

## 完型填空说明

| 文件 | 关键填空 |
|:---|:---|
| `Account.java` | `deposit / withdraw / getBalance` |
| `SavingsAccount.java` | `addInterest()` |
| `CheckingAccount.java` | `overdraftLimit` 字段 + 覆盖 `withdraw` |
| `CentralBank.java` | `accounts[10]` 数组 + 5 个方法 |
| `CommercialBank.java` | `interestRate = 0.035`（**字段隐藏**）+ `calculateInterest` 覆盖 + `addInterest()` |

## 提交方式

```bash
cd 03-BankAccount
mvn test
```

测试包含 4 个明测试 + 16 个暗测试。
