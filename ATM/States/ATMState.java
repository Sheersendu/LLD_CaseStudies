package ATM.States;

import ATM.ATM;

public abstract class ATMState {

	void IdleState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void HasCardState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}
	
	void PinAuthenticationState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void SelectionState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void CashWithdrawalState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void CheckBalanceState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void PinChangeState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}

	void ExitState(ATM atm)
	{
		System.out.println("Oops! Something went wrong!");
	}
}
