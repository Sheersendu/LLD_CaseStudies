package ATM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	String name;
	Card card;
	BankAccount bankAccount;
}
