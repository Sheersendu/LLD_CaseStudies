package ATM.States;

import ATM.*;

public class BalanceCheckState extends ATMState
{
	@Override
	void checkBalance(ATM atm, Card card, Integer pin) {
		if(card.validatePin(pin))
		{
			System.out.println("Your account balance is Rs. " + card.getBankAccount().getBalance());
		}
		else {
			System.out.println("Incorrect pin!");
		}
		exit(atm);
	}
}
