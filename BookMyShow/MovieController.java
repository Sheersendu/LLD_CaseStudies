package BookMyShow;

import BookMyShow.Enum.City;

import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City, List<Movie>> cityToMovieMap;
	List<Movie> allMovies;
	
	public void addMovie(City city, Movie movie)
	{
		this.cityToMovieMap.get(city).add(movie);
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
