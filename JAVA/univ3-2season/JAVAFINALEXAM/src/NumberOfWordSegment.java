import java.util.Scanner; 
public class NumberOfWordSegment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		while(true) {
			System.out.print(">>");
			String string = scanner.nextLine();//������ ������ �˰� ���� ���� �Է�
	
			if(string.equals("�׸�")) {
				System.out.println("���α׷��� �����մϴ�!");
				break;//����ڰ� "�׸�" �Է��� �� ���α׷� ����
		} 
	String StringArray[] = string.split(" ");//������ �������� �迭
System.out.println("������ ������ " + StringArray.length + "���Դϴ�.");//���� ���� ���
		}
		scanner.close();
	}
}
