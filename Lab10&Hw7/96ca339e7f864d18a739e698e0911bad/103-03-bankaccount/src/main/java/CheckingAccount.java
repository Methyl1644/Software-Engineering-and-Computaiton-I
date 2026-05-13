class CheckingAccount extends Account {
    //todo: 增加必要字段 overdraftLimit（透支上限）
    private double overdraftLimit;

    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        //todo: 实现取款 — 仅在 amount <= balance + overdraftLimit 时扣款；否则余额不变
        if (amount <= balance + overdraftLimit) balance = balance - amount;
    }
}
