package ATM.CashWithdrawalSystem;

import ATM.ATM;

public class HundredWithdrawalProcessor extends  CashWithdrawalProcessor{
	public HundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
		super(nextCashWithdrawalProcessor);
	}

	@Override
	public void withdraw(ATM atm, int amount) {
		int totalNotes = amount/100;
		int remainder = amount;
		if((amount >= 100) && (atm.getTwoThousandRupeeNotes() >= totalNotes))
		{
			remainder %= 100;
			System.out.println("100 rupee note: " + totalNotes);
		}

		if (remainder > 0)
		{
			super.withdraw(atm, remainder);
		}
	}
}
