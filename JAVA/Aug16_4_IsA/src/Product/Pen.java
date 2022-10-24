package Product;
//������(Java)
// 1. Ŭ������ �����ڰ� �ϳ��� ������
//		�ڹ� �����Ϸ��� �����ڸ� �������!
//	2. ����Ŭ���� ��ü�� �����(Pen)
//		����Ŭ���� �⺻������(Product)�� �ڵ� ȣ��
//
public class Pen extends Product2{
	private String color;
	
	
	public Pen() {//�� 2. �� ����� ������
		// TODO Auto-generated constructor stub
	}

	public Pen(String color) {
		super();//�� 2. �� ����� ������(��� ����)
		this.color = color;
	}
	
	

	public Pen(String name, int price, String color) {
		super(name,price);//2. �ߵ�(x)
		//Product(�̸�, ����)
		//super(�Ķ����)�� ���� �����ڸ� �����ÿ���
		//�⺻�����ڰ� ������ �ʱ� ������ �⺻�����ڸ� ����� �� ����.!!
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
