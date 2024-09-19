package ATM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
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
