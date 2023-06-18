package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class) //equivalent of junit5 MockitoJUnitRunner class
@SpringBootTest
public class UserServiceMockitoExtentionTest {

	@Mock
	private MyUtility myUtility;

	@Test
	@DisplayName("Should test Static Method")
	public void testSampleStaticMethod() {
		// Create a mock user object
		try(MockedStatic<MyUtility> mockedStatic = Mockito.mockStatic(MyUtility.class, Mockito.CALLS_REAL_METHODS)) {
			mockedStatic.when(() -> MyUtility.sampleStaticMethod()).thenReturn("abcd");
			String actualResult = MyUtility.sampleStaticMethod();
			String expected = "abcd";

			Assertions.assertEquals(expected, actualResult);
		}
	}

	@Test
	@DisplayName("Should test Final Method")
	public void testSampleFinalMethod() {
		// Create a mock user object
		try(MockedStatic<MyUtility> mockedStatic = Mockito.mockStatic(MyUtility.class, Mockito.CALLS_REAL_METHODS)) {
			mockedStatic.when(() -> myUtility.sampleFinalMethod()).thenReturn("XYZ");
			String actualResult = myUtility.sampleFinalMethod();
			String expected = "XYZ";

			Assertions.assertEquals(expected, actualResult);
		}
	}

	@Test
	@DisplayName("Should test void method")
	public void testVoidMethod(){
		Mockito.doNothing().when(myUtility).sampleVoid();
		myUtility.sampleVoid();
		//verify that the void method was called
		Mockito.verify(myUtility, Mockito.times(1)).sampleVoid();
	}

//	@Test
//	@DisplayName("Should test private method")
//	public void testPrivateMethod(){
//		//create spy object
//		MyUtility myUtilitySpy = Mockito.spy(new MyUtility());
//		// mock private method
//		Mockito.doReturn("mocked value").when(myUtilitySpy, "myPrivateMethod", ArgumentMatchers.anyString());
//	}

}