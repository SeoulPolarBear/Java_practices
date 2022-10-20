import java.util.Random;
import java.util.Scanner;

public class Computer {
    int totalCoin;
    int coin;

    String result;//홀인지 짝인지
    //시작
    public void Start() {
        System.out.println("게임이 시작됩니다.");
    }
    //컴퓨터가 동전을 가지고 있고 (20개)
    public void setCoin(int coin) {
        System.out.println("컴퓨터가 몇 개수(1~20)를 사용할지 지정됐습니다.");
        System.out.println();
        this.totalCoin = coin;

    }
    //컴퓨터가 유저한테 동전 중에서 몇 개로 할지 물어보고(즉, 20개중 몇 개로 할지 정한다.)
    public void askUser(){
        System.out.println("유저는 1~20개중 동전의 개수가 몇 개인지 정해라.");
    }
    //컴퓨터가 짤짤이 해서 즉, 몇 개인지 결정
    public void Result(int totalCoin){
        this.coin = new Random().nextInt(totalCoin) + 1;
    }//유저한테 물어보는 메소드
    public void AskEvenOrOdd(){
        System.out.println("홀수 인지 짝수 인지 정하시오.");
    }
    public void Result(){
        if(coin%2 == 0){
            this.result = "짝";
        }else this.result = "홀";

    }
    public void Result(String result) {//result는 홀수 인지 짝수 인지 확인
        if(this.result.equals(result)){
            System.out.println("정답!!" + coin + "개를 사용했습니다.");
        }else System.out.println("떙!!" + coin + "개를 사용했습니다.");
    }
}
