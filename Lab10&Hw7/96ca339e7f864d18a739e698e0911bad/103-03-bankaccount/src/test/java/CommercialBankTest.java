import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CommercialBankTest {
	@Test

	public void test1() {
		CentralBank centralBank = new CommercialBank();

		assertEquals(350.0,centralBank.calculateInterest(10000),0.001);

	}

	

	@Test

	public void test2() {

		CentralBank centralBank2 = new CentralBank();
		System.out.println("Central Bank's interest rate: " + centralBank2.interestRate);
		assertEquals(200.0,centralBank2.calculateInterest(10000),0.001);

	}

	

	@Test

	public void test3() {

		CommercialBank commercialBank = new CommercialBank();
		System.out.println("Commercial Bank's interest rate: " + commercialBank.interestRate);
		assertEquals(350.0,commercialBank.calculateInterest(10000),0.001);

	}

	@Test
	public void test4() {
		CommercialBank commercialBank = new CommercialBank();
		Account account = new Account(1000);
		SavingsAccount savings = new SavingsAccount(1000, commercialBank.interestRate);
		CheckingAccount checking = new CheckingAccount(1000, 500);

		int accountID = commercialBank.addAccount(account);
		int savingsID = commercialBank.addAccount(savings);
		int checkingID = commercialBank.addAccount(checking);


		commercialBank.depositMoney(500, accountID);
		commercialBank.withdrawMoney(2000, accountID);
		System.out.println("Account balance: " + account.getBalance());
		assertEquals(1500.0,account.getBalance(),0.001);


		commercialBank.addInterest();
		commercialBank.withdrawMoney(500, savingsID);
		System.out.println("SavingsAccount balance: " + savings.getBalance());
		assertEquals(535.0,savings.getBalance(),0.001);



		commercialBank.withdrawMoney(1400, checkingID);
		System.out.println("CheckingAccount balance: " + checking.getBalance());
		assertEquals(-400.0,checking.getBalance(),0.001);

	}

}
