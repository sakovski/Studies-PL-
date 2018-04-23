import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadraticFunctionTest {
	
	private QuadraticFunction function;
	private static final double EPSILON = 0.01;
	private int a = 1;
	private int b = 2;
	private int c = -3;
	
	@Before
	public void setUp() {
		function = QuadraticFunction.of(a,b,c);
	}
	
	@Test
	public void getATest() {
		assertEquals(a, function.getA(), EPSILON);
	}
	
	@Test
	public void getBTest() {
		assertEquals(b, function.getB(), EPSILON);
	}
	
	@Test
	public void getCTest() {
		assertEquals(c, function.getC(), EPSILON);
	}
	
	@Test
	public void getX1Test() {
		assertEquals(-3, function.getX1(), EPSILON);
	}
	
	@Test
	public void getX2Test() {
		assertEquals(1, function.getX2(), EPSILON);
	}
	
	@Test
	public void deltaZeroX1Test() {
		function = QuadraticFunction.of(1,2,1);
		assertEquals(-1, function.getX1(), EPSILON);
	}
	
	@Test
	public void deltaZeroX2Test() {
		function = QuadraticFunction.of(1,2,1);
		assertEquals(-1, function.getX2(), EPSILON);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deltaLessThanZeroTest() {
		function = QuadraticFunction.of(1, 1, 5);
		assertNull(function.getX2());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentsZerosTest() {
		function = QuadraticFunction.of(0, 0, 0);
		assertNull(function.getX2());
	}
	
	@Test
	public void AZeroTest() {
		function = QuadraticFunction.of(0, 5, 3);
		assertEquals(-0.6, function.getX1(), EPSILON);
	}
	
	@Test
	public void BZeroTest() {
		function = QuadraticFunction.of(3, 0, -3);
		assertEquals(-1, function.getX1(), EPSILON);
		assertEquals(1, function.getX2(), EPSILON);
	}
	
	@Test
	public void CZeroTest() {
		function = QuadraticFunction.of(3, 7, 0);
		assertEquals(-2.33, function.getX1(), EPSILON);
		assertEquals(0, function.getX2(), EPSILON);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void OnlyCNotZeroTest() {
		function = QuadraticFunction.of(0, 0, 6);
		assertNull(function.getX1());
	}
	
	@After
	public void tearDown() {
		function = null;
	}


}
