package ATM.States;

import ATM.*;


public class IdleState extends ATMState {

	void insertCard(ATM atm, Card card)
	{
		System.out.println("Welcome : " + card.getCardHolderName());
	}
}
