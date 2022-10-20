
public class Person {
	private int give;// 내가 낸 수
	private String role;
	private int win;
	private int draw;
	private int lose;

	public Person(String role, int win, int draw, int lose) {
		this.role = role;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
	public int getGive() {
		return give;
	}


	public void setGive(int give) {
		this.give = give;
	}
	
	public void Match(int opponent,int give)
	{// opponent : 상대가 낸 결과(가위1 바위2 보3)
		int result = opponent - give;
		try {
			if(opponent == give) {
				System.out.printf("%s 당신은 비겼습니다.\n", role);
				draw++;
			}
			//===================================
			else if(result == -1 || result == 2 ) {
				System.out.printf("%s 당신은 이겼습니다.\n", role);
				win++;
			}
			else if(result == 1 || result == -2) {
				System.out.printf("%s 당신은 졌습니다. 그리고 현재 %d 승, %d 무를 하고 있습니다.\n",role, win,draw);
				lose++;
			}
			
//			else if(opponent % 3 > give % 3 ) {
//				if(opponent == 2 && give == 3) {
//					System.out.printf("%s 당신은 이겼습니다.\n", role);
//					win++;
//				}
//				else {
//					System.out.printf("%s 당신은 졌습니다. 그리고 현재 %d 승, %d 무를 하고 있습니다.\n",role, win,draw);
//					lose++;
//				}
//				
//			}
//			else if(opponent % 3 < give % 3 ) {
//				if(opponent == 3 && give == 2) {
//					System.out.printf("%s 당신은 졌습니다. 그리고 현재 %d 승, %d 무를 하고 있습니다.\n",role, win,draw);
//					lose++;
//				}
//				else {
//					System.out.printf("%s 당신은 이겼습니다.\n", role);
//					win++;
//				}
//					
//				}
			else{
				System.out.println("이상한 숫자 입력하지 마세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
