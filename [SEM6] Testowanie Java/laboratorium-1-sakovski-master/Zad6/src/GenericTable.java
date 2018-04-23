
public class GenericTable<T> {
	
	public T[] table;
	
	public GenericTable(T[] table) {
		this.table = table;
	}
	
	public <T extends Comparable<T>> T largest(GenericTable<T> t) {
		if (t.table == null || t.table.length < 1)
			throw new IllegalArgumentException();
		if(t.table.length == 1)
			return t.table[0];
		T max = t.table[0];
		for(int i = 1 ; i < t.table.length; i++) {
			if(t.table[i].compareTo(max) > 0)
				max = t.table[i];
		}
		return max;
	}
	public <T extends Comparable<T>> T smallest(GenericTable<T> t) {
		if (t.table == null || t.table.length < 1)
			throw new IllegalArgumentException();
		if(t.table.length == 1)
			return t.table[0];
		T min = t.table[0];
		for(int i = 1 ; i < t.table.length; i++) {
			if(t.table[i].compareTo(min) < 0)
				min = t.table[i];
		}
		return min;
	}
	public <T extends Comparable<T>> boolean isSorted(GenericTable<T> t) {
		if (t.table == null || t.table.length < 2)
			throw new IllegalArgumentException();
		for(int i = 0; i < t.table.length - 1; i++) {
			if(t.table[i].compareTo(t.table[i+1]) > 0)
				return false;
		}
		return true;
	}
}