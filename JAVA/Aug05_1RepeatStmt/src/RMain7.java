//part1 : �������� ���α׷���(������� �� �Ἥ ����� �� ����) - �̰�������.
//part2 : ��ü���� ���α׷��� - ����������...
//part3 : ��Ÿ ���... �ܺ� ���̺귯��

/**
 * ���ǹ�
 * �ݺ�
 * �迭
 * ------------------------>�����ø��ǾƵ� ����
 * 
 * */
public class RMain7 {
	//���� : �Ŵ��� - �ý��۰���, �л�����, �������� ����,
	//			���� - �л�����, �������� ����
	//			�л� - �������� ������ �ݺ��ϴٰ� "��"�̶�� �Է��ϸ� ���α׷� ����!
	public static void main(String[] args) {
//		System.out.println("������ �Է¤��� : ");
//		String comment = new Scanner(System.in).next();
//		a : while(!comment.equals("��")) {// a�� �ݺ����� �̸� -> �ݺ��� ���� �̸� : 
//			switch(comment) {
//			case "�Ŵ���":
//				System.out.println("�ý��۰��� ");
//			case "����":
//				System.out.println("�л����� ");
//			case "�л�":
//				System.out.println("�������� ����");
//				break;
//			case "��":
////				break;// �̷��� �� ��� ������ ����� ��(switch)�� ���� ��Ų��. => ��, �� ���� �������� ���Ḧ ��Ų��.
//				break a;//���� �̷��� 'break �ݺ����� �̸�;' �̷��� �� ��� �ݺ����� ���� ��ų �� �ִ�.
//				default:
//					System.out.println("�𸣴� ���");
//					break;
//			}
//			comment = new Scanner(System.in).next();
//		}
		
		bb:for (int i = 0; i < 3; i++) {
			aa:for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					if(i == 1) {
						System.out.println("�ߴ� !");
						
			//		break;// 1,0,0 -> 1,1,0 -> 1,2,0 -> 2,0,0 �̷��� ��
	//					break aa;// ����� 1,0,0�̰� ���� -> 2,0,0���� �Ѿ��. ���� ��� ���� ���� 
				//		break bb;// 1,0,0���� for�� ��ü�� ����
					}
					
				}
				
			}
			
		}
	}
}
