package nwd;

public class EuclideanImpl implements Euclidean {

	public int NWD(int a, int b) {
		if(a <= 0 || b <= 0 ){
			throw new IllegalArgumentException();
		}
		else{
			while(a!=b){
				if(a >= b){
					a = a-b;
				}
				else{
					b = b-a;
				}
			}
		}
		return a;
	}
}
