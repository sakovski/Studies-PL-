import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class QuadraticFunctionTest {
	
	private static final double EPSILON = 0.01;
	private QuadraticFunction function;
	
	@Test
	@FileParameters("src/test/resources/test.csv")
	public void QuadraticCsvTest(double x1, double x2, double a, double b, double c) {
		function = QuadraticFunction.of(a, b, c);
	    assertEquals(x1, function.getX1(), EPSILON);
	    assertEquals(x2, function.getX2(), EPSILON);
	}

}
