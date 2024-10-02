package BookMyShow;

import BookMyShow.Enum.PaymentStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Payment {
	int id;
	PaymentStatus status;
}
