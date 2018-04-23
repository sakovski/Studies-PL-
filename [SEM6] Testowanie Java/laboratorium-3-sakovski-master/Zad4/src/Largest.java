
public class Largest {
	public static int largest(Integer[] arrayInput) {
		int first = arrayInput[0];
		for (int i=0; i<arrayInput.length; i++) {
			if(first < arrayInput[i]) {
				first = arrayInput[i];
			}
		}
		return first;
	}
}
