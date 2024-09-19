package ATM.CashWithdrawalSystem;

import ATM.ATM;

public class TwoHundredWithdrawalProcessor extends CashWithdrawalProcessor{
	public TwoHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
		super(nextCashWithdrawalProcessor);
	}

	@Override
	public void withdraw(ATM atm, int amount) {
		int totalNotes = amount/200;
		int remainder = amount;
		if((amount >= 200) && (atm.getTwoThousandRupeeNotes() >= totalNotes))
		{
			remainder %= 200;
			System.out.println("200 rupee note: " + totalNotes);
		}

		if (remainder > 0)
		{
			super.withdraw(atm, remainder);
		}
	}
}
