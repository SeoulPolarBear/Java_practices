import java.util.Random;
import java.util.Scanner;

//���� & �� �Է�
//���� ������ Ȧ���� "Ȧ" & ¦���� "¦" �񱳵���
//���ؼ� ��� ����
// ���

//Ȧ¦ (�Լ�. ver)
public class FMain4 {
	//�信 ���� ��� ���
		public static void printAnswer() {
			System.out.print("\"Ȧ��\" ���� \"¦��\"���� �Է��Ͻÿ�. : ");
		}
		
	//���� �������� ���
	public static int Coin() {
		return new Random().nextInt(11);//0~10
	}
	
	//Ȧ¦ �߿� �ϳ� ����ϱ�
	public static String oddorEven() {
		return new Scanner(System.in).next();
	}
	
	//coin Ȧ¦���� Ȯ��
	public static String Result(int coin) {
		return coin%2 == 0?"¦��":"Ȧ��";
	}
	//���� ����Ѱ� �´��� Ȯ��
	public static String checkAnswer(String odd_or_even, String result) {
		return odd_or_even.equals(result)?"����!":"��";
	}
	//�信 ���� ��� ���
	public static void printAnswer(int coin,String check_answer) {
		System.out.println(coin + "���Դϴ�! �ʴ� : " + check_answer);
	}
	
	public static void main(String[] args) {
		printAnswer();
		int coin = Coin();
		String odd_or_even = oddorEven();
		String result = Result(coin);
		String check_answer = checkAnswer(odd_or_even, result);
		printAnswer(coin,check_answer);
	}
}
