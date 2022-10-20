import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    //1. 로또 번호는 총 6개 번호를 지정
    int[] num = new int[6];
    int[] answer = new int[6];
    //2. 6개 일치 : 1등... 4개 일치 3등 / 나머지는 : 꽝
    public void Answer(){
        System.out.println("lotto 6자리를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            answer[i] = scan.nextInt();
            while(1 > answer[i] || answer[i] > 45){
                System.out.print("범위초과 입니다. 다시 입력하세요.");
                answer[i] = scan.nextInt();
            }
        }
    }

    public int Score(){
        int count = 0;//몇번 맞췄나 확인
        System.out.print("정답은");
        for (int i:num) {
            System.out.print(i + " ");
        }System.out.println();
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j <answer.length; j++){
                if (num[i] == answer[j]){
                    num[i] = 0;
                    answer[j] = 0;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public void printScore(int count){
        int score = 0;

        switch (count){
            case 6:
            score = 1;
            break;
            case 5:
                score = 2;
                break;
            case 4:
                score = 3;
                break;
            default:
                score = 0;
                break;
        }
        if(score != 0){
            System.out.printf("당신은 %d등 입니다.\n", score);
        }else{
            System.out.println("당신은 꽝 입니다.");
        }

    }



    //3. 1~45까지 정수 랜덤하게
    public void setNum(){
        Random rand = new Random();
        num[0] = rand.nextInt(45) + 1;
        int count = 1;
        boolean check = false;// 중복 확인
        while(count != 6){
            num[count] = rand.nextInt(45) + 1;
            for (int i = 0; i < count; i++){
                if (num[count] != num[i]){
                    check = true;
                    continue;
                }else{
                    check = true;
                    break;
                }

            }
            if(check) count++;// 중복이 없다면 count 1로 올린다.
        }

    }
    //4. 메소드 사용해서!
}
