package ATM.CashWithdrawalSystem;

import ATM.ATM;

public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{
	public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
		super(nextCashWithdrawalProcessor);
	}

	@Override
	public void withdraw(ATM atm, int amount) {
		int totalNotes = amount/500;
		int remainder = amount;
		if((amount >= 500) && (atm.getTwoThousandRupeeNotes() >= totalNotes))
		{
			remainder %= 500;
			System.out.println("500 rupee note: " + totalNotes);
		}

		if (remainder > 0)
		{
			super.withdraw(atm, remainder);
		}
	}
}
