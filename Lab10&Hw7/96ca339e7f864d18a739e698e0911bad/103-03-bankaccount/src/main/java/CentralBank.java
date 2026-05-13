public class CentralBank {
    public double interestRate = 0.02;

    //todo: 增加必要字段 accounts 数组（容量 10）
    Account[] accounts = new Account[10];

    public int addAccount(Account account) {
        //todo: 把 account 加入 accounts 数组并返回 account ID（满了返回 -1）
        for (int i = 0;i < 10;i++){
            if (accounts[i] == null){
                accounts[i] = account;
                return i + 1;
            }
        }
        return -1;
    }

    public double calculateInterest(double amount) {
        //todo: 用本行利率算 amount 的利息
        return amount * interestRate;
    }

    public void depositMoney(double amount, int accountID) {
        //todo: 给 accountID 对应的账户存 amount
        if (accountID > 0 && accountID <= accounts.length && accounts[accountID - 1] != null) accounts[accountID - 1].deposit(amount);
    }

    public void withdrawMoney(double amount, int accountID) {
        //todo: 从 accountID 对应的账户取 amount
        if (accountID > 0 && accountID <= accounts.length && accounts[accountID - 1] != null) accounts[accountID - 1].withdraw(amount);
    }

    public double getAccountBalance(int accountID) {
        //todo: 返回 accountID 对应账户的余额
        return accounts[accountID].getBalance() ;
    }
}
