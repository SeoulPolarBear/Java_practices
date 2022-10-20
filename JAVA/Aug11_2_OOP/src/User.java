import java.util.Scanner;

public class User {
    // 홀짝인지 정하기 위한 coin 개수
    int coin;
    //유저가 답하고(동전 개수)
    String answer;//답할 내용
    public int AnswerCoin(){
        System.out.println("사용할 코인의 개수(1~20)를 입력하세요");
        System.out.print("코인 개수>>");
        this.coin = new Scanner(System.in).nextInt();
        return (20 >= coin && coin >=1) ?
                coin:AnswerCoin();
    }
    public void setCoin(int coin){
        this.coin = coin;
    }
    //답하는 구간
    public void setAnswer(String answer){
        if(answer.equals("짝") || answer.equals("홀")) this.answer = answer;
        else setAnswer(new Scanner(System.in).next());
    }
}
