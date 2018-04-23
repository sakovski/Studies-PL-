import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {

	@Test(expected=IllegalArgumentException.class)
	public void largest_null_test() {
		Table table = new Table(null);
		int largest = table.largest(table);
		assertNull(largest);
	}
	
	@Test
	public void largest_oneelem_test() {
		int elem = 4;
		Table table = new Table(new int[]{elem});
		int largest = table.largest(table);
		assertEquals(elem, largest);
	}
	
	@Test
	public void largest_zeros_test() {
		Table table = new Table(new int[]{0,0,0,0,0,0});
		int largest = table.largest(table);
		assertEquals(0, largest);
	}
	
	@Test
	public void largest_inbeginning_test() {
		Table table = new Table(new int[]{55,3,2,5,1,6,11,3,3,2,1});
		int largest = table.largest(table);
		assertEquals(55, largest);
	}
	
	@Test
	public void largest_inmiddle_test() {
		Table table = new Table(new int[]{3,2,5,1,6,55,3,3,2,1});
		int largest = table.largest(table);
		assertEquals(55, largest);
	}
	
	@Test
	public void largest_inend_test() {
		Table table = new Table(new int[]{3,2,5,1,6,10,3,3,2,1,55});
		int largest = table.largest(table);
		assertEquals(55, largest);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void smallest_null_test() {
		Table table = new Table(null);
		int smallest = table.smallest(table);
		assertNull(smallest);
	}
	
	@Test
	public void smallest_oneelem_test() {
		int elem = 4;
		Table table = new Table(new int[]{elem});
		int smallest = table.smallest(table);
		assertEquals(elem, smallest);
	}
	
	@Test
	public void smallest_zeros_test() {
		Table table = new Table(new int[]{0,0,0,0,0,0});
		int smallest = table.smallest(table);
		assertEquals(0, smallest);
	}
	
	@Test
	public void smallest_inbeginning_test() {
		Table table = new Table(new int[]{0,3,2,5,1,6,11,3,3,2,1});
		int smallest = table.smallest(table);
		assertEquals(0, smallest);
	}
	
	@Test
	public void smallest_inmiddle_test() {
		Table table = new Table(new int[]{3,2,5,1,6,0,3,3,2,1});
		int smallest = table.smallest(table);
		assertEquals(0, smallest);
	}
	
	@Test
	public void smallest_inend_test() {
		Table table = new Table(new int[]{3,2,5,1,6,10,3,3,2,1,0});
		int smallest = table.smallest(table);
		assertEquals(0, smallest);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void isSorted_null_test() {
		Table table = new Table(null);
		assertNull(table.isSorted(table));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void isSorted_oneelem_test() {
		int elem = 4;
		Table table = new Table(new int[]{elem});
		assertNull(table.isSorted(table));
	}
	
	@Test
	public void isSorted_false_test() {
		Table table = new Table(new int[]{1,2,3,5,4,6});
		assertFalse(table.isSorted(table));
	}
	
	@Test
	public void isSorted_true_test() {
		Table table = new Table(new int[]{10,110,120,130,140,150});
		assertTrue(table.isSorted(table));
	}
}