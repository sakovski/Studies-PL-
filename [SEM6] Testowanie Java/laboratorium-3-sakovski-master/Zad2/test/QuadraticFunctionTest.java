import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuadraticFunctionTest {

	static BufferedReader rdr;
	String line;
	private QuadraticFunction function;
	private static final double EPSILON = 0.01;
	
	@BeforeClass
	public static void setUp() throws Exception {
		rdr = new BufferedReader(new FileReader("test/test.txt"));
	}
	
	@Test
	public void testFromFile() throws Exception {
		while((line = rdr.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}			
			StringTokenizer st = new StringTokenizer(line);
			if (!st.hasMoreTokens()) {
				continue;
			}
			
			double[] expected = getExpected(st);						
			double[] arguments = getArgumentArray(st);
			function = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
			assertEquals(expected[0], function.getX1(), EPSILON);
			assertEquals(expected[1], function.getX2(), EPSILON);
		}
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		rdr.close();
	}	
	
	private double[] getExpected(StringTokenizer st) {
		String val = st.nextToken();
		double[] expected = new double[2];
		expected[0] = Double.parseDouble(val);
		val = st.nextToken();
		expected[1] = Double.parseDouble(val);
		return expected;
	}
	
	private ArrayList<Double> getArgumentList(StringTokenizer st) {
		ArrayList<Double> argumentList = new ArrayList<Double>();
		while (st.hasMoreTokens()) {
			argumentList.add(Double.valueOf(st.nextToken()));
		}
		return argumentList;
	}
	
	private double[] getArgumentArray(StringTokenizer st) {
		ArrayList<Double> argumentList = getArgumentList(st);
		double[] arguments = new double[3];
		for(int i=0; i<3; i++) {
			arguments[i] = ((Double) argumentList.get(i)).doubleValue();
		}
		return arguments;
	}
}