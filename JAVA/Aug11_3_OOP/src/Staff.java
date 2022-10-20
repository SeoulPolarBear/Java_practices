public class Staff extends Person {
    int count;
    Staff(){super();}
    public Staff(int count, String role){
        this.count = count;
        this.Role = role;
    }
    @Override //심판의 첫말
    public void Said(){
        if (count == 0){
            System.out.println("===============================================");
            System.out.printf("%s : 저는 %s 입니다. 그럼 ", Role, Role);
            System.out.println("선수 입장!!!!!!!");
            count++;
        }
        else{
            System.out.printf("%d번째 턴입니다.\n", count);
        }
    }@Override //각자가 재출 혹은 확인하는 정답
    public void Anwser(int answer, String Role){
        System.out.printf("정답을 %s에게 받았습니다.\n",Role);
        System.out.println("===============================================");
        this.answer = answer;
    }
    //내가 심판에게 숫자를 제시하면 그거에 맞게 UP Down을 해준다.
    public void DownOrUp(int num){
        if(num == answer) System.out.printf("%d트 만에 정답!!",count);
        else if(num > answer) {
            System.out.printf("%d트 : Down입니다!\n", count);
            count++;
        }
        else{
            System.out.printf("%d트 : Up입니다!\n", count);
            count++;
        }
    }

}
