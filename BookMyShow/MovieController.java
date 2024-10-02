package BookMyShow;

import BookMyShow.Enum.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City, List<Movie>> cityToMovieMap;
	List<Movie> allMovies;

	public MovieController()
	{
		this.cityToMovieMap = new HashMap<>();
		this.allMovies = new ArrayList<>();
	}
	
	public void addMovie(City city, Movie movie)
	{
		this.cityToMovieMap.getOrDefault(city, new ArrayList<>()).add(movie);
		System.out.println(this.cityToMovieMap.get(city));
		this.allMovies.add(movie);
	}

	public Movie getMovieByName(String movieName)
	{
		for(Movie movie : allMovies)
		{
			if (movie.getName().equals(movieName)){
				return movie;
			}
		}
		return null;
	}

	public List<Movie> getMovieByCity(City city)
	{
		return this.cityToMovieMap.get(city);
	}
}
