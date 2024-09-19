package ATM.States;

import ATM.*;
import ATM.CashWithdrawalSystem.*;

import java.util.Scanner;

public class CashWithdrawalState extends ATMState {
	@Override
	void withdrawMoney(ATM atm, Card card, Integer amount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Pin: ");
		int userPin = scanner.nextInt();
		if (card.validatePin(userPin))
		{
			if(card.getBankAccount().getBalance() < amount)
			{
				System.out.println("Insufficient account balance!");
			}
			else
			{
				CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandWithdrawalProcessor(new FiveHundredWithdrawalProcessor(new TwoHundredWithdrawalProcessor(new HundredWithdrawalProcessor(null))));
				cashWithdrawalProcessor.withdraw(atm, amount);
				card.getBankAccount().withdrawMoney(amount);
				System.out.println("Your available balance is: " + card.getBankAccount().getBalance());
			}
		}
		else {
			System.out.println("Invalid Pin!");
		}
		super.exit(atm);
	}
}
