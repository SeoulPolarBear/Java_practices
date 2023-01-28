import java.util.ArrayList;

public class MainDemo {

	public static void main(String[] args) {
		ArrayList<Runner> rList = new ArrayList<Runner>();
		SponsershipForm sponsor1 = new SponsershipForm();
		SponsershipForm sponsor2 = new SponsershipForm();
	   int TotalSponsor = 0;
		/*선수 등록*/
	
		Runner p1 = new Professional(174, 17);
		sponsor1.addSponsor("Samsung", 2000);
		sponsor1.addSponsor("LG", 1500);
		sponsor1.addSponsor("SK", 1800);
		
		Runner a1 = new Amateur(77 , sponsor1);
		sponsor2.addSponsor("Yellow Duck", 5000);
		Runner f1 = new FancyDresser(316, sponsor2, "Yellow Duck");
		rList.add(p1);
		rList.add(a1);
		rList.add(f1);
		
		p1.finish(2, 30, 25);
		a1.finish(3, 20, 50);
		f1.finish(3, 55, 45);
		
	}
}
