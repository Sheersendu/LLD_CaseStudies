package BookMyShow;

import BookMyShow.Enum.City;
import BookMyShow.Enum.PaymentStatus;
import BookMyShow.Enum.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.abs;

public class BookMyShow {
	MovieController movieController;
	TheaterController theaterController;
	Random rand;
	public BookMyShow()
	{
		this.movieController = new MovieController();
		this.theaterController = new TheaterController();
		rand = new Random();
		initialize();
	}

	public static void main(String[] args) {
		BookMyShow bookMyShow = new BookMyShow();
		bookMyShow.createBooking("HYDERABAD", "Movie 1");
	}

	public void createBooking(String city, String movieName)
	{
		// City and Movie Selection
		Movie userSelectedMovie = this.movieController.getMovieByName(movieName);
		City userSelectedCity = City.valueOf(city);
		List<Movie> availableMovies = this.movieController.getMovieByCity(userSelectedCity);
		for(Movie movie: availableMovies) {
			System.out.println(movie.getName());
		}
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

		// Theater selection
		Map<Theater, List<Show>> theaterWiseShows = this.theaterController.getAllShows(userSelectedCity, userSelectedMovie);
		for(Theater theater: theaterWiseShows.keySet())
		{
			System.out.println(theater.id);
			for(Show show: theaterWiseShows.get(theater))
			{
				System.out.println(show.movie.getName() + " - " + show.getScreen().getId() + " - " + show.getShowStartTime());
			}
			System.out.println("************************");
		}
		Theater userSelectedTheater = this.theaterController.allTheaters.getFirst();

		// Show Selection
		Show userSelectedShow = userSelectedTheater.getAllShows().getFirst();

		// Seat selection
		int rowNumber = 1;
		List<Integer> getAllBookedSeats = userSelectedShow.getBookedSeatIds();
		if(getAllBookedSeats.contains(rowNumber))
		{
			throw new RuntimeException("Seat already booked!");
		}
		// Booking
		else
		{
			List<Seat> allSeats = userSelectedShow.getScreen().getAllSeats();
			for(Seat seat: allSeats) {
				if(seat.getId() == rowNumber)
				{
					System.out.println(seat.getSeatCategory().toString());
					Payment payment = new Payment(101, PaymentStatus.SUCCESS);
					Booking booking = new Booking(abs(rand.nextInt()), List.of(seat), payment);
					userSelectedShow.getBookedSeatIds().add(rowNumber);
					System.out.println(booking.id);
					System.out.println("Booking successful!");
				}
			}
		}

		// Seat selection
		int rowNumber1 = 19;
		List<Integer> getAllBookedSeats1 = userSelectedShow.getBookedSeatIds();
		if(getAllBookedSeats1.contains(rowNumber1))
		{
			throw new RuntimeException("Seat already booked!");
		}
		// Booking
		else
		{
			List<Seat> allSeats = userSelectedShow.getScreen().getAllSeats();
			for(Seat seat: allSeats) {
				if(seat.getId() == rowNumber1)
				{
					System.out.println(seat.getSeatCategory().toString());
					Payment payment = new Payment(101, PaymentStatus.SUCCESS);
					Booking booking = new Booking(rand.nextInt(), List.of(seat), payment);
					userSelectedShow.getBookedSeatIds().add(rowNumber1);
					System.out.println(booking.id);
					System.out.println("Booking successful!");
				}
			}
		}

	}

	private void initialize()
	{
		createMovies();
		createTheaters();
	}

	private void createMovies()
	{
		// Movies
		Movie movie1 = new Movie(1, "Movie 1", 120);
		Movie movie2 = new Movie(2, "Movie 2", 185);
		Movie movie3 = new Movie(3, "Movie 3", 139);

		// map to cities
		this.movieController.addMovie(City.BANGALORE, movie1);
		this.movieController.addMovie(City.BANGALORE, movie3);
		this.movieController.addMovie(City.KOLKATA, movie2);
		this.movieController.addMovie(City.BANGALORE, movie3);
		this.movieController.addMovie(City.HYDERABAD, movie1);
		this.movieController.addMovie(City.HYDERABAD, movie2);
	}

	private void createTheaters()
	{
		// Theaters
		Theater theater1 = new Theater(1, "Somewhere in the city");
		this.theaterController.addTheater(City.BANGALORE, theater1);
		theater1.setAllScreens(createScreens(2));
		List<Show> theater1Shows = new ArrayList<>();
		List<Movie> theater1AllMovies = this.movieController.getMovieByCity(theater1.getCity());
		List<Screen> theater1AllScreens = theater1.getAllScreens();
		for(int index = 1; index <= theater1AllMovies.size(); index++)
		{
			Movie movie = theater1AllMovies.get(index-1);
			theater1Shows.add(new Show(index, movie, theater1AllScreens.getFirst(), 10));
			theater1Shows.add(new Show(index, movie, theater1AllScreens.getLast(), 18));
		}
		theater1.setAllShows(theater1Shows);

		Theater theater2 = new Theater(2, "Somewhere in the city");
		this.theaterController.addTheater(City.BANGALORE, theater2);
		theater2.setAllScreens(createScreens(2));
		List<Show> theater2Shows = new ArrayList<>();
		List<Movie> theater2AllMovies = this.movieController.getMovieByCity(theater2.getCity());
		List<Screen> theater2AllScreens = theater2.getAllScreens();
		for(int index = 1; index <= theater2AllMovies.size(); index++)
		{
			Movie movie = theater2AllMovies.get(index-1);
			theater2Shows.add(new Show(index, movie, theater2AllScreens.getFirst(), 10));
			theater2Shows.add(new Show(index, movie, theater2AllScreens.getLast(), 18));
		}
		theater2.setAllShows(theater2Shows);

		Theater theater3 = new Theater(1, "Somewhere in the city");
		this.theaterController.addTheater(City.KOLKATA, theater3);
		theater3.setAllScreens(createScreens(2));
		List<Show> theater3Shows = new ArrayList<>();
		List<Movie> theater3AllMovies = this.movieController.getMovieByCity(theater3.getCity());
		List<Screen> theater3AllScreens = theater3.getAllScreens();
		for(int index = 1; index <= theater3AllMovies.size(); index++)
		{
			Movie movie = theater3AllMovies.get(index-1);
			theater3Shows.add(new Show(index, movie, theater3AllScreens.getFirst(), 10));
			theater3Shows.add(new Show(index, movie, theater3AllScreens.getLast(), 18));
		}
		theater3.setAllShows(theater3Shows);

		Theater theater4 = new Theater(2, "Somewhere in the city");
		this.theaterController.addTheater(City.KOLKATA, theater4);
		theater4.setAllScreens(createScreens(2));
		List<Show> theater4Shows = new ArrayList<>();
		List<Movie> theater4AllMovies = this.movieController.getMovieByCity(theater4.getCity());
		List<Screen> theater4AllScreens = theater4.getAllScreens();
		for(int index = 1; index <= theater4AllMovies.size(); index++)
		{
			Movie movie = theater4AllMovies.get(index-1);
			theater4Shows.add(new Show(index, movie, theater4AllScreens.getFirst(), 10));
			theater4Shows.add(new Show(index, movie, theater4AllScreens.getLast(), 18));
		}
		theater4.setAllShows(theater4Shows);

		Theater theater5 = new Theater(1, "Somewhere in the city");
		this.theaterController.addTheater(City.HYDERABAD, theater5);
		theater5.setAllScreens(createScreens(2));
		List<Show> theater5Shows = new ArrayList<>();
		List<Movie> theater5AllMovies = this.movieController.getMovieByCity(theater5.getCity());
		List<Screen> theater5AllScreens = theater5.getAllScreens();
		for(int index = 1; index <= theater5AllMovies.size(); index++)
		{
			Movie movie = theater5AllMovies.get(index-1);
			theater5Shows.add(new Show(index, movie, theater5AllScreens.getFirst(), 10));
			theater5Shows.add(new Show(index, movie, theater5AllScreens.getLast(), 18));
		}
		theater5.setAllShows(theater5Shows);
	}

	private List<Screen> createScreens(int totalNumberOfScreens)
	{
		List<Screen> screens = new ArrayList<>();
		for(int index = 1; index<= totalNumberOfScreens; index++)
		{
			Screen screen = new Screen();
			screen.setId(index);
			int totalSeats = (rand.nextInt()%10)+10;
			screen.setAllSeats(createSeats(totalSeats));
			screens.add(screen);
		}
		return screens;
	}

	private List<Seat> createSeats(int totalSeats)
	{
		List<Seat> seats = new ArrayList<>();
		int platinumSeats = 4;
		int goldSeats = 6;
		int rowNumber = 1;
		for(int index = 1; index <= platinumSeats; index++)
		{
			Seat seat = new Seat(index, rowNumber, SeatCategory.PLATINUM, 300);
			seats.add(seat);
			rowNumber+=1;
		}
		for(int index = 1+platinumSeats; index<= goldSeats+platinumSeats; index++)
		{
			Seat seat = new Seat(index, rowNumber, SeatCategory.GOLD, 200);
			seats.add(seat);
			rowNumber+=1;
		}
		for(int index = 1+platinumSeats+goldSeats; index<= totalSeats; index++)
		{
			Seat seat = new Seat(index, rowNumber, SeatCategory.SILVER, 100);
			seats.add(seat);
			rowNumber+=1;
		}
		return seats;
	}

}
