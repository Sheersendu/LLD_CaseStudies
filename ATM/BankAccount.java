package ATM;

import lombok.Getter;

@Getter
public class BankAccount {
	private int balance;

	public void depositMoney(int amount)
	{
		this.balance += amount;
	}

	public void withdrawMoney(int amount)
	{
		this.balance -= amount;
	}
}
