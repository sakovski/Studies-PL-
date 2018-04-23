
public class NWD {
	public int nwd(int x, int y) {	 
		int a = x;
		int b = y;
		if (a == 0 || b == 0)
			throw new IllegalArgumentException();
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		while (a != b){
		if (a > b)
			a -= b;
		else
			b -= a;
		}
		return a;
	}
}
