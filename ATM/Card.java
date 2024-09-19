package ATM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Card {
	String cardNumber;
	@Setter
	Integer pin;
	Integer cvv;
	BankAccount bankAccount;

	public boolean validatePin(int pin)
	{
		return this.pin == pin;
	}
}
