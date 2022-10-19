package BMIproj;
public class CMain7 {
	public static void main(String[] args){
		Support.startBMI();
		Support.programStart();
		Myprofile myprofile = new Myprofile();
		Support.InputProfile(myprofile);
		myprofile.BMI(myprofile.getHeight(), myprofile.getWeight());
		String result = myprofile.Result(myprofile.getBMI());
		System.out.printf("%s님은 %.1fcm %.1fkg이므로 %s 입니다.\n ", myprofile.getName(), myprofile.getHeight(),
				myprofile.getWeight(), result);
		System.out.print("프로그램을 종료하고 싶으시면 Y 싫으시면 N을 입력해 주세요.");
		try {
			Support.programDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
