class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        //todo: 给当前余额加利息（balance += balance × interestRate）
        balance += balance * interestRate;
    }
}
