//지역변수(Local Variable)
//메소드 속에서 만든 변수
// 그 행동을 하는 동안만 필요한 임시변수로...
//메소드 파라미터(Parameter)
//그 행동을 하는데 필요한 재료
// 리턴되는 값
// 그 행동을 한 후의 결과물
//멤버변수(Member Variable)
//그 객체의 속성
public class Person {
  String name;
    int age;
    double weight;
    double height;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printInofo(){
        System.out.println("이름 : " + getName() + " 나이 : " + getAge());
    }
    public double BMI(){
        return weight/Math.pow((height/100),2);
    }
    public void printBMI(double BMI){
        if(BMI < 18.5) System.out.println("당신은 저체중입니다.");
        else if(18.5 <= BMI && BMI <25.0 ) System.out.println("당신은 정상입니다.");
        else if(25.0 <= BMI && BMI <30 ) System.out.println("당신은 과체중입니다.");
        else if(30 <= BMI && BMI <35 ) System.out.println("당신은 경도비만입니다.");
        else if(35 <= BMI && BMI < 4 ) System.out.println("당신은 중증도비만입니다.");
        else System.out.println("당신은 고도비만입니다.");
    }





}
