import java.util.Scanner;

//�񸸵� �˻� ���α׷�( �Լ�. ver)

//����� �� �з��ؼ� �Լ��� ǥ���� ����� �ϴ����� : ���࿡ ǥ��ü���� 0.9=>0.8�� �ٲ���� �� ��,
//���� �پ��� ����� �Լ� �ϳ��� �����ϰ�, ��������� �����ϰ� ���� ��...(��������)
//�ѹ��� �� ã�� �� ������??��� �� ������ �̷��� ǥ���Ѵ�.
//ctrl + shift + numberpad(/) : �Լ��� ���� �� �ִ�.
//ctrl + shift + numberpad(*) : �Լ��� �� �� �ִ�.
//ctrl + / : �Լ� +,-ǥ��


//�Լ� : main�Լ����� java�� �𸣴� ����� ���� �� �Ѱ��� �˾ƺ� �� �ְ� + �����ؾ� �Ѵ�.
public class FMain3 {
	//Ű�� �����Դ� �Է��� ���� �� --------- 1
	public static double InputHeight() {
		System.out.print("Ű : ");
		return new Scanner(System.in).nextDouble();
	}
	
	public static double InputWeight() {
		System.out.print("ü�� : ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	//ǥ��ü�� = (Ű - 100) * 0.9 ------------- 2(�� ���� return ���� ��� ������ �𸣹Ƿ�)
	public static double meanWeight(double height) {
		return (height - 100) * 0.9;
	}
	//�񸸵� = (����ü�� / ǥ��ü��) *100 ----------------- 3
	public static double obesityPercent(double weight, double meanWeight) {
		return (weight/meanWeight)*100;
	}
	//�񸸵��� 120�� ������ '��', �ƴϸ� '�� ��' -------------- 4
	public static String Presence(double obesityPercent) {
		return obesityPercent > 120 ? "��":"�� ��";
	}
	//��� ���
	public static void printPresence(String present) {
		System.out.println(present);
	}
	
	public static void main(String[] args) {
		System.out.println("Ű�� ü���� �Է��� �ּ���.");
		double height = InputHeight();
		double weight = InputWeight();
		double mean_weight = meanWeight(height);
		double obesity_percent = obesityPercent(weight, mean_weight);
		String present = Presence(obesity_percent);
		printPresence(present);
		
		
		
	}
}
