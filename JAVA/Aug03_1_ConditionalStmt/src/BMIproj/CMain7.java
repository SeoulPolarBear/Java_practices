package BMIproj;
public class CMain7 {
	public static void main(String[] args){
		Support.startBMI();
		Support.programStart();
		Myprofile myprofile = new Myprofile();
		Support.InputProfile(myprofile);
		myprofile.BMI(myprofile.getHeight(), myprofile.getWeight());
		String result = myprofile.Result(myprofile.getBMI());
		System.out.printf("%s���� %.1fcm %.1fkg�̹Ƿ� %s �Դϴ�.\n ", myprofile.getName(), myprofile.getHeight(),
				myprofile.getWeight(), result);
		System.out.print("���α׷��� �����ϰ� �����ø� Y �����ø� N�� �Է��� �ּ���.");
		try {
			Support.programDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
