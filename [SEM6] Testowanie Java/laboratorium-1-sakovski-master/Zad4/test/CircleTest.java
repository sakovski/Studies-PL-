import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest {
	
	private static final double EPSILON = 0.1;
	
	@Test
	public void circumfence_5_test() {
		Circle c = new Circle(5); 
		double result = c.circumfence(c);
		assertEquals(31.4, result, EPSILON);
	}
	
	@Test
	public void poleCircle_5_test() {
		Circle c = new Circle(5); 
		double result = c.poleCircle(c);
		assertEquals(78.5, result, EPSILON);
	}

}
