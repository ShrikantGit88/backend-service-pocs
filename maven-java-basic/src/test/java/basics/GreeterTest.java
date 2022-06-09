package basics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class GreeterTest {
	
	private Greeter greeter = new Greeter();
	
	@Test
	public void greeterSayshello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

}
