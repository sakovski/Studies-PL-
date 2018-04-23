import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SortingTest {

	@Test
	public void IsSortedRTest() {
		Sorting sorting = new Sorting(new int[]{5,4,3,2,6,1});
		sorting.sortArray("R");
		assertTrue(sorting.isSorted("R"));
	}
	
	@Test
	public void IsSortedMTest() {
		Sorting sorting = new Sorting(new int[]{5,4,3,2,6,1});
		sorting.sortArray("M");
		assertTrue(sorting.isSorted("M"));
	}
	
	@Test
	public void SortingMTest() {
		Sorting sorting = new Sorting(new int[]{5,4,3,2,6,1});
		sorting.sortArray("M");
		Assert.assertArrayEquals(new int[] {6,5,4,3,2,1}, sorting.array);
	}
	
	@Test
	public void SortingRTest() {
		Sorting sorting = new Sorting(new int[]{5,4,3,2,6,1});
		sorting.sortArray("R");
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, sorting.array);
	}
	
	@Test
	public void SortingOnly2sArrayTest() {
		Sorting sorting = new Sorting(new int[]{2,2,2,2,2,2});
		sorting.sortArray("R");
		assertTrue(sorting.isSorted("R"));
	}
	
	@Test
	public void SortingEmptyArrayTest() {
		Sorting sorting = new Sorting(new int[]{});
		sorting.sortArray("R");
		assertTrue(sorting.isSorted("R"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void SortingIllegalTest() {
		Sorting sorting = new Sorting(new int[]{5,4,3,2,6,1});
		sorting.sortArray("illegal");
		assertNull(sorting.array);
	}

}
