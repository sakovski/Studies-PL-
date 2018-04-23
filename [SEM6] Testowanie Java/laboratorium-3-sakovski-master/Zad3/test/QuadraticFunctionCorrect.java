import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class QuadraticFunctionCorrect {
	
	private QuadraticFunction function;
	private double inputA;
	private double inputB;
	private double inputC;
	private double inputX1;
	private double inputX2;
	private static final double EPSILON = 0.01;
	
	public QuadraticFunctionCorrect(double a, double b, double c, double x1, double x2){
		inputA = a;
		inputB = b;
		inputC = c;
		inputX1 = x1;
		inputX2 = x2;
	}

	@Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
        		{3, 0, -3, -1, 1}, {3, 7, 0, -2.33, 0}, {1, 2, 1, -1, -1}
   		};
        return  Arrays.asList(c);
    }
	
	@Before
	public void setUp(){
		function = QuadraticFunction.of(inputA, inputB, inputC);
	}
	
	@Test
	public void test() {
		assertEquals(inputX1, function.getX1(), EPSILON);
		assertEquals(inputX2, function.getX2(), EPSILON);
	}

}