
public class PMain2 {

	public static void main(String[] args) {
		/**Escape Sequence(�̽������� ����)
		 * Ư���� ���ڳ� Ư���� ����� ǥ���� ��
		 * \Ư������ : \���� Ư�����ڸ� �Ϲ� ���ڷ� ��� -> ��θ� ������ �� ����Ѵ�. ex)"C:\\Users\\user\\Desktop"
		 * \n : New Line(�ٸ� ���ߴ� �뵵�� ����Ѵ�.)
		 * \t : tabŰ(�� ���ߴ� �뵵)
		 * \b : BackspaceŰ -> ������ Java������ ��� X Java�� Unicode�� ����ϴµ� backspace�� ASCII �ڵ�� ���� 1byte�� ����Ƿ� ��Ʈ�� ������ �ȴ�.
		 * \r : Carriage Return (Ŀ���� �� ������ �����ش�.)
		 * \r\n : enter�� ���� ������ �Ѵ�. 
		 * \0 : ��ĭ(SpaceŰ)
		 * 
		 */ 
		
	
		 /** 
		 * ���� : ������ Ȯ�ο뵵�� ����ϴ� �ܼ�â�̶� \r �̳� \n �� �߿� �ϳ��� �־ enterŰ ó���� ������
		 * ���� ó�� / ��� " \n�̳� \r �ϳ��� ���� �Ǹ�... �� �������� ���� ����
		 * ->��Ŭ���� �ȿ����� \r�� \n�� �����ϱ�� ��ƴ�.
		 * -> \n���� ����ó���� �ϰ�, ���Ŀ� ����ó������ \r,\n�� ����
		 * 
		 * 
		 * \n*/
		
		System.out.println("New Line\n                           " + "\rclass\0"+ " " + "good" + "\t" + "get" + "\b" + "name" );

		
		//\(^_^)/ ���
		System.out.println("\\(^_^)/");
		//\(".")/ ���
		System.out.println("\\(\".\")/");
		
	}

}
