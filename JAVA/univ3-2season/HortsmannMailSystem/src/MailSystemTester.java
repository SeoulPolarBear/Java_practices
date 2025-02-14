/**
This program tests the mail system. A single phone
communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
private static final int MAILBOX_COUNT = 20;

public static void main(String[] args)
{
MailSystem system = new MailSystem(MAILBOX_COUNT);
Telephone p = new Telephone();
Connection c = new Connection(system, p);
p.run(c);
}
}