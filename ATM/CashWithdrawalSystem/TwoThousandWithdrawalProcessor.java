package ATM.CashWithdrawalSystem;

import ATM.ATM;

public class TwoThousandWithdrawalProcessor extends CashWithdrawalProcessor{
	public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
		super(nextCashWithdrawalProcessor);
	}

	@Override
	public void withdraw(ATM atm, int amount) {
		int totalNotes = amount/2000;
		int remainder = amount;
		if((amount >= 2000) && (atm.getTwoThousandRupeeNotes() >= totalNotes))
		{
			remainder %= 2000;
			System.out.println("2000 rupee note: " + totalNotes);
		}

		if (remainder > 0)
		{
			super.withdraw(atm, remainder);
		}
	}
}
