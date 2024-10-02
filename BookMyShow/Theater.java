package BookMyShow;

import BookMyShow.Enum.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Theater {
	int id;
	String address;
	City city;
	List<Screen> allScreens;
	List<Show> allShows;

	public Theater(int id, String address)
	{
		this.id = id;
		this.address = address;
		this.allScreens = new ArrayList<>();
		this.allShows = new ArrayList<>();
	}
}
