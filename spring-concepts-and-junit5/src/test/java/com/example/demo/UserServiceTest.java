package com.example.demo;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//@ExtendWith(SpringExtension.class) //intigrates spring testcontext into junit5
//@ExtendWith(MockitoExtension.class) //equivalent of junit5 MockitoJUnitRunner class
@SpringBootTest
public class UserServiceTest {

	@MockBean
	private UserRepository userRepositoryMock;

	@Autowired
	private UserService userService;

	@BeforeAll
	public static void setUpMethod(){
		System.out.println("Runs once before running any test ");
		//1. get api key required for all methods
		//2. instantiate singleton connection object
		//3. create list of object used as actual input required in variaous tests
		List<User> list = new ArrayList<>();
		list.add(new User());
	}

	@AfterAll
	public  static void cleanupMthod(){
		//connection.close()
		List<User> list = null;
	}

	@RepeatedTest(2)
	public void testSum(){
		boolean res = userService.isEven(5);
		Assertions.assertEquals(false, res);
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 8})
	public void testSumWithData(Integer n){
		Assertions.assertTrue(userService.isEven(n));
    }

	@Test
	@DisplayName("Should test find user by Id")
	public void testFindUserById() {
		// Create a mock user object
		User mockUser = new User();
		mockUser.setId(20L);
		//mockUser.setEmail("test@example.com");
		mockUser.setPassword("password");
		// Set up the mock behavior for the UserRepository findById() method
		Mockito.when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(mockUser));
		// Call the UserService method
		User user = userService.getUserById(1);
		// Verify that the UserRepository findById() method was called once with the correct argument
		Mockito.verify(userRepositoryMock, Mockito.times(1)).findById(1L);
		// assert that expected and actual are equal
		Assertions.assertEquals(mockUser, user);
	}

	@Test
	public void testFindUserByIdFail() {
		User mockUser = new User();
		mockUser.setId(1L);
		mockUser.setPassword("password");
		Assertions.assertThrows(ResourceNotFoundException.class, () -> { userService.getUserById(0);});
	}


}