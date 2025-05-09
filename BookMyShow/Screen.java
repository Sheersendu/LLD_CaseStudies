package BookMyShow;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen {
	int id;
	List<Seat> allSeats;
}
