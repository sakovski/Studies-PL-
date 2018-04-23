import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest {

	private NWD nwd;
	
	@Before
	public void setUp() {
		nwd = new NWD();
	}
	
	@Test
	public void Nwd_dodatnie() {
		int a = 7;
		int b = 14;
		int result = nwd.nwd(a, b);
		assertEquals(7,result);
	}
	
	@Test
	public void Nwd_ujemne() {
		int a = -7;
		int b = -14;
		int result = nwd.nwd(a, b);
		assertEquals(7,result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void Nwd_zero() {
		int a = 0;
		int b = 7;
		int result = nwd.nwd(a, b);
		assertEquals(null,result);
	}
	
	@After
	public void tearDown() {
		nwd = null;
	}

}
