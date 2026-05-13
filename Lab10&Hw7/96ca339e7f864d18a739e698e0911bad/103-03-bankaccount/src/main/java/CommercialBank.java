public class CommercialBank extends CentralBank {
    //todo: 增加必要字段 interestRate（商业银行利率 0.035）
    public double interestRate = 0.035;

    public double calculateInterest(double amount) {
        //todo: 用本行利率算 amount 的利息（覆盖父类 calculateInterest）

        return amount * interestRate;
    }

    public void addInterest() {
        for (int i = 0; i < accounts.length;i++){
            if (accounts[i] instanceof SavingsAccount){
                ((SavingsAccount) accounts[i]).addInterest();
            }
        }
        //todo: 给 accounts 中所有 SavingsAccount 加利息（提示：用 instanceof 筛选）
    }
}
