
public abstract class Runner {
	public int number;
	boolean finished;
	int hours = 0;
	int mins = 0;
	int secs = 0;
	
	public Runner( int pNumber){
	this.number = pNumber;
	this.finished = false;
	}
	
	public void finish( int hours, int mins, int secs) {
	
	this.hours = hours;
	this.mins =  mins;
	this.secs = secs;
	this.finished = true;
	this.result();
	}
	
	void result()
	{
	if (finished)
	System.out.println( this + "������ ���� ���:" + hours + "�� " + mins + "�� " + secs + "��");
	else
	System.out.println( this + "���� �̿���");
	}
	public String toString() {
		return "Runner" + number;
	}

	public int SponsorTotalCount() {
		return 0;
		}
}