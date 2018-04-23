import static org.junit.Assert.*;

import org.junit.Test;

public class GenericTableTest {
	
	private static final double EPSILON = 0.1;
	
	@Test
	public void largest_oneintelem_test() {
		int elem = 4;
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{elem});
		int largest = table.largest(table);
		assertEquals(elem, largest);
	}
	
	@Test
	public void largest_onestringelem_test() {
		String elem = "test";
		GenericTable<String> table = new GenericTable<String>(new String[]{elem});
		String largest = table.largest(table);
		assertEquals(elem, largest);
	}
	
	@Test
	public void largest_onecharelem_test() {
		char elem = 'a';
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{elem});
		char largest = table.largest(table);
		assertEquals(elem, largest);
	}

	@Test
	public void largest_onedoubleelem_test() {
		double elem = 13.05;
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{elem});
		double largest = table.largest(table);
		assertEquals(elem, largest, EPSILON);
	}
	
	@Test
	public void largest_int_test() {
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{55,3,2,5,1,6,11,3,3,2,1});
		int largest = table.largest(table);
		assertEquals(55, largest);
	}
	
	@Test
	public void largest_char_test() {
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{'a', 'x', 'z', 'b', 's'});
		char largest = table.largest(table);
		assertEquals('z', largest);
	}
	
	@Test
	public void largest_string_test() {
		GenericTable<String> table = new GenericTable<String>(new String[]{"abba", "zssa", "aaa", "bbb"});
		String largest = table.largest(table);
		assertEquals("zssa", largest);
	}
	
	@Test
	public void largest_double_test() {
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{4.05, 2.113, 10.456, 5.065});
		double largest = table.largest(table);
		assertEquals(10.456, largest, EPSILON);
	}
	
	@Test
	public void smallest_oneintelem_test() {
		int elem = 4;
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{elem});
		int largest = table.smallest(table);
		assertEquals(elem, largest);
	}
	
	@Test
	public void smallest_onestringelem_test() {
		String elem = "test";
		GenericTable<String> table = new GenericTable<String>(new String[]{elem});
		String largest = table.smallest(table);
		assertEquals(elem, largest);
	}
	
	@Test
	public void smallest_onecharelem_test() {
		char elem = 'a';
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{elem});
		char largest = table.smallest(table);
		assertEquals(elem, largest);
	}

	@Test
	public void smallest_onedoubleelem_test() {
		double elem = 13.05;
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{elem});
		double largest = table.smallest(table);
		assertEquals(elem, largest, EPSILON);
	}
	
	@Test
	public void smallest_int_test() {
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{55,3,2,5,1,6,11,3,3,2,1});
		int smallest = table.smallest(table);
		assertEquals(1, smallest);
	}
	
	@Test
	public void smallest_char_test() {
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{'a', 'x', 'z', 'b', 's'});
		char smallest = table.smallest(table);
		assertEquals('a', smallest);
	}
	
	@Test
	public void smallest_string_test() {
		GenericTable<String> table = new GenericTable<String>(new String[]{"abba", "zssa", "aaa", "bbb"});
		String smallest = table.smallest(table);
		assertEquals("aaa", smallest);
	}
	
	@Test
	public void smallest_double_test() {
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{4.05, 2.113, 10.456, 5.065});
		double smallest = table.smallest(table);
		assertEquals(2.113, smallest, EPSILON);
	}
	
	@Test
	public void isSorted_int_false_test() {
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{1,2,3,5,4,6});
		assertFalse(table.isSorted(table));
	}
	
	@Test
	public void isSorted_int_true_test() {
		GenericTable<Integer> table = new GenericTable<Integer>(new Integer[]{10,110,120,130,140,150});
		assertTrue(table.isSorted(table));
	}
	
	@Test
	public void isSorted_char_false_test() {
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{'a', 'c', 'b', 'w'});
		assertFalse(table.isSorted(table));
	}
	
	@Test
	public void isSorted_char_true_test() {
		GenericTable<Character> table = new GenericTable<Character>(new Character[]{'a', 'b', 'c', 'd'});
		assertTrue(table.isSorted(table));
	}
	
	@Test
	public void isSorted_string_false_test() {
		GenericTable<String> table = new GenericTable<String>(new String[]{"zapal", "auto", "byc", "albo", "nie"});
		assertFalse(table.isSorted(table));
	}
	
	@Test
	public void isSorted_string_true_test() {
		GenericTable<String> table = new GenericTable<String>(new String[]{"albo", "auto", "byc", "nie", "zapal"});
		assertTrue(table.isSorted(table));
	}
	
	@Test
	public void isSorted_double_false_test() {
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{1.01, 3.03, 4.04, 2.02});
		assertFalse(table.isSorted(table));
	}
	
	@Test
	public void isSorted_double_true_test() {
		GenericTable<Double> table = new GenericTable<Double>(new Double[]{1.01, 3.03, 4.04, 5.05});
		assertTrue(table.isSorted(table));
	}
}
