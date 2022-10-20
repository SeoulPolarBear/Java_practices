import java.util.Random;
import java.util.Scanner;

public class OMain1 {
    public static void main(String[] args) {
        Staff staff = new Staff(0,"심판");
        Pioneer pioneer = new Pioneer("친구");
        Player player = new Player("주인공");
        //각자 인사말
        //친구와 심판이 있는 곳에서 심판이 나와 라고 하면 내가 등장하면 게임이 시작된다.
        //      심판 => 친구 답 요구 : 종이에 답을 적어서 제출
        staff.Said();
        player.Said();
        pioneer.Said();
        //친구가 심판에게 정답 제출
        pioneer.Anwser(new Random().nextInt(100) + 1, staff.Role);
        //심판 정답을 받았다.
        staff.Anwser(pioneer.answer,pioneer.Role);

        while(true){

            System.out.println("질문할 숫자를 입력하겠습니다.");
            player.Anwser(new Scanner(System.in).nextInt(), staff.Role);
            staff.DownOrUp(player.answer);
            System.out.println();
            if(player.answer == pioneer.answer) break;
        }
    }
    //UP Down 게임
    //등장인물 3명
    //심판 , 친구 ,나
    //심판이 주도적으로 끌고 갈 인물
    // 등장인물이 다 등장해야...!
    //상황 설정은 제가각

    // 심판 => 나 답요구 : 말로 대답을 할 것!
    //판정
    // 맞출 때 까지 진행 => 몇 번째 시도만에 정답을 맞췄는지!
}
