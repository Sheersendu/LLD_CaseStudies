package BookMyShow;

import BookMyShow.Enum.City;

import java.util.List;
import java.util.Map;

public class BookMyShow {
	MovieController movieController;
	TheaterController theaterController;
	public BookMyShow()
	{
		this.movieController = new MovieController();
		this.theaterController = new TheaterController();
	}

	public void createBooking(String city, String movieName)
	{
		Movie userSelectedMovie = this.movieController.getMovieByName(movieName);
		City userSelectedCity = City.valueOf(city);
		List<Movie> availableMovies = this.movieController.getMovieByCity(userSelectedCity);
		boolean movieAvailableInUserCity = false;
		for(Movie movie: availableMovies) {
			if(movie.getId() == userSelectedMovie.getId())
			{
				movieAvailableInUserCity = true;
				break;
			}
		}
		if(!movieAvailableInUserCity)
		{
			throw new RuntimeException("Movie not available in " + city);
		}
		Map<Theater, List<Show>> TheaterWiseShows = this.theaterController.getAllShows(userSelectedCity, userSelectedMovie);
		Theater userSelectedTheater = this.theaterController.allTheaters.getFirst();
		

	}
}
