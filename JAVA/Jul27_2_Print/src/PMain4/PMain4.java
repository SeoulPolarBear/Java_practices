package PMain4;

public class PMain4 {
public static void main(String[] args) throws InterruptedException {
	
	MyName myname = new MyName("Lim",27,"남",183.1,"서울","점토");
	System.out.println("=============================\n");
	System.out.println("             명함\n");
	System.out.println("=============================\n");
	System.out.printf("     %s\n",myname.name);
	System.out.printf("     %d\n",myname.age);
	System.out.printf("     %s\n",myname.gender);
	System.out.printf("     %f\n",myname.height);
	System.out.printf("     %s\n",myname.home);
	System.out.printf("     %s\n",myname.nickname);
	System.out.println("     ======        =======\n");
	System.out.println("   ===    ===        ===\n");
	System.out.println("  ============       ===\n");
	System.out.println(" ===        ===      ===\n");
	System.out.println("===          ===   =======\n");
	
	Thread.sleep(10000);
	
}
}
