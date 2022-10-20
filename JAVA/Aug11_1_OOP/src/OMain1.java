import java.util.Scanner;

public class OMain1 {
    public static void main(String[] args) {
        //의사 이름, 나이
        Scanner scan = new Scanner(System.in);
        Person doctor = new Person();
        doctor.setAge(40);
        doctor.setName("림");
        doctor.printInofo();
        // 손님 이름 나이
        Person guest = new Person();
        guest.setAge(32);
        guest.setName("김");
        guest.printInofo();
        System.out.print("키와 몸무게 입력 ");
        System.out.print("키 : ");
        guest.height = scan.nextDouble();
        System.out.print("몸무게 : ");
        guest.weight = scan.nextDouble();
        guest.printBMI(guest.BMI());
    }
}
