interface PhoneInterface{
	final int TIMEOU=10000;
	void sendCall();
	void receiveCall();
	default void printLogo() {
		System.out.println("**phone**");
	}
	
}
class SamsungPhone implements PhoneInterface{
	@Override
	public void sendCall() {
		System.out.println("�츮��������");
	}
	@Override
	public void receiveCall() {
		System.out.println("��ȭ�� �Խ��ϴ�.");
}
public void flash() {
	System.out.println("��ȭ�⿡ ���� �������ϴ�.");
    }
}
	
public class InterfaceEX {

	public static void main(String[] args) {
		SamsungPhone phone=new SamsungPhone();
		phone.printLogo();
		phone.sendCall();
		phone.receiveCall();
		phone.flash();
	}

}
