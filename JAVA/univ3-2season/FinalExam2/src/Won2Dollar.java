import java.util.Scanner;

abstract class Converter{
	abstract protected double convert(double src);//�߻� �޼ҵ�
	abstract protected String srcString();//�߻� �޼ҵ�
	abstract protected String destString();//�߻� �޼ҵ�
	protected double ratio;// ����

public void run() {
	Scanner scanner =new Scanner(System.in);
	System.out.println(srcString() + "�� "+ destString() + "�� �ٲߴϴ�.");
	System.out.println(srcString() + "�� �Է��ϼ���>> ");
	double val = scanner.nextDouble();
	double res = convert(val);
	System.out.println("ȯ�� ���: " + res + destString() + "�Դϴ�.");
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
		 return "��";
	 }
	 protected String destString() {
		return "�޷�";
	 }
	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1200);//1�޷��� 1200��
		toDollar.run();
	}

}
