
public class Circle {
	
	public double r;
	
	public Circle(double r)	{
		this.r = r;
	}
		
	double circumfence(Circle c) {
		return 2 * Math.PI * c.r;
	}
	double poleCircle(Circle c) {
		return Math.PI * Math.pow(c.r, 2);
	}
}
