import java.util.Scanner;

//홀짝 맞추기
public class OMain1 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        //시작
        computer.Start();
        //컴퓨터가 유저한테 동전 중에서 몇 개로 할지 물어보고(즉, 20개중 몇 개로 할지 정한다.)
        computer.askUser();
        //유저가 답하고(동전 개수)20개 중 몇 개 사용할 것인가.
        user.setCoin(user.AnswerCoin());
        //컴퓨터가 동전을 가지고 있고 (20개) 중 몇 개 사용할지 지정
        computer.setCoin(user.coin);
        //컴퓨터가 짤짤이 해서 즉, 몇 개인지 결정
        computer.Result(user.coin);
        //유저한테 홀인지 짝인지 물어보는 구간
        computer.AskEvenOrOdd();
        //답하는 구간
        user.setAnswer(new Scanner(System.in).next());
        //답이 확정 되는 부분
        computer.Result();
        //정답 공개
        computer.Result(user.answer);
    }
}
//컴퓨터가 주도적으로
//컴퓨터 // 유저






// 유저한테 홀/짝 물어보고
//판정