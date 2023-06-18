package movieRentalServiceImpl;

import movieRentalService.RentCalculation;

public class ChidrenMovieRent implements RentCalculation {

	@Override
	public double calculateRent(int days) {
		// TODO Auto-generated method stub
		double thisAmount = 1.5;
		if (days > 3) {
	          thisAmount = ((days - 3) * 1.5) + thisAmount;
	          return thisAmount;
	    }
		
		return 0;
	}

}
