import java.util.Calendar;
public class TimeNotice {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		
		String AmOrPm;
		
		if(hourOfDay>=5&&hourOfDay<12) {
			AmOrPm="����";
		System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Morning!");
		}
		else if(hourOfDay==12) {
			AmOrPm="����";
			System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Afternoon!");
		}
		else if(hourOfDay>12&&hourOfDay<18) {
			AmOrPm="����";
			hourOfDay=hourOfDay-12;
			System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Afternoon!");
		}
		else if(hourOfDay>=18&&hourOfDay<22) {
			AmOrPm="����";
			hourOfDay=hourOfDay-12;
			System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Evening!");
		}
		else if(hourOfDay>=22&&hourOfDay<24) {
			AmOrPm="����";
			hourOfDay=hourOfDay-12;
			System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Night!");
		}
		else {
			AmOrPm="����";
			System.out.print("���� �ð��� "+AmOrPm+" "+hourOfDay+"�� "+minute + "���Դϴ�.\n"
					+"Good Night!");
			
			}	
		}
	}
