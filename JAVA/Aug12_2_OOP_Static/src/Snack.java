//������� : ��ü�� �Ӽ� ->(��ü.�Ӽ�)���� ǥ��
//							this : �� ��ü�� ����(������ ����)

//�� ������ ��� ���ڸ� Ŵ�� ����ٰ� �Ѵٸ�?
//	�̶� ����ϴ°� ***static �������
//			-��ü�� ��� �� �� �ִ� ����
//				=>Ŭ������.xxx�� ���
//			-��ü���� ����Ӽ�
//				=> ��ü�� ������ ���� static����� �ϳ��� �־ �ȴ�.
//			�޸� ������ ����������.


// static final �������
//			�����Ұ���!-> ���ȭ!(���� �������� �ʰڴ�.)
//			static final �ڷ��� ������(�빮�ڷ�!! / ��ȭ��) == ����;


//static �޼ҵ�
//		�޸𸮰� ���� ��
//		��ü�� ��� ����� ���� 0
//		!!!!!!!!!!!!!!static�� �ƴ� ����������� ������ �Ұ�����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


public class Snack {
	private String name;
	private double weight;
	private int price;
//	 static final String manufacturer = "����";
	static final String MANUFACTURER = "����";	
	
	public Snack(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("���� �̸� : %s\n", name);
		System.out.printf("���� ���� : %.1f\n" + weight);
		System.out.printf("���� ���� : %d\n" + price);
		System.out.printf("������ : %s\n", MANUFACTURER);
	}
	public static void printTaste() {
		System.out.println(MANUFACTURER);
//		System.out.println(name); ���� �߻�(static�� �ƴ� ��������� ����!!)
	}
}
