package ATM;


import ATM.States.IdleState;

public class ATMRoom {
	ATM atm;
	User user;

	public static void main(String[] args) {
		ATMRoom atmRoom = new ATMRoom();
		BankAccount userBankAccount = new BankAccount(12000);
		Card card = new Card("1", 1234, 101, userBankAccount);
		atmRoom.user.setCard(card);
		atmRoom.user.setBankAccount(userBankAccount);

		atmRoom.atm.getAtmState().insertCard(atmRoom.atm, card);
		atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, card);

		// Successful Withdrawal flow
//		atmRoom.atm.getAtmState().withdrawMoney(atmRoom.atm, card, 1800);

		// Balance Check flow
//		atmRoom.atm.getAtmState().checkBalance(atmRoom.atm, card, 1234);

		// Deposit Money flow
//		atmRoom.atm.getAtmState().depositMoney(atmRoom.atm, card);

		// Pin Change flow
//		atmRoom.atm.getAtmState().changePin(atmRoom.atm, card, 1234, 1345);

		// Failed Withdrawal
//		atmRoom.atm.getAtmState().withdrawMoney(atmRoom.atm, card, 12000);

		atmRoom.atm.getAtmState().withdrawMoney(atmRoom.atm, card, 2800);
	}

	ATMRoom() {
		atm = new ATM(new IdleState(), 10000, 3, 4, 5, 10);
		user = new User("User");
	}
}
