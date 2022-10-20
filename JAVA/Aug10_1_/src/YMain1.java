import java.util.Random;
import java.util.Scanner;

public class YMain1 {
    //Up&Down게임(함수 사용 o)
    //컴퓨터 : 1~100 사이의 숫자를 뽑은
    public static int getNumber(){
        return new Random().nextInt(100) + 1;
    }

    //유저가 입력
    public static int setUserNum(){
        System.out.print("값을 입력하세요. : ");
        int answer = new Scanner(System.in).nextInt();
        if (answer < 1) System.out.println("정답은 1 이상이여야 합니다.");
        else if (answer > 100) System.out.println("정답은 100 이하이여야 합니다.");
        return (answer >= 1 && answer <= 100 ? answer: setUserNum());
    }
    // 각각 게임
    public static boolean game(int com, int user, int count){
        if(com > user) {System.out.printf("%d트 : %d -> UP\n", count,user);count++;}
        else if(com < user) {System.out.printf("%d트 : %d -> Down\n", count,user); count++;}
        else {System.out.printf("%d트 : %d -> 정답!\n", count,user);count++; }
        return (com == user);//조건에 맞으면 true 틀리면 false 반환
    }

    public static void printResult(){
        int com = getNumber();
        int count = 1;
        while(true){
            int answer = setUserNum();
          if(game(com,answer, count)){
              System.out.printf("%d번 만에 정답! \n", count);
              break;
          }
          count++;
        }
    }

    public static void main(String[] args) {
        printResult();
    }
}

