import java.util.Scanner;

public class MoviePrice {

	public static void main(String[] args) {
		
System.out.println("�ڽ��� ������ ����(ex)20), \n"
		+ "��ȭ �ð���(����,�Ϲ�,�ɾ�), \n"
		+ "��Ż� ��ȣ(SKT�� 1��,KT�� 2��,LGU+�� 3�� �ش�Ǵ� ��Ż簡 �����ø� 4���� �Է����ּ���.), \n"
		+ "���� ��¥(ex)0406)�� �Է��Ͻÿ�\n"
+" �׸��� �������� ���̱Ⱓ�� 11��27��~12��04�ϵ� Ȯ���ϼ���.(�� ��Ż� ������ ���� �ʽ��ϴ�.)\n");
		Scanner scanner=new Scanner(System.in);
	        
	System.out.print("�� ���� : ");
	int age= scanner.nextInt();
	System.out.print("��ȭ �ð���(����, �Ϲ�, �ɾ�) : ");
	String time = scanner.next();
	System.out.print("��Ż� : ");
	int telecom=scanner.nextInt();
	System.out.print("���� ��¥ : ");
	int day = scanner.nextInt();
	int price=0;
if(telecom ==1) {
	if(age<=70&age>=19) {
					
		switch(time) {
		case "����":
		price= 8000;
		break;
		case "�Ϲ�":
		price=10000;
		break;
		case "�ɾ�":
		 price=7000;
		break;
			}
System.out.println("������ SKT ���� ���� �� 10% ���� �ż� "+price*90/100+"�� �Դϴ�.");
				
			}
				
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "����":
		price=6000;
						System.out.println("û�ҳ��� SKT ���� ���� �� 5% ���� �ż� "+price*90/100+"�� �Դϴ�.");
		break;
		case "�Ϲ�":
		price=8000;
							System.out.println("û�ҳ���  SKT ���� ���� �� 5% ���� �ż�"+price*90/100+"�� �Դϴ�.");
		break;
		case "�ɾ�":
  String x="û�ҳ��� �ɾ� ��ȭ ������ �Ұ��մϴ�.";
		System.out.println(x);	
		 break;			
		}
	}
	else {
		switch(time) {
		case "����":
		price=4000;
		break;
		case "�Ϲ�":
		price=6000;
		break;
		case "�ɾ�":
		price=3000;
		break;
					
	}
System.out.println("���� Ȥ�� ������  SKT ���� ���� �� 10% ���� �ż�  "+price*90/100+"�� �Դϴ�.");
		}
	}
else if(telecom ==2) {
	if(age<=70&age>=19) {
		switch(time) {
		case "����":
		price= 8000;
		break;
		case "�Ϲ�":
		price=10000;
		break;
		case "�ɾ�":
		price=7000;
		break;
	} 
System.out.println("������ KT ���� ���� �� 15% ���� �ż� "+price*85/100+"�� �Դϴ�.");
	}
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "����":
		price=6000;
						System.out.println("û�ҳ��� KT ���� ���� �� 5% ���� �ż� "+price*85/100+"�� �Դϴ�.");
		break;
		case "�Ϲ�":
		price=8000;
							System.out.println("û�ҳ��� KT ���� ���� �� 5% ���� �ż�"+price*85/100+"�� �Դϴ�.");
		break;
		case "�ɾ�":
String x="û�ҳ��� �ɾ� ��ȭ ������ �Ұ��մϴ�.";
	System.out.println(x);	
		break;				
	}
}
		else {
		switch(time) {
		case "����":
		price=4000;
		break;
		case "�Ϲ�":
		price=6000;
		break;
		case "�ɾ�":
		price=3000;
		break;
			}
System.out.println("���� Ȥ�� ������  KT ���� ���� �� 15% ���� �ż� "+price*85/100+"�� �Դϴ�.");
			}
	}
else if(telecom ==3) {
	if(age<=70&age>=19) {
		switch(time) {
		case "����":
		price= 8000;
		break;
		case "�Ϲ�":
		price=10000;
		break;
		case "�ɾ�":
		price=7000;
		break;
	}
System.out.println("������ LGU+ ���� ���� �� 5% ���� �ż� "+price*95/100+"�� �Դϴ�.");
		}
	else if(age<= 14&age>= 8) {
		switch(time) {
		case "����":
		price=6000;
						System.out.println("û�ҳ��� LGU+ ���� ���� �� 5% ���� �ż� "+price*95/100+"�� �Դϴ�.");
		break;
		case "�Ϲ�":
		price=8000;
							System.out.println("û�ҳ��� LGU+ ���� ���� �� 5% ���� �ż�"+price*95/100+"�� �Դϴ�.");
		break;
		case "�ɾ�":
String x="û�ҳ��� �ɾ� ��ȭ ������ �Ұ��մϴ�.";
System.out.println(x);	
		break;			
		}
	}
	else {
		switch(time) {
		case "����":
		price=4000;
		break;
		case "�Ϲ�":
		price=6000;
		break;
		case "�ɾ�":
		price=3000;
		break;
		}
System.out.println("���� Ȥ�� ������   LGU+ ���� ���� �� 5% ���� �ż� "+price*95/100+"�� �Դϴ�.");
		}
}
	else{if(70>=age&age>=19) {
		switch(time) {
		case "����":
		price= 8000;
		break;
		case "�Ϲ�":
		price=10000;
		break;
		case "�ɾ�":
		price=7000;
		break;
	}
System.out.println("������ ���� ������ �����ø� "+price+"�� �Դϴ�.");
}
	else if(14>=age &age>= 8) {
		
		switch(time) {
		case "����":
		price=6000;
System.out.println("û�ҳ��� ���� ������ �����ø� "+price+"�� �Դϴ�.");
		break;
		case "�Ϲ�":
		price=8000;
System.out.println("û�ҳ��� ���� ������ �����ø� "+price+"�� �Դϴ�.");
		break;
		case "�ɾ�":
String x="û�ҳ��� �ɾ� ��ȭ ������ �Ұ��մϴ�.";
System.out.println(x);	
		 break;
	}
}
	else {
		switch(time) {
		case "����":
		price=4000;
		break;
		case "�Ϲ�":
		price=6000;
		break;
		case "�ɾ�":
		price=3000;
		break;
	}
System.out.println("���� Ȥ�� ������ ���� ������ �����ø� "+price+"�� �Դϴ�.");
	}
}
if(day>=1127&1204>=day) 
System.out.println("�� �����̵��� �Ⱓ ���� ��� ������ �ݰ��Դϴ�. ����"+price*50/100+" �� �Դϴ�.");

else 
System.out.println("������ �� �����̵��� �Ⱓ�� �ƴմϴ�.");
	        
scanner.close();
	       		
	}
}
