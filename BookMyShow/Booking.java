package BookMyShow;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Booking {
	int id;
	List<Seat> seats;
	Payment payment;
}
