import java.util.Calendar;
public class TimeNotice {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		
		String AmOrPm;
		
		if(hourOfDay>=5&&hourOfDay<12) {
			AmOrPm="오전";
		System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Morning!");
		}
		else if(hourOfDay==12) {
			AmOrPm="오후";
			System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Afternoon!");
		}
		else if(hourOfDay>12&&hourOfDay<18) {
			AmOrPm="오후";
			hourOfDay=hourOfDay-12;
			System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Afternoon!");
		}
		else if(hourOfDay>=18&&hourOfDay<22) {
			AmOrPm="오후";
			hourOfDay=hourOfDay-12;
			System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Evening!");
		}
		else if(hourOfDay>=22&&hourOfDay<24) {
			AmOrPm="오후";
			hourOfDay=hourOfDay-12;
			System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Night!");
		}
		else {
			AmOrPm="오전";
			System.out.print("현재 시간은 "+AmOrPm+" "+hourOfDay+"시 "+minute + "분입니다.\n"
					+"Good Night!");
			
			}	
		}
	}
