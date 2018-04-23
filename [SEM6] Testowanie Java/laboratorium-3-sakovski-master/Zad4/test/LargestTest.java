import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LargestTest {
	
	private int expectedInput;
	private Integer[] arrayInput;
	
	public LargestTest(Object[] expected, Object[] array){
		expectedInput = (int)expected[0];
		arrayInput = Arrays.copyOf(array, array.length, Integer[].class);
	}

	@Parameters
    public static Collection<Object[][]> data() {
        Object[][][] c = {
        		{{9}, {7,8,9}},
        		{{9}, {9,8,7}},
        		{{9}, {9,8,9}},
        		{{-7}, {-9,-8,-7}},
        		{{1}, {1}},
        		{{7}, {-9, -8, -7, 7, 6, 4}}
   		};
        return  Arrays.asList(c); 
    }
	
	@Test
	public void test() {
		assertEquals(expectedInput, Largest.largest(arrayInput));
	}
}
