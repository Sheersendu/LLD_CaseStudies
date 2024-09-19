package ATM.States;

import ATM.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CashDepositState extends ATMState {

	@Override
	void depositMoney(ATM atm, Card card) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> userInputNotes = new ArrayList<>();
		System.out.println("Please enter total number of currency bills");
		int totalNotes = scanner.nextInt();
		int totalAmount = 0;
		while(totalNotes>0)
		{
			int note = scanner.nextInt();
			userInputNotes.add(note);
			totalAmount += note;
			totalNotes -= 1;
		}
		atm.addMoney(userInputNotes);
		card.getBankAccount().depositMoney(totalAmount);
		super.exit(atm);
	}
}
