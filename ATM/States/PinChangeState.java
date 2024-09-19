package ATM.States;

import ATM.*;

public class PinChangeState extends ATMState {
	@Override
	void changePin(ATM atm, Card card, Integer OlderPin, Integer newPin) {
		if(card.validatePin(OlderPin))
		{
			card.setPin(newPin);
			System.out.println("Pin reset successfully!");
		}
		else {
			System.out.println("Incorrect Pin!");
		}
		super.exit(atm);
	}
}
