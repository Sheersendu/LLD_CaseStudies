package ATM.States;

import ATM.*;

import java.util.Scanner;

public class HasCardState extends ATMState {

	@Override
	public void selectOperation(ATM atm, Card card) {
		System.out.println("Please choose your operation: \n 1. Cash Withdrawal\n 2. Cash Deposit\n 3. Balance Check\n 4. Pin Change");
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();
		if (userInput == 1) {
			atm.setAtmState(new CashWithdrawalState());
		} else if (userInput == 2) {
			atm.setAtmState(new CashDepositState());
		} else if (userInput == 3) {
			atm.setAtmState(new BalanceCheckState());
		} else if (userInput == 4) {
			atm.setAtmState(new PinChangeState());
		} else {
			super.exit(atm);
		}
	}
}
