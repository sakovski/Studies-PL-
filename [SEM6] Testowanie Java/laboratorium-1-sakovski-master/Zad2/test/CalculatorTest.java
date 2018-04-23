import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void add_test() {
		int a = 5;
		int b = 10;
		int result = calculator.add(a, b);
		assertEquals(15,result);
	}
	
	@Test
	public void sub_test() {
		int a = 5;
		int b = 10;
		int result = calculator.sub(a, b);
		assertEquals(-5,result);
	}
	
	@Test
	public void multi_test() {
		int a = 5;
		int b = 10;
		int result = calculator.multi(a, b);
		assertEquals(50,result);
	}
	
	@Test
	public void multi_zero_test() {
		int a = 5;
		int b = 0;
		int result = calculator.multi(a, b);
		assertEquals(0,result);
	}
	
	@Test
	public void div_test() {
		int a = 5;
		int b = 10;
		int result = calculator.div(b, a);
		assertEquals(2,result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void div_zero_test() {
		int a = 5;
		int b = 0;
		int result = calculator.div(a, b);
		assertNull(result);
	}
	
	@Test
	public void greater_test() {
		int a = 5;
		int b = 10;
		boolean result = calculator.greater(a, b);
		assertFalse(result);
	}
	
	@Test
	public void less_test() {
		int a = 5;
		int b = 10;
		boolean result = calculator.less(a, b);
		assertTrue(result);
	}
	
	@Test
	public void equality_test1() {
		int a = 10;
		int b = 10;
		boolean result = calculator.equality(a, b);
		assertTrue(result);
	}
	
	@Test
	public void equality_test2() {
		int a = 5;
		int b = 10;
		boolean result = calculator.equality(a, b);
		assertFalse(result);
	}
	
	@After
	public void tearDown() {
		calculator = null;
	}	
}
