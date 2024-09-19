package ATM.States;

import ATM.*;

public class BalanceCheckState extends ATMState
{
	@Override
	void checkBalance(ATM atm, Card card, Integer pin) {
		if(card.validatePin(pin))
		{

		}
	}
}
