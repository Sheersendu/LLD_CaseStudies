package ATM.CashWithdrawalSystem;

import ATM.ATM;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CashWithdrawalProcessor {
	CashWithdrawalProcessor nextCashWithdrawalProcessor;

	public void withdraw(ATM atm, int amount)
	{
		if(nextCashWithdrawalProcessor != null)
		{
			nextCashWithdrawalProcessor.withdraw(atm, amount);
		}
	}
}
