
public class Calculator {
	public double add(double a, double b) {
		return a + b;	
	}
	
	public double sub(double a, double b) {
		return a - b;
	}
	
	public double multi(double a, double b) {
		return a * b;
	}
	
	public double div(double a, double b) {
		if (b == 0)
			throw new IllegalArgumentException();
		return a / b;
	}
	
	public boolean greater(double a, double b) {
		return a > b;
	}
	
	public boolean less(double a, double b) {
		return a < b;
	}
	
	public boolean equality(double a, double b) {
		return a == b;
	}
}
