package BookMyShow;

import BookMyShow.Enum.SeatCategory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Seat {
	int id;
	int row;
	SeatCategory seatCategory;
	int price;
}
