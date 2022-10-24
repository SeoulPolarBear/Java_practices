//Ŭ���̾�Ʈ�� ĳ���� ���� ����� ����� �޶�� �䱸 ->����µ� ����!
// �ǳ��ִ� ���?
//��� : .java���� ���� .jar���Ϸ� �ǳ����!
//	.java : �ҽ����� ����!
// .jar : �ҽ��� �������� �ʰ� + �� ��ɸ��� ����
// JAR(Java Archive, �ڹ� ��ī�̺�)���� : ���� ���·� �ٲ㼭 ������ �س��� ����

//�ѱ��� - ����(����)-> .java�� ����
//(������ ��) .java���� -����(Compile)-> .class����(���� / ����Ʈ�ڵ�)�� �ڵ����� ����
//.class���� - ���� ->

// �츮�� ���� �ڵ�� .java���Ϸ� ����ǰ�,
// �� �� compile�̶�� �۾��� ���� .class����, �� ����� ��ȯ�Ǿ� �ڵ����� ����
// ����ɶ��� .class�� ���·� JVM(�ڹ� ���� �ӽ�)���� �����Ǵ� ����

//.java ���� : ����� ������ �����
//.class���� : ������ �ڹٿ��� �����ϴ� ��

// �� ���� ? ����/ ����Ʈ�ڵ�� ��ȯ�ؼ� ������ �ɱ�...?
//	-����Ʈ �ڵ带 ����ϸ� ������ ������!
//	-�ҽ��� �����ϰ� �Ǹ� �̰� ���� ���α׷����� �� �� �ֱ� ������ '����'���� ������!
//-> �ٸ� ������� ����� �Ѱ��� �� �ҽ��� �˷����� ����, �� ��ɸ��� ����ϰ� ����!
// -> .java���� ���� jar���Ϸ�!!

//JavaDoc
//JavaDoc�� ���� : ��ǰ ����!
//�츮�� ���� ���α׷��� ���� ��~~~�� HTML����, �츮�� �˰� �ִ� WEB�������� ����
//���� ��~~~�ϰ� ����ȭ ��Ų��!

//JavaDoc�� Ư¡
// - �ּ��� /**(����)*/
//	-�ּ� ������ ũ�� 2������ ����
//		����
//			�ּ��� ���ۿ��� ù��° �±� ���Ǳ����� �κ�
//			������ HTML�� ����Ǳ� ������ �ܼ��� �ּ� �ۼ���ÿ�
//			���͸� �ļ� ���� �ٲ� �Է��ߴ� �ϴ���!
//			�״�� �̾����� ��µ�
//			�ٹٲ�ó���� �ϰ� �ʹٸ� <p>�� �ۼ��ϸ� ��~
//		�±� ����
//			ù��° ���ڰ� '@'�� �����Ѵ�.
//				-@author : �� ���α׷��� �ۼ���, �⺻(default)������ window ���� ID
//				-@version : �� �״�� �� ���α׷��� ����
//				-@param : �Ķ���Ϳ� ���� ������ �� �� ���
//				-@throws : ����ó���� ���� ����
//				-@return : �޼ҵ尡 void�� �ƴ� ��ȯ ���� ���� �� �װͿ� ���� ����

/**
 * @author Lim
 * @version 1.1.14
 * <p>
 * ���� ĳ������ ������ ������ �ִ� Ŭ����
 * */




public class Player {
	private String nickname;
	private int level;
	private String career;
	private String weapon;
	
	/**
	 * ���� ĳ���͸� �����մϴ�.
	 *<p>�⺻ ����� ���� , �⺻ �۾��� �ʺ����Դϴ�.
	 *
	 *@param nickname ĳ������ �̸�: ���̰� 3�� �̻� 10�� �����̾�� �մϴ�.
	 *@throws IllegalArgumentException ĳ������ nickname ���̰� ������ ������ �����, ��{@code nickname < 3 || nickname > 10}�̸� �߻��Ѵ�.
	 * */
	public Player(String nickname) {
		this.nickname = nickname;
		this.level = 1;
		this.career ="�ʺ���";
		this.weapon ="���";
		if(nickname.length() < 3 || nickname.length() > 10) {
			throw new IllegalArgumentException("���̰� 3�� �̻� 10�� �����̾�� �մϴ�.");
		}
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	/**
	 * ĳ������ ������ �÷��ִ� �޼ҵ� �̴�.
	 * */
	public void levelUp() {
		this.level++;
	}
	/**
	 * ĳ������ ������ �����մϴ�.
	 * @param job ĳ������ ������ ����
	 * @throws IllegalArgumentException ĳ���Ͱ� 10������ ���� ������ �߻��Ѵ�.
	 * */
	public void setJob(String job) {
		if(this.level < 10) {
			throw new IllegalArgumentException("ĳ������ ������ 10�� ���� �ʽ��ϴ�.");
		}
	}
	/**
	 * ������ ĳ������ status���� �����ִ� �޼ҵ� �Դϴ�.
	 * */
	public void printInfo() {
		System.out.printf("�ɸ����̸��� %s �̴�.\n",nickname);
		System.out.printf("�ɸ����� ������ %d �̴�.\n", level);
		System.out.printf("�ɸ����� ������ %s �̴�.\n", career);
		System.out.printf("�ɸ����� ����� %s �̴�.\n", weapon);
	}
	}
