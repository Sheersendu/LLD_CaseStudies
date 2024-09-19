package ATM;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Card {
	String cardNumber;
	@Setter
	Integer pin;
	Integer cvv;
	String cardHolderName;

	public boolean validatePin(int pin)
	{
		return this.pin == pin;
	}
}
