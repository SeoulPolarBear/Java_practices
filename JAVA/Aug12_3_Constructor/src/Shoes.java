//Constructor
// ��ü�� ������� �� ���� �۾��� �ؾ��ϴµ�...
//	=>������ �����!
// ������ �ƿ� ����, �޼ҵ���� Ŭ������� ���� �޼ҵ�
// �����ڸ� ������ ������ => �⺻ �����ڸ� ��������
// �����ڸ� �ǵ帮��...
//	=> �ڹ� �����Ϸ��� �⺻ �����ڸ� �ȸ������...
//	=> �ý����� �ڵ����� ��ü�� ���鶧�� �ִµ�...
//  => �⺻ �����ڸ� �� => ����!
public class Shoes {
	// ����Ű Ȩ������
	// �̸� : ??
	private String name;
	// size
	private int size;
	// ����
	private int price;
	// �귣��
	private static String brand = "����Ű";
	
	public Shoes() {
		
	}
	//������ ���� �� ctrl + space ������ �ȴ�.

	// ������ ��� ������ �����ε�
	public Shoes(String name, int size, int price) {
		super();//���� �ִ� �⺻ ������ �ҷ���!
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static String getBrand() {
		return brand;
	}

	public static void setBrand(String brand) {
		Shoes.brand = brand;
	}

	public void printInfo() {
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("������ : %d\n", size);
		System.out.printf("���� : %d\n", price);
		System.out.printf("�귣�� : %s\n", brand);
		System.out.println("======================================");
	}
	public void test(String name) {//�Ź� �̸�
		System.out.println(name);
		System.out.println(this.name);
	}

}
