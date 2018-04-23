import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EuklidesTest {

	private Euklides test;	
	
	@Before
	public void setUp(){
		test = new Euklides();
	}
	
	@Test
	public void NWD_Check(){	
		int result = test.nwd(52,14);
		assertThat(result, equalTo(2));	
	}

	@Test
	public void NWD_Check2(){	
		int result = test.nwd(36540,52);
		assertThat(result, is(4));	
	}

	@Test
	public void NwdTestNotEqual(){	
		int result = test.nwd(115,52);
		assertThat(result, is(not(equalTo(5))));	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeNumbers(){		
		int result = test.nwd(-7,6);
		assertThat(result, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void NWD_WithZero(){		
		int result = test.nwd(0,6);
		assertThat(result,null);
	}


	@Test
	public void toStringTest(){		
	String string = test.toString(5,7);	
		assertThat(string, containsString("Result is"));
	}

	@Test
	public void nwdWithArrays(){		
		Integer[] tab = test.getNwdArray(5,7,10,5);	
		assertThat(tab, hasItemInArray(equalTo(5)));
	}

	@After
	public void tearDown(){
		test = null;
	}
}