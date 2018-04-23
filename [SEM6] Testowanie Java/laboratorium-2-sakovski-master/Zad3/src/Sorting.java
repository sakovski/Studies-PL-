
public class Sorting {
	
	public int[] array;
	
	public Sorting(int[] array) {
		this.array = array;
	}
	
	//option = "R" || option = "M" co oznacza rosnaca oraz malejaco
	public void sortArray(String option) {
		if (array == null)
			throw new IllegalArgumentException();
		else if(array.length > 2) {
			int temp;
			int zmiana = 1;
			if(option.equals("R")) {
				while(zmiana > 0) {
					zmiana = 0;
					for(int i=0; i<array.length-1; i++){
						if(array[i]>array[i+1]){
							temp = array[i+1];
							array[i+1] = array[i];
							array[i] = temp;
							zmiana++;
						}
					}
				}
			}
			else if(option.equals("M")) {
				while(zmiana > 0) {
					zmiana = 0;
					for(int i=0; i<array.length-1; i++){
						if(array[i]<array[i+1]){
							temp = array[i+1];
							array[i+1] = array[i];
							array[i] = temp;
							zmiana++;
						}
					}
				}
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		
	}
	
	//wyswietla tablice
	public void showArray() {
		for(int elem : array) {
			System.out.print(elem + " | ");
		}
	}
	
	//czy tablica posortowana zaleznie od opcji
	public boolean isSorted(String option) {
		if (array == null)
			throw new IllegalArgumentException();
		else if(array.length > 2) {
			if(option.equals("R")) {
				for(int i = 0; i < array.length - 1; i++) {
					if(array[i] > array[i+1])
						return false;
				}
			}
			else if (option.equals("M")) {
				for(int i = 0; i < array.length - 1; i++) {
					if(array[i] < array[i+1])
						return false;
				}
			}
			else {
				throw new IllegalArgumentException();
			}
		}	
		return true;
	}
}
