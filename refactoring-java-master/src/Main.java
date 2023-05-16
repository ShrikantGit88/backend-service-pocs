import java.util.Arrays;
import java.util.Locale;

import model.Customer;
import model.MovieRental;
class SuperA {
	void superMethod(){
		System.out.println("super method");
	}
}

class SubB extends SuperA {
	void subMethod(){
		System.out.println("subclass method");
	}
}
public class Main {

	public static void main(String[] args) {
		String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

		String result = new RentalInfo().statement(
				new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

		if (!result.equals(expected)) {
			throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected)
					+ System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
		}

		//System.out.println("Success \n" + result);
		SuperA a = new SuperA();
		SubB sb = new SubB();
		SuperA aa = new SubB();
		a = sb;

		byte b = 127;
		int in = 128;
		in = b;

		short sh = 32767;
		sh = (short) (sh + 1); //internal typecasting

		double n = 2.12345679d;
		n = n + 1;

		char c = 'a';
		Locale

		for(int i=0; i<10; i++) {
			System.out.println(c);
			c += 10;
		}
	}
}




