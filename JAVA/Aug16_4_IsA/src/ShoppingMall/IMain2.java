package ShoppingMall;
//A is a B : ��Ӱ���
// ���θ� - ��ǰ�� ���� ������ �Խ��ϰ� ����
public class IMain2 {
public static void main(String[] args) {
	//�Ź�(�̸�, ����, ������)
	//���
	Shoes shoes = new Shoes("��������1", 256000, 280);
	
	//��ǻ�� (�̸�, ����, cpu, ram, hdd)
	//���
	Computer computer = new Computer("Samsung Desktop", 1500000, "i7-1234", 32, 1024);
	//��Ʈ�� (�̸�, ����, cpu, ram, hdd, ����, ���͸� ���ӽð�)
	//���
	NoteBook noteBook = new NoteBook("Apple MAC", 1500000, "M1", 32, 1024, 1.5, 8.5);
	ShoppingMall shoppingMall = new ShoppingMall(shoes,computer,noteBook);
	
	shoppingMall.printInfo();
	
	
	
}
}
