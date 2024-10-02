package BookMyShow;

import BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
	Map<City, List<Theater>> cityToTheaterMap;
	List<Theater> allTheaters;

	public TheaterController()
	{
		this.cityToTheaterMap = new HashMap<>();
		this.allTheaters = new ArrayList<>();
	}
	public void addTheater(City city, Theater theater)
	{
		allTheaters.add(theater);
		List<Theater> theaters = cityToTheaterMap.getOrDefault(city, new ArrayList<>());
		theaters.add(theater);
		cityToTheaterMap.put(city, theaters);
		theater.setCity(city);
	}

	public Map<Theater, List<Show>> getAllShows(City city, Movie movie)
	{
		List<Theater> theaterList = this.cityToTheaterMap.get(city);
		Map<Theater, List<Show>> allShows = new HashMap<>();
		for(Theater theater: theaterList)
		{
			List<Show> movieShows = new ArrayList<>();
			List<Show> theaterAllShows = theater.getAllShows();
			for(Show show: theaterAllShows)
			{
				if(show.movie.getId() == movie.getId())
				{
					movieShows.add(show);
				}
			}
			allShows.put(theater, movieShows);
		}
		return allShows;
	}
}
