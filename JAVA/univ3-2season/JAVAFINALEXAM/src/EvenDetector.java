abstract class Detector{
	protected int n;
	public  Detector(int n) {
		this.n=n;
	}
	public abstract boolean isEven();
    
}
public class EvenDetector extends Detector {
	
	public EvenDetector(int n) {
		super(n);
	}
	@Override
	public boolean isEven() {
	return n % 2 == 0;//정수를 2로 나눈 나머지가 1이면 false를 나머지가 0이면 true를 return한다.
	}
	public static void main(String[] args) {
		EvenDetector num=new EvenDetector(11);
		System.out.println(num.isEven());
		
	}

}
