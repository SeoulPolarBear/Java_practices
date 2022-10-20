public class Pioneer extends Person{
    Pioneer(){super();}
    public Pioneer(String role){
        this.Role = role;
    }

    @Override //상대방의 첫말
    public void Said(){
            System.out.printf("%s : 저는 %s 입니다. 그럼 ", Role, Role);
            System.out.println("잘 부탁드립니다.");
        }
    @Override //각자가 재출 혹은 확인하는 정답
    public void Anwser(int answer, String Role){
        System.out.println("===============================================");
        System.out.printf("정답을 %s에게 쪽지로 드립니다.\n",Role);
        this.answer = answer;
    }
}
