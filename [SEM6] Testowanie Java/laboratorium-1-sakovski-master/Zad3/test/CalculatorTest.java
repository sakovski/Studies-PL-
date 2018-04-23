import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;
	private static final double EPSILON = 0.01;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void add_test() {
		double a = 5.55;
		double b = 10.0;
		double result = calculator.add(a, b);
		assertEquals(15.55, result, EPSILON);
	}
	
	@Test
	public void sub_test() {
		double a = 5.55;
		double b = 10.0;
		double result = calculator.sub(a, b);
		assertEquals(-4.45, result, EPSILON);
	}
	
	@Test
	public void multi_test() {
		double a = 5.55;
		double b = 10.0;
		double result = calculator.multi(a, b);
		assertEquals(55.5, result, EPSILON);
	}
	
	@Test
	public void multi_zero_test() {
		double a = 5;
		double b = 0;
		double result = calculator.multi(a, b);
		assertEquals(0,result, EPSILON);
	}
	
	@Test
	public void div_test() {
		double a = 5;
		double b = 10;
		double result = calculator.div(a, b);
		assertEquals(0.5,result, EPSILON);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void div_zero_test() {
		double a = 5;
		double b = 0;
		double result = calculator.div(a, b);
		assertNull(result);
	}
	
	@Test
	public void greater_test() {
		double a = 5;
		double b = 10;
		boolean result = calculator.greater(a, b);
		assertFalse(result);
	}
	
	@Test
	public void less_test() {
		double a = 5;
		double b = 10;
		boolean result = calculator.less(a, b);
		assertTrue(result);
	}
	
	@Test
	public void equality_test1() {
		double a = 10;
		double b = 10;
		boolean result = calculator.equality(a, b);
		assertTrue(result);
	}
	
	@Test
	public void equality_test2() {
		double a = 5;
		double b = 10;
		boolean result = calculator.equality(a, b);
		assertFalse(result);
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}

}
