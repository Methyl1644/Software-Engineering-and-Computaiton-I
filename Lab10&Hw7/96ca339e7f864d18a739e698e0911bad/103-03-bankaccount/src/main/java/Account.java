class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        //todo: 实现存款 — 把 amount 加到 balance
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        //todo: 实现取款 — 仅在 amount <= balance 时扣款；否则不变
    }

    public double getBalance() {
        //todo: 返回当前余额
        return balance;
    }
}
