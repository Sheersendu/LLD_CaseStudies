package ATM;

import ATM.States.ATMState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ATM {
	private ATMState atmState;
	private int amount;
	private int twoThousandRupeeNotes;
	private int fiveHundredRupeeNotes;
	private int twoHundredRupeeNotes;
	private int oneHundredRupeeNotes;

	public void addMoney(List<Integer> notes) {
		for(int i = 0; i < notes.size(); i++)
		{
			int note = notes.get(i);
			if (note == 2000)
			{
				this.amount += 2000;
				this.twoThousandRupeeNotes += 1;
			}
			if (note == 500)
			{
				this.amount += 500;
				this.fiveHundredRupeeNotes += 1;
			}
			if (note == 200)
			{
				this.amount += 200;
				this.twoThousandRupeeNotes += 1;
			}
			if (note == 100)
			{
				this.amount += 100;
				this.oneHundredRupeeNotes += 1;
			}
		}
	}
}
