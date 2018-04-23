public class Euklides {
	public int nwd(int a, int b){
		if(a <= 0 || b <=0)
		{
			throw new IllegalArgumentException();
		}
		while (a != b){
			if (a > b)
			a -= b;
			else
			b -= a;
			}
		return +a;
	}
	public int nww(int a, int b){
		if(a <= 0 || b <=0)
		{
			throw new IllegalArgumentException();
		}
		return (a*b)/nwd(a,b);
	}
	

	
	public Integer[] getNwdArray(int a, int b, int c, int d){
		Integer[] arr = new Integer[2];
		arr[0] = nwd(a,b);
		arr[1] = nwd(c,d);		
		
		return arr;
	}
	
	public String toString(int a, int b){
		int result = nwd(a,b);
		return "Result is " + Integer.toString(result);
	}
	
}