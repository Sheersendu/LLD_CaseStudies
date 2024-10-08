package ATM.States;

import ATM.*;

public class BalanceCheckState extends ATMState
{
	@Override
	public void checkBalance(ATM atm, Card card, Integer pin) {
		if(card.validatePin(pin))
		{
			System.out.println("Your account balance is Rs. " + card.getBankAccount().getBalance());
		}
		else {
			System.out.println("Incorrect pin!");
		}
		super.exit(atm);
	}
}
