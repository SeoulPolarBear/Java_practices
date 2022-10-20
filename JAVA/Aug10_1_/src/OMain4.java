//실행용 Class : 프로그램 실행을 위한 main() method를 제공하는 역할
public class OMain4 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.studentName = "홍길동";
        s1.studentAddress = "서울 서초구";
        Student s2 = s1; //포인터 처럼 완전히 같은 주소값을 가리키고 있다.

        Student s3 = new Student();
        s3.studentName = "김길동";
        s3.studentAddress = "강서구";
        System.out.println(s2);
        s3.showStudentInfo();
    }
}
