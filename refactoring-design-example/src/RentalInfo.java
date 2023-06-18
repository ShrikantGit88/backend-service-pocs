import java.util.HashMap;
import java.util.Map;
import model.Customer;
import model.Movie;
import model.MovieRental;
import movieRentalService.RentCalculation;
import movieRentalServiceImpl.ChidrenMovieRent;
import movieRentalServiceImpl.NewMovieRent;
import movieRentalServiceImpl.RegularMovieRent;

public class RentalInfo {
	public Map<String, Movie> getAllMovies() {
		HashMap<String, Movie> movies = new HashMap<>();
		movies.put("F001", new Movie("You've Got Mail", "regular"));
		movies.put("F002", new Movie("Matrix", "regular"));
		movies.put("F003", new Movie("Cars", "childrens"));
		movies.put("F004", new Movie("Fast & Furious X", "new"));
		return movies;
	}

    public RentCalculation getInstance(String type) {
        switch (type){
            case "regular":
                return new RegularMovieRent();
            case "new":
                return new NewMovieRent();
            case "childrens":
                return new ChidrenMovieRent();
            default:
                return new RegularMovieRent();
        }
    }


  public String statement(Customer customer) {
	Map<String, Movie> movies = getAllMovies();
    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {
      double thisAmount = 0;
    //add frequent bonus points
      frequentEnterPoints++;
      // determine amount for each movie
        thisAmount = getInstance(movies.get(r.getMovieId()).getCode()).calculateRent(r.getDays());
      if (movies.get(r.getMovieId()).getCode().equals("new")) {        // add bonus for a two day new release rental
        if (r.getDays() > 2) frequentEnterPoints++;
      }
        //print figures for this rental
      result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
      totalAmount = totalAmount + thisAmount;
    }

    return getResult(result, customer, totalAmount, frequentEnterPoints);
  }
  public String getResult(String result, Customer customer, double totalAmount, int frequentEnterPoints ) {
	// add footer lines
	    result += "Amount owed is " + totalAmount + "\n";
	    result += "You earned " + frequentEnterPoints + " frequent points\n";
	    return result;

  }
}
