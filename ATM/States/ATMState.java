package ATM.States;

import ATM.*;

public abstract class ATMState {

	void insertCard(ATM atm, Card card)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void selectOperation(ATM atm, Card card)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void withdrawMoney(ATM atm, Card card, Integer amount)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void depositMoney(ATM atm, Card card)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void checkBalance(ATM atm, Card card, Integer pin)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void changePin(ATM atm, Card card, Integer OlderPin, Integer newPin)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void exit(ATM atm)
	{
		System.out.println("Please collect your card!");
		atm.setAtmState(new IdleState());
	}
}
