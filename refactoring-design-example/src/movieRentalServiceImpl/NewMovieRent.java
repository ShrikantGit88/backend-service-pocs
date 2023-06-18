package movieRentalServiceImpl;

import movieRentalService.RentCalculation;

public class NewMovieRent implements RentCalculation {

	@Override
	public double calculateRent(int days) {
		// TODO Auto-generated method stub
		return days * 3;
	}

}
