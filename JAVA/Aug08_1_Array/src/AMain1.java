//�迭(Array)	"[]"  ���� 1 : data n
//�迭 : ���� Ÿ���� ���� ������ �ϳ��� �������� �ٷ�� ��
//		�迭 �ӿ� ������ data�� ��Ҷ�� �θ���.
//		��Ҹ��� �ٿ��� �Ϸ� ��ȣ�� �ִµ� �� ��Ҹ� �����ϴµ� ����Ѵ�.(�ε���(Index)) : ������ 0����!!
//

//�迭 ���� ���
//		�ڷ���[] ������;	//�迭�� ����
//		������ = new �ڷ���[�迭�� ���� ����];	//�迭 ����
//		=> �ڷ���[] ������ = new �ڷ���[�迭�� ���� ����];

public class AMain1 {
	public static void main(String[] args) {
		int[] eng = new int[3];
		eng[0] = 100;
		eng[1] = 70;
		eng[2] = 50;
		for (int i : eng) {// for(A : B) list B�� �ִ� ������ ������ �ϳ��ϳ� A�� �ְڴ�.
			System.out.println(i);
		}

		int[] math = new int[] { 10, 20, 30 };

		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		int[] kor = { 20, 40, 60 };// ���
		for (int i : kor) {
			System.out.println(i);

		}

		// 3��° ����� ������ ��찡 �ֱ� ������ 2��° ��ĵ� �˾Ƶδ� ���� ����.

		int a = 10;
		int[] b = { 10, 20 };
		System.out.println(a);
		System.out.println(b);// [I@2a139a55 : ������ ���� ��(�ּ� ��)
		// b[2] = 200;//������ �߻��� �� �ۿ� ����. ���� : outOfBounds(������ ������ ���� �ʾұ� ������) �����Ǿ� �ִ�.

		int[][] score = { { 50, 30 }, 
							{ 30, 50 }, 
							{ 100, 80 } };
		for (int[] is : score) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
		System.out.println(score[1][0]);//��������

	}
}
