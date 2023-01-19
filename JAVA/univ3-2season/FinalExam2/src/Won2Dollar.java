import java.util.Scanner;

abstract class Converter{
	abstract protected double convert(double src);//추상 메소드
	abstract protected String srcString();//추상 메소드
	abstract protected String destString();//추상 메소드
	protected double ratio;// 비율

public void run() {
	Scanner scanner =new Scanner(System.in);
	System.out.println(srcString() + "을 "+ destString() + "로 바꿉니다.");
	System.out.println(srcString() + "을 입력하세요>> ");
	double val = scanner.nextDouble();
	double res = convert(val);
	System.out.println("환전 결과: " + res + destString() + "입니다.");
	scanner.close();
   }
}
public  class Won2Dollar extends Converter {
	 double Exchange;
	 Won2Dollar(int Exchange){
		 
		 this.Exchange = Exchange;
	 }
	protected double convert(double src) {
		ratio = (double) 1 / Exchange;
		return src*ratio;
	 }
	 protected  String srcString() {
		 return "원";
	 }
	 protected String destString() {
		return "달러";
	 }
	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1200);//1달러는 1200원
		toDollar.run();
	}

}
