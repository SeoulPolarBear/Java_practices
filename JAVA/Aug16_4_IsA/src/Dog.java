
public class Dog extends Animal{
	String inhabit;

	public Dog(String sort, int age, String inhabit) {
		super(sort, age);//�⺻������
		this.inhabit = inhabit;
	}


	//@XXX : Annotation -> � ����� �ڵ����� �������ش�.
	@Override //��ӹ޾ƿ� method�� ����� �ٲٴ� ��
	public void printInfo() {
		//override�� ����Ϸ���...
		//		��ӹ��� Class������ method��� ���ƾ�!!
		super.printInfo();//super�� ���ϸ� ����Ŭ����.printInfo(); ����ϰڴ�.
		System.out.println(inhabit);
	}
	
	//VS
	//Overriding (//��ӹ޾ƿ� method�� ����� �ٲٴ� ��)
	//vs 
	//Overloading(�޼ҵ带 ���� �� ���� ����̶�� �޼ҵ���� ����!
	//�Ķ������ �ڷ����� �ٸ��ų�, �Ķ������ ������ �޶�� ��!
	
}
