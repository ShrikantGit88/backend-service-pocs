package movieRentalServiceImpl;

import movieRentalService.RentCalculation;

public class RegularMovieRent implements RentCalculation {

	@Override
	public double calculateRent(int days) {
		// TODO Auto-generated method stub
		if (days > 2) {
	          return ((days - 2) * 1.5) +2 ;
	    }
		return 2;
	}

}
