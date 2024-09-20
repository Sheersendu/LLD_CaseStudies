package ATM.States;

import ATM.*;


public class IdleState extends ATMState {

	public IdleState()
	{
		System.out.println("----------------------------");
		System.out.println("Welcome To Banking Services ");
		System.out.println("----------------------------");
	}

	@Override
	public void insertCard(ATM atm, Card card)
	{
		System.out.println("Card is inserted");
		atm.setAtmState(new HasCardState());
	}
}
