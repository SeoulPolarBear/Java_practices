
public class CMain1 {
//�Ź� ��ü
	// ����Ű Ȩ������
	// �̸� : ??
	// size
	//����
	//�귣��
	//������ ���
	//======================================
	// ����Ű Ȩ������
	// �̸� : ??
	// size
	//����
	//�귣��
	//������ ���
	//======================================
	public static void main(String[] args) {
		Shoes shoes1 = new Shoes("����Ű ����ƽ� �÷���", 270, 189000); 
		Shoes shoes2 = new Shoes("����Ű ���� �� �䰡���� 39", 270, 139000); 
		Shoes shoes3 = new Shoes(null, 0, 0);
		shoes1.printInfo();
		shoes2.printInfo();
		
		shoes2.test("zzzzz");
		shoes2.test(shoes2.getName());
	}

}
