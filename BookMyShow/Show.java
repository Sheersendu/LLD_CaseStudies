package BookMyShow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Show {
	int id;
	Movie movie;
	Screen screen;
	int showStartTime;
	List<Integer> bookedSeatIds;

	public Show(int id, Movie movie, Screen screen, int showStartTime)
	{
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.showStartTime = showStartTime;
		this.bookedSeatIds = new ArrayList<>();
	}
}
