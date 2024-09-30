package BookMyShow;

import lombok.Getter;

import java.util.List;

@Getter
public class Show {
	int id;
	Movie movie;
	Screen screen;
	int showStartTime;
	List<Integer> bookedSeatIds;
}
