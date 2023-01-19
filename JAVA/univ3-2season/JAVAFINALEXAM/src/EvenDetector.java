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
	return n % 2 == 0;//������ 2�� ���� �������� 1�̸� false�� �������� 0�̸� true�� return�Ѵ�.
	}
	public static void main(String[] args) {
		EvenDetector num=new EvenDetector(11);
		System.out.println(num.isEven());
		
	}

}
