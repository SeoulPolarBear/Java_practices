import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("5���� �л��� ������ �Է��ϼ���.");
		int count=0;
		int sum=0;
		for(int i=0;i<5;i++) {
			int n=scanner.nextInt();//������ �Է��Ͻʽÿ�
			if(n<=60)
				continue; //����� �ƴ� ��� ���� �ݺ����� ����
			else
			    count++;
				sum+=n; // ����� ��� ����
		}
		System.out.println("60�� �̻��� �л����� ������ ����� "+(double)sum/count);

		scanner.close();
	}


	

}
