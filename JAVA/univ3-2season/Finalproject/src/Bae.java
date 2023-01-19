
import java.util.Scanner;
import java.util.InputMismatchException;

public class gamesimulation {
	public static void main(String args[]) {
		System.out.println("** ���� ��ȭ �� Ȯ���� ������ �̱� ��� ��� �ùķ��̼� ���α׷��Դϴ�.\n"
				+ "��ȭ ��� �ùķ��̼��� 1, ������ �̱� ��� �ùķ��̼��� 2�� �Է��� �ּ���.\n"
				+ " �� ���� ���� �Ǵ� ���� �Է� �� ���α׷� ��� ���ǻ����� ��µ˴ϴ�. **");
		Scanner scanner = new Scanner(System.in);
		int answer = 0;
		try {
		answer = scanner.nextInt(); // 0 �Ǵ� 1 �Ǵ� 2 �Է�
		}
		catch(InputMismatchException e) {
			System.out.println("���α׷� ��� ���ǻ��� >> ������ �� �Է� �� %, $ �� ������ ������ �Է��� �ʿ� ������,"
					+ "Ȯ�� �Է� �� �ݵ�� 1~100 ������ ������ �Է��� �ֽñ� �ٶ��ϴ�.");
			System.out.println("��� �����ʹ� ������ ������ ���� ���� �Է��� �ֽð�,"
					+ "���� ���� ��� ���� ��� �ּڰ����� �ڵ� �����˴ϴ�.");
		}
		if(answer == 1) { // ��ȭ ��� �ùķ��̼�
			System.out.println("��ȭ ��� �ùķ��̼� >> ��ȭ �ִ� ������ �Է��� �ּ���. (�ּ� 1 �̻�)");
			int level = 1;
			try {
			level = scanner.nextInt(); // ��ȭ �ִ� ���� ����
			}
			catch(InputMismatchException e) {
				level = 1;
			}
			if(level < 1) {
				level = 1;
			}
			System.out.println("��ȭ ������ ���� Ȯ���� �Ҹ� ��ȭ�� ������ �ּ���. (Ȯ�� �ּ� 1 �̻�, ��ȭ �ּ� 0 �̻�)");
			int count = 0, sumcount = 0, money = 0, summoney = 0;
			for(int i=1; i<level; i++) {
				System.out.print(i + "->" + (i+1) + " ���� ��ȭ �� Ȯ�� >> ");
				int levelprob = 1;
				try {
				levelprob = scanner.nextInt(); // ����ڰ� ��ȭ ������ Ȯ���� ���� �Է�
				}
				catch(InputMismatchException e) {
					levelprob = 1;
					scanner.next();
					i--;
					continue;
				}
				if(levelprob < 1 || levelprob > 100) {
					levelprob = 1;
				}
				System.out.print(i + "->" + (i+1) + " ���� ��ȭ �� �Ҹ� ��ȭ >> ");
				try {
				money = scanner.nextInt(); // ����ڰ� ��ȭ ������ �Ҹ� ��ȭ�� ���� �Է�
				}
				catch(InputMismatchException e) {
					money = 0;
					scanner.next();
					i--;
					continue;
				}
				if(money < 0) {
					money = 0;
				}
				count = 100 / levelprob;
				summoney = money * count + summoney;
				sumcount = count + sumcount;
			}
			System.out.print("��� >> �ִ� " + level + "���������� ��ȭ �õ� ���� Ƚ���� " + sumcount
					+ "ȸ�̸�, ����Ǵ� �� �Ҹ� ��ȭ�� " + summoney + "�Դϴ�.");
		}
		
		else if(answer == 2) { // ������ �̱� ��� �ùķ��̼�
			int money = 0, count = 0;
			System.out.println("������ �̱� ��� �ùķ��̼� >> ȹ���ϰ��� �ϴ� �������� Ȯ���� ������ �ּ���. (�ּ� 1 �̻�)");
			int itemprob = 1;
			try {
			itemprob = scanner.nextInt(); // ����ڰ� ��ȭ ������ Ȯ���� ���� �Է�
			}
			catch(InputMismatchException e) {
				itemprob = 1;
				scanner.next();
			}
		if(itemprob < 1 || itemprob > 100) {
			itemprob = 1;
		}
		System.out.println("1ȸ �̱� �� �Ҹ� ��ȭ�� �Է��� �ּ���. (�ּ� 0 �̻�)");
		try {
			money = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			money = 0;
			scanner.next();
		}
		if(money < 0) {
			money = 0;
		}		
		System.out.println("�̱� Ƚ���� ������ �ּ���. (�ּ� 1 �̻�)");
		try {
			count = scanner.nextInt(); // ����ڰ� �̱� Ƚ���� ���� �Է�
		}
		catch(InputMismatchException e) {
			count = 1;
			scanner.next();
		}
		if(count < 1) {
			count = 1;
		}
		int getitem = count * itemprob / 100;
		int firstget = 100 / itemprob;
		System.out.print("��� >> " + firstget + " ��° �̱⿡�� �������� ȹ���� ������ ����Ǹ�,\n"
		+ "�� " + count * money + "��ŭ�� ��ȭ �Һ� �� " + count + " ȸ �̱� �� " + getitem + " ���� �������� ȹ���� ������ ����˴ϴ�.");
	}
		
		else {
			System.out.println("���α׷� ��� ���ǻ��� >> ������ �� �Է� �� %, $ �� ������ ������ �Է��� �ʿ� ������,"
					+ "Ȯ�� �Է� �� �ݵ�� 0~100 ������ ������ �Է��� �ֽñ� �ٶ��ϴ�.");
			System.out.println("��� �����ʹ� ������ ������ ���� ���� �Է��� �ֽð�,"
					+ "���� ���� ��� ���� ��� �ּڰ����� �ڵ� �����˴ϴ�.");
		}
		scanner.close(); // scanner �ݱ�
	}