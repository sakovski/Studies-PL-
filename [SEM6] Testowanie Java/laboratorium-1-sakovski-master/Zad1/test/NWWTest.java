import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWWTest {
	
	private NWW nww;
	
	@Before
	public void setUp() {
		nww = new NWW();
	}
	
	@Test
	public void Nww_dodatnie() {
		int a = 7;
		int b = 14;
		int result = nww.nww(a, b);
		assertEquals(14,result);
	}
	
	@Test
	public void Nww_ujemne() {
		int a = -7;
		int b = -14;
		int result = nww.nww(a, b);
		assertEquals(14,result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void Nww_zero() {
		int a = 0;
		int b = 7;
		int result = nww.nww(a, b);
		assertEquals(null,result);
	}
	
	@After
	public void tearDown() {
		nww = null;
	}

}
