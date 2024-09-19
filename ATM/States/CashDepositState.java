package ATM.States;

import ATM.ATM;

import java.util.Scanner;

public class CashDepositState extends ATMState {

	@Override
	void depositMoney(ATM atm) {
		System.out.println("Please enter your currency bills");
		Scanner scanner = new Scanner(System.in);
	}
}
