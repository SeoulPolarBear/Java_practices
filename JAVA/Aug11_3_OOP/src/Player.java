public class Player extends Person{
    Player(){super();}
    public Player(String role){
        this.Role = role;
    }
    @Override //심판의 첫말
    public void Said(){
            System.out.printf("%s : 저는 %s 입니다. 그럼 ", Role, Role);
            System.out.println("잘 부탁 드립니다.");
    }

    @Override //각자가 재출 혹은 확인하는 정답
    public void Anwser(int answer, String Role){
        this.answer = answer;
        System.out.printf("%s에게 묻습니다. %d가 정답입니까?\n",Role,this.answer);

    }
}
