import java.util.Scanner;
public class GradingSwitch {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
	char grade;
	System.out.print("������ �Է��ϼ���(0~100):");
	int score=scanner.nextInt();
	switch(score/10) {
	case 10://score100
	case 9://score90~99
	grade='A';
	break;
	case 8://score80~89
	grade='B';
	break;
	case 7://score70~79
	grade='C';
	break;
	case 6://score60~69
	grade='D';
	break;
	case 5://score50~59
	case 4://score40~49
	case 3://score30~39	
	case 2://score20~29	
	case 1://score10~19
	case 0://score0~9	
	grade='F';
	break;
	default:
	grade='X';//������ ���� ���� �ʽ��ϴ�.
	
	}
	System.out.println("������"+grade+"�Դϴ�."+" ��, ���⼭ X�� ������ �������� �ʴ´ٸ� ���ϴ� �� �Դϴ�.");
	
	scanner.close();	
		
		
	}

}
