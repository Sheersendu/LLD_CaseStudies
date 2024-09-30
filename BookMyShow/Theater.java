package BookMyShow;

import BookMyShow.Enum.City;
import lombok.Getter;

import java.util.List;

@Getter
public class Theater {
	int id;
	String address;
	City city;
	List<Screen> allScreens;
	List<Show> allShows;
}
