package BookMyShow;

import BookMyShow.Enum.SeatCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Seat {
	int id;
	int row;
	SeatCategory seatCategory;
	int price;
}
